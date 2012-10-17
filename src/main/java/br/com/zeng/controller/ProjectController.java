package br.com.zeng.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.environment.Environment;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.chart.UserTasksPerMonth;
import br.com.zeng.dao.NotificationDao;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.dao.TaskDao;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.Notification;
import br.com.zeng.model.Project;
import br.com.zeng.model.Task;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;

@Resource
public class ProjectController {
	private final Result result;
	private final ProjectDao projectDao;
	private final UserSession userSession;
	private final UserDao userDao;
	private final TaskDao taskDao;
	private final NotificationDao notificationDao;
	private final Environment env;

	public ProjectController(Result result, ProjectDao projectDao,
			UserSession userSession, UserDao userDao, TaskDao taskDao,
			NotificationDao notificationDao, Environment env) {
		this.result = result;
		this.projectDao = projectDao;
		this.userSession = userSession;
		this.userDao = userDao;
		this.taskDao = taskDao;
		this.notificationDao = notificationDao;
		this.env = env;
	}

	@LoggedUser
	@Path("/project/{project.url}")
	public void showProject(Project project) {
		Project projectCompleted = projectDao.getProjectWithUrl(project.getUrl());
		result.include("project", projectCompleted);
		result.include("url", env.get("user.photo.path"));
		if(taskDao.manyTasksWithSameExpirationDate(projectCompleted)){
			result.include("warning", "There are many tasks with the same expiration date!");
		}
	
	}

	@LoggedUser
	@Path("/projects")
	public void listProjects() {
		List<Project> listProjectsWithUser = projectDao
				.listProjectsWithUser(userSession.getUser());
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
	public void getQuantityOfTasksPerMonth(Project project) {
		Project projectComplete = projectDao.getProjectWithUrl(project.getUrl());
		List<UserTasksPerMonth> quantityOfTasksPerMonth = taskDao.getQuantityOfTasksGroupedByDateAndUser(projectComplete);
		result.use(json()).from(quantityOfTasksPerMonth, "quantityOfTasksPerMonth")
								.recursive()
								.serialize();
	}

	@LoggedUser
	@Get("/project/{project.id}/updateNotifications")
	public void updateNotifications(Project project){
		List<Notification> notifications = notificationDao.getNotificationsOfProject(project);
		result.use(json()).from(notifications, "notifications").include("author").include("creationDate").serialize();
	}

	@LoggedUser
	@Get("/project/search/{projectUrl}")
	public void searchTasksWithContent(String q, String projectUrl) {
		List<Task> tasks = taskDao.getTasksWithContentInAProject(q, projectUrl);
		result.include("tasksFound", tasks);
		result.include("project", projectDao.getProjectWithUrl(projectUrl));
	}
	
}
