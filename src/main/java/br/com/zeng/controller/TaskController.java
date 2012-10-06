
package br.com.zeng.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.NotificationDao;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.dao.TaskDao;
import br.com.zeng.dao.TaskListDao;
import br.com.zeng.dao.TaskPerContributorDao;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.Notification;
import br.com.zeng.model.Project;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.TaskPerContributor;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;

@Resource
public class TaskController {
	private final TaskDao taskDao;
	private final Result result;
	private final TaskListDao taskListDao;
	private final UserDao userDao;
	private final UserSession userSession;
	private TaskPerContributorDao taskPerContributorDao;
	private final NotificationDao notificationDao;
	private final ProjectDao projectDao;

	public TaskController(TaskDao taskDao, TaskListDao taskListDao, UserDao userDao,
			UserSession userSession, TaskPerContributorDao taskPerContributorDao,
			NotificationDao notificationDao,ProjectDao projectDao, Result result) {
		this.taskDao = taskDao;
		this.taskListDao = taskListDao;
		this.userDao = userDao;
		this.projectDao = projectDao;
		this.result = result;
		this.userSession = userSession;
		this.taskPerContributorDao = taskPerContributorDao;
		this.notificationDao = notificationDao;
	}

	@Post("/taskList/addTask")
	public void insert(Task task, Long taskListId, List<User> contributors) {
		if (contributors != null) {
			List<User> completeContributorsByList = userDao.getCompleteContributorsById(contributors);
			task.setContributors(completeContributorsByList);
		}

		TaskList taskList = taskListDao.getTaskListWithId(taskListId);
		task.setTaskList(taskList);
		taskDao.insert(task);

		String stringNotification = "Adicionou a task "+task.getName()+" na lista "+taskList.getName()+" da categoria "+taskList.getCategory().getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),task.getProject());
		notificationDao.insert(notification);
		
		result.use(json()).from(task).serialize();
	}

	@LoggedUser
	@Get("/project/search/{project.url}")
	public void searchTasksWithContent(String q, Project project){
		List<Task> tasks = taskDao.getTasksWithContentInAProject(q, project);
		result.include("tasksFound",tasks);
		result.include("project",projectDao.getProjectWithUrl(project.getUrl()));
	}
	
	@LoggedUser
	@Path("/taskList/addTaskForm/{taskListId}")
	public void insertTaskForm(Long taskListId) {
		TaskList taskList = taskListDao.getTaskListWithId(taskListId);
		result.include("taskList", taskList);
	}

	@LoggedUser
	@Path("/task/{task.id}")
	public Task showTask(Task task) {
		return taskDao.getTaskWithId(task.getId());
	}

	@LoggedUser
	@Path("/task/startTask/{task.id}")
	public void start(Task task) {
		Task taskComplete = taskDao.getTaskWithId(task.getId());
		if (!taskComplete.isFinalized()) {
			taskComplete.start();
			taskDao.update(taskComplete);
		}
		
		String stringNotification = "Começou a task "+taskComplete.getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
		notificationDao.insert(notification);
		result.use(Results.page()).of(TaskController.class).startedTask();
	}
	
	@LoggedUser
	@Path("/task/finalizeTask/{task.id}")
	public void finalize(Task task) {
		Task taskComplete = taskDao.getTaskWithId(task.getId());
		if (!taskComplete.isFinalized()) {
			User user = userSession.getUser();
			
			TaskPerContributor taskPerContributor = new TaskPerContributor(user, taskComplete);
			taskPerContributorDao.insert(taskPerContributor);

			taskComplete.finalize();
			taskDao.update(taskComplete);
		
			String stringNotification = "Finalizou a task "+taskComplete.getName();
			Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
			notificationDao.insert(notification);
			
		}
		result.use(Results.page()).of(TaskController.class).finalizedTask();
	}

	@LoggedUser
	@Path("/task/todoTask/{task.id}")
	public void stop(Task task) {
		Task taskComplete = taskDao.getTaskWithId(task.getId());
		if (!taskComplete.isFinalized()) {
			taskComplete.stop();
			taskDao.update(taskComplete);
		
			String stringNotification = "Parou a task "+taskComplete.getName();
			Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
			notificationDao.insert(notification);
		
		}
		result.use(Results.page()).of(TaskController.class).stoppedTask();
	}

	@LoggedUser
	@Path("/task/moveTask")
	public void moveTask(Task task, TaskList taskList) {
		Task taskComplete = taskDao.getTaskWithId(task.getId());
		TaskList taskListComplete = taskListDao.getTaskListWithId(taskList.getId());
		
		taskComplete.setTaskList(taskListComplete);
		taskDao.update(taskComplete);
		
		String stringNotification = "Moveu a task "+taskComplete.getName()+" para a lista "+taskListComplete.getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
		notificationDao.insert(notification);
	
		result.nothing();
	}
	
	public void startedTask() {
	}
	
	public void stoppedTask() {
	}
	
	public void finalizedTask() {
	}
}
