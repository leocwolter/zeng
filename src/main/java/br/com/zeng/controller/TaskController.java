
package br.com.zeng.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import org.joda.time.DateTime;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.NotificationDao;
import br.com.zeng.dao.TaskDao;
import br.com.zeng.dao.TaskListDao;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.Notification;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;

@Resource
public class TaskController {
	private final TaskDao taskDao;
	private final Result result;
	private final TaskListDao taskListDao;
	private final UserSession userSession;
	private final NotificationDao notificationDao;
	private final UserDao userDao;

	public TaskController(TaskDao taskDao, TaskListDao taskListDao,
			UserSession userSession,
			NotificationDao notificationDao, Result result, UserDao userDao) {
		this.taskDao = taskDao;
		this.taskListDao = taskListDao;
		this.result = result;
		this.userSession = userSession;
		this.notificationDao = notificationDao;
		this.userDao = userDao;
	}

	@Post("/taskList/addTask")
	public void insert(Task task, String expirationDate) {
		configureExpirationDate(task, expirationDate);
		TaskList taskList = taskListDao.getTaskListWithId(task.getTaskList().getId());
		List<User> contributors = userDao.getCompleteContributorsById(task.getContributors());
		task.setTaskList(taskList);
		task.setContributors(contributors);
		taskDao.insert(task);
		
		String stringNotification = "Added the task "+task.getName()+" on the list "+task.getTaskList().getName()+" of the category "+task.getCategory().getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(), task.getProject());
		notificationDao.insert(notification);
		
		result.use(json()).from(task)
							.include("contributors")
							.include("taskList")
							.include("taskList.category")
							.include("taskList.category.project")
							.include("expirationDate")
							.serialize();
	}

	private void configureExpirationDate(Task task, String expirationDate) {
		if(!expirationDate.isEmpty()){
			DateTime expirationDateTime = new DateTime(expirationDate);
			task.setExpirationDate(expirationDateTime);
		}
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
		return taskDao.getWithId(task.getId());
	}
	
	@LoggedUser
	@Path("/task/startTask/{taskId}")
	public void start(Long taskId) {
		Task taskComplete = taskDao.getWithId(taskId);
		if (taskComplete.isFinalized()) throw new RuntimeException("A completed task can not be initiated");
		
		taskComplete.start();
		taskDao.start(taskComplete);
		
		String stringNotification = "Started the task "+taskComplete.getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
		notificationDao.insert(notification);
		
		result.use(Results.page()).of(TaskController.class).startedTask();
	}
	
	@LoggedUser
	@Path("/task/finalizeTask/{taskId}")
	public void finalize(Long taskId) {
		Task taskComplete = taskDao.getWithId(taskId);
		if (taskComplete.isFinalized()) throw new RuntimeException("This task has already been completed");
		
		taskDao.finalize(taskComplete);
	
		String stringNotification = "Completed the task "+taskComplete.getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
		notificationDao.insert(notification);
		
		result.use(Results.page()).of(TaskController.class).finalizedTask();
	}

	@LoggedUser
	@Path("/task/stopTask/{taskId}")
	public void stop(Long taskId) {
		Task taskComplete = taskDao.getWithId(taskId);
		if (taskComplete.isFinalized()) throw new RuntimeException("A completed task can not be stopped");
			
		taskComplete.stop();
		taskDao.stop(taskComplete);
	
		String stringNotification = "Stopped the task "+taskComplete.getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
		notificationDao.insert(notification);
	
		result.use(Results.page()).of(TaskController.class).stoppedTask();
	}

	@LoggedUser
	@Path("/task/moveTask")
	public void moveTask(Task task, TaskList taskList) {
		Task taskComplete = taskDao.getWithId(task.getId());
		TaskList taskListComplete = taskListDao.getTaskListWithId(taskList.getId());
		
		taskComplete.setTaskList(taskListComplete);
		taskDao.update(taskComplete);
		
		String stringNotification = "Moved the task "+taskComplete.getName()+" to the list "+taskListComplete.getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
		notificationDao.insert(notification);
	
		result.nothing();
	}
	
	@LoggedUser
	@Post("/task/archive/{taskId}")
	public void archive(Long taskId) {
		Task task = taskDao.getWithId(taskId);
		taskDao.archive(task);

		String stringNotification = "Archived the task "+task.getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(), task.getProject());
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
