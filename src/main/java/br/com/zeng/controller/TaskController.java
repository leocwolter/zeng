
package br.com.zeng.controller;

import static br.com.caelum.vraptor.view.Results.json;

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
import br.com.zeng.model.Notification;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.session.UserSession;

@Resource
public class TaskController {
	private final TaskDao taskDao;
	private final Result result;
	private final TaskListDao taskListDao;
	private final UserSession userSession;
	private final NotificationDao notificationDao;

	public TaskController(TaskDao taskDao, TaskListDao taskListDao,
			UserSession userSession,
			NotificationDao notificationDao, Result result) {
		this.taskDao = taskDao;
		this.taskListDao = taskListDao;
		this.result = result;
		this.userSession = userSession;
		this.notificationDao = notificationDao;
	}

	@Post("/taskList/addTask")
	public void insert(Task task, Long taskListId, String expirationDate) {
		DateTime expirationDateTime = new DateTime(expirationDate);
		task.setExpirationDate(expirationDateTime);
		TaskList taskList = taskListDao.getTaskListWithId(taskListId);
		task.setTaskList(taskList);
		taskDao.insert(task);
		
		String stringNotification = "Adicionou a task "+task.getName()+" na lista "+taskList.getName()+" da categoria "+taskList.getCategory().getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),task.getProject());
		notificationDao.insert(notification);
		
		result.use(json()).from(task).serialize();
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
	@Path("/task/startTask/{taskId}")
	public void start(Long taskId) {
		Task taskComplete = taskDao.getTaskWithId(taskId);
		if (taskComplete.isFinalized()) throw new RuntimeException("Uma tarefa finalizada não pode ser iniciada");
		
		taskComplete.start();
		taskDao.start(taskComplete);
		
		String stringNotification = "Começou a task "+taskComplete.getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
		notificationDao.insert(notification);
		
		result.use(Results.page()).of(TaskController.class).startedTask();
	}
	
	@LoggedUser
	@Path("/task/finalizeTask/{taskId}")
	public void finalize(Long taskId) {
		Task taskComplete = taskDao.getTaskWithId(taskId);
		if (taskComplete.isFinalized()) throw new RuntimeException("Essa tarefa ja foi finalizada");
		
		taskDao.finalize(taskComplete);
	
		String stringNotification = "Finalizou a task "+taskComplete.getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
		notificationDao.insert(notification);
		
		result.use(Results.page()).of(TaskController.class).finalizedTask();
	}

	@LoggedUser
	@Path("/task/stopTask/{taskId}")
	public void stop(Long taskId) {
		Task taskComplete = taskDao.getTaskWithId(taskId);
		if (taskComplete.isFinalized()) throw new RuntimeException("uma tarefa finalizada nao pode ser parada");
			
		taskComplete.stop();
		taskDao.stop(taskComplete);
	
		String stringNotification = "Parou a task "+taskComplete.getName();
		Notification notification = new Notification(stringNotification, userSession.getUser(),taskComplete.getProject());
		notificationDao.insert(notification);
	
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
	
	@LoggedUser
	@Post("/task/archive/{taskId}")
	public void archive(Long taskId) {
		Task task = taskDao.getTaskWithId(taskId);
		taskDao.archive(task);

		String stringNotification = "Arquivou a task "+task.getName();
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
