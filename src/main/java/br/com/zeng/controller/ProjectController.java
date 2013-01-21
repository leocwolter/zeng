package br.com.zeng.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import org.joda.time.DateTime;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.environment.Environment;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.chart.UserTasksPerMonth;
import br.com.zeng.dao.ActionDao;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.dao.TaskDao;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.Action;
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
	private final ActionDao actionDao;
	private final Environment env;

	public ProjectController(Result result, ProjectDao projectDao,
			UserSession userSession, UserDao userDao, TaskDao taskDao,
			ActionDao actionDao, Environment env) {
		this.result = result;
		this.projectDao = projectDao;
		this.userSession = userSession;
		this.userDao = userDao;
		this.taskDao = taskDao;
		this.actionDao = actionDao;
		this.env = env;
	}

	@LoggedUser
	@Path("/project/{projectUrl}")
	public void showProject(String projectUrl) {
		Project projectCompleted = projectDao.getProjectWithUrl(projectUrl);
		result.include("project", projectCompleted);
		result.include("url", env.get("user.photo.path"));
		if(taskDao.manyTasksWithSameExpirationDate(projectCompleted)){
			result.include("warning", "There are many tasks with the same expiration date!");
		}
	
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
		result.use(json()).from(project, "insertedElement").serialize();
	}

	@LoggedUser
	@Get("/addProjectForm")
	public void insertProjectForm() {
	}

	@LoggedUser
	@Path("/project/{projectUrl}/showChart")
	public void showChart() {
	}

	@LoggedUser
	@Get("/project/{projectUrl}/getTasksPerContributors")
	public void getQuantityOfTasksPerMonth(String projectUrl) {
		Project projectComplete = projectDao.getProjectWithUrl(projectUrl);
		List<UserTasksPerMonth> quantityOfTasksPerMonth = taskDao.getQuantityOfTasksGroupedByDateAndUser(projectComplete);
		result.use(json()).from(quantityOfTasksPerMonth, "quantityOfTasksPerMonth")
								.recursive()
								.serialize();
	}

	@LoggedUser
	@Get("/project/{project.id}/getActions")
	public void getActions(Project project){
		List<Action> actions = actionDao.getActionsOf(project);
		result.use(json()).from(actions, "actions").include("author").include("creationDate").serialize();
	}

	@LoggedUser
	@Get("/project/search/{projectUrl}")
	public void searchTasksWithContent(String q, String projectUrl) {
		Project project = projectDao.getProjectWithUrl(projectUrl);
		List<Task> tasks = taskDao.getTasksWithContentInAProject(q, project.getId());
		result.include("tasksFound", tasks);
		result.include("project", project);
	}
	
	@LoggedUser
	@Get("/project/{projectUrl}/manyTasksWithExpirationDate")
	public void manyTasksWithThis(String projectUrl, Long dateInMillis){
		DateTime expirationDate = new DateTime(dateInMillis);
		Project project = projectDao.getProjectWithUrl(projectUrl);
		boolean manyTasks = taskDao.manyTasksInAProjectWith(expirationDate, project);
		result.use(json()).from(manyTasks).serialize();
	}

}
