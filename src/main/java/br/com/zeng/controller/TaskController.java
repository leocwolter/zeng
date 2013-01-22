
package br.com.zeng.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import org.joda.time.DateTime;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.ActionDao;
import br.com.zeng.dao.TaskDao;
import br.com.zeng.dao.TaskListDao;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.Action;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.User;
import br.com.zeng.model.action.AddAction;
import br.com.zeng.model.action.ArchiveAction;
import br.com.zeng.model.action.FinalizeAction;
import br.com.zeng.model.action.MoveAction;
import br.com.zeng.model.action.StartAction;
import br.com.zeng.model.action.StopAction;
import br.com.zeng.session.UserSession;

@Resource
public class TaskController {
	private final TaskDao taskDao;
	private final Result result;
	private final TaskListDao taskListDao;
	private final UserSession userSession;
	private final ActionDao actionDao;
	private final UserDao userDao;

	public TaskController(TaskDao taskDao, TaskListDao taskListDao,
			UserSession userSession,
			ActionDao notificationDao, Result result, UserDao userDao) {
		this.taskDao = taskDao;
		this.taskListDao = taskListDao;
		this.result = result;
		this.userSession = userSession;
		this.actionDao = notificationDao;
		this.userDao = userDao;
	}

	@Post("/addTask")
	public void insert(Task task, String expirationDate) {
		configureExpirationDate(task, expirationDate);
		TaskList taskList = taskListDao.getWithId(task.getTaskList().getId());
		List<User> contributors = userDao.getCompleteContributorsById(task.getContributors());
		task.setTaskList(taskList);
		task.setContributors(contributors);
		taskDao.insert(task);
		
		Action action = new Action(userSession.getUser(),task, new AddAction(taskList));
		actionDao.insert(action);

		result.use(json()).from(task)
							.include("contributors")
							.include("taskList")
							.include("taskList.category")
							.include("taskList.category.project")
							.include("expirationDate")
							.serialize();

	}

	private void configureExpirationDate(Task task, String expirationDate) {
		if(expirationDate != null && !expirationDate.isEmpty()){
			DateTime expirationDateTime = new DateTime(expirationDate);
			task.setExpirationDate(expirationDateTime);
		}
	}

	@LoggedUser
	@Path("/project/category/taskList/{taskListId}/addTaskForm")
	public void insertTaskForm(Long taskListId) {
		TaskList taskList = taskListDao.getWithId(taskListId);
		result.include("taskList", taskList);
	}

	@LoggedUser
	@Path("/project/category/taskList/task/{task.id}")
	public Task showTask(Task task) {
		return taskDao.getWithId(task.getId());
	}
	
	@LoggedUser
	@Path("/project/category/taskList/task/{taskId}/startTask")
	public void start(Long taskId) {
		Task taskComplete = taskDao.getWithId(taskId);
		if (taskComplete.isFinalized()) throw new RuntimeException("A completed task can not be initiated");
		
		taskComplete.start();
		taskDao.start(taskComplete);
		
		Action action = new Action(userSession.getUser(), taskComplete, new StartAction());
		actionDao.insert(action);
		
		result.forwardTo(TaskController.class).startedTask(taskComplete);
	}
	
	@LoggedUser
	@Path("/project/category/taskList/task/{taskId}/finalizeTask")
	public void finalize(Long taskId) {
		Task taskComplete = taskDao.getWithId(taskId);
		if (taskComplete.isFinalized()) throw new RuntimeException("This task has already been completed");
		
		taskDao.finalize(taskComplete);
	
		Action action = new Action(userSession.getUser(), taskComplete, new FinalizeAction());
		actionDao.insert(action);
		
		result.forwardTo(TaskController.class).finalizedTask(taskComplete);
	}

	@LoggedUser
	@Path("/project/category/taskList/task/{taskId}/stopTask")
	public void stop(Long taskId) {
		Task taskComplete = taskDao.getWithId(taskId);
		if (taskComplete.isFinalized()) throw new RuntimeException("A completed task can not be stopped");
			
		taskComplete.stop();
		taskDao.stop(taskComplete);
	
		Action action = new Action(userSession.getUser(), taskComplete, new StopAction());
		actionDao.insert(action);
	
		result.forwardTo(TaskController.class).stoppedTask(taskComplete);
	}

	@LoggedUser
	@Path("/project/category/taskList/task/moveTask")
	public void moveTask(Task task, TaskList taskList) {
		Task taskComplete = taskDao.getWithId(task.getId());
		TaskList taskListComplete = taskListDao.getWithId(taskList.getId());
		
		taskComplete.setTaskList(taskListComplete);
		taskDao.update(taskComplete);
		
		Action action = new Action(userSession.getUser(),taskComplete, new MoveAction(taskListComplete));
		actionDao.insert(action);
	
		result.nothing();
	}
	
	@LoggedUser
	@Path("/project/{projectUrl}/category/taskList/task/{taskId}/archiveTask")
	public void archive(String projectUrl, Long taskId) {
		Task task = taskDao.getWithId(taskId);
		taskDao.archive(task);

		Action action = new Action(userSession.getUser(), task, new ArchiveAction());
		actionDao.insert(action);
		
		result.redirectTo(CategoryController.class).showCategory(task.getCategory().getUrl(), projectUrl);
	}
	
	public void startedTask(Task task) {
		result.include("taskId", task.getId());
	}
	
	public void stoppedTask(Task task) {
		result.include("taskId", task.getId());
	}
	
	public void finalizedTask(Task task) {
		result.include("taskId", task.getId());
	}
}
