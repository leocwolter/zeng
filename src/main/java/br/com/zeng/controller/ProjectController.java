package br.com.zeng.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.dao.TaskDao;
import br.com.zeng.dao.TaskPerContributorDao;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.Notification;
import br.com.zeng.model.Project;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskPerContributor;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;

@Resource
public class ProjectController {
	private final Result result;
	private final ProjectDao projectDao;
	private final UserSession userSession;
	private final UserDao userDao;
	private TaskPerContributorDao taskPerContributorDao;
	private final TaskDao taskDao;

	public ProjectController(Result result, ProjectDao projectDao, UserSession userSession, UserDao userDao, TaskPerContributorDao taskPerContributorDao, TaskDao taskDao) {
		this.result = result;
		this.projectDao = projectDao;
		this.userSession = userSession;
		this.userDao = userDao;
		this.taskPerContributorDao =  taskPerContributorDao;
		this.taskDao = taskDao;
	}

	@LoggedUser
	@Path("/project/{project.url}")
	public void showProject(Project project) {
		Project projectCompleted = projectDao.getProjectWithUrl(project.getUrl());
		result.include("project", projectCompleted);
	}

	@LoggedUser
	@Path("/projects")
	public void listProjects() {
		List<Project> listProjectsWithUser = projectDao.listProjectsWithUser(userSession.getUser());
		result.include("projects", listProjectsWithUser);
	}

	@LoggedUser
	@Post("/addProject")
	public void insert(Project project, List<User> contributors) {
		for (User contributor : contributors) {
			project.addContributor(userDao.getUserByEmail(contributor));
		}
		project.addContributor(userSession.getUser());
		projectDao.insert(project);
		result.use(json()).from(project).serialize();
	}

	@LoggedUser
	@Get("/addProjectForm")
	public void insertProjectForm() {
	}

	@LoggedUser
	@Path("/project/{project.url}/showChart")
	public void showChart() {
	}

	@LoggedUser
	@Get("/project/{project.url}/getTasksPerContributors")
	public void getTasksPerContributors(Project project) {
		Project projectComplete = projectDao.getProjectWithUrl(project.getUrl());
		List<User> contributors = projectComplete.getContributors();
		List<TaskPerContributor> tasksPerContributors = taskPerContributorDao.getDataWithUsers(contributors);
		
		result.use(json()).from(tasksPerContributors, "tasksPerContributors").include("contributor","task","dateOfCompletion").serialize();
	}
	
	@LoggedUser
	@Get("/project/{project.url}/updateNotifications")
	public void updateNotifications(Project project){
		Project projectComplete = projectDao.getProjectWithUrl(project.getUrl());

		List<Notification> notifications = projectComplete.getNotifications();
		
		result.use(json()).from(notifications, "notifications").include("author").serialize();
	}
	
	@LoggedUser
	@Get("/project/search/{project.url}")
	public void searchTasksWithContent(String q, Project project){
		List<Task> tasks = taskDao.getTasksWithContentInAProject(q, project);
		result.include("tasksFound",tasks);
		result.include("project",projectDao.getProjectWithUrl(project.getUrl()));
	}
	
}
