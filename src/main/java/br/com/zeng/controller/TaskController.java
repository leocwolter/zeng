package br.com.zeng.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.TaskDao;
import br.com.zeng.dao.TaskPanelDao;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskPanel;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;

@Resource
public class TaskController {
	private final TaskDao taskDao;
	private final Result result;
	private final TaskPanelDao taskPanelDao;
	private final UserDao userDao;
	private final UserSession userSession;

	public TaskController(TaskDao taskDao,TaskPanelDao taskPanelDao, UserDao userDao, Result result, UserSession userSession) {
		this.taskDao = taskDao;
		this.taskPanelDao = taskPanelDao;
		this.userDao = userDao;
		this.result = result;
		this.userSession = userSession;
	}


	@Post("/taskpanel/task/add")
	public void insert(Task task, TaskPanel taskPanel, List<User> contributors) {
		if(contributors != null) {
			List<User> completeContributorsByList = userDao.getCompleteContributorsById(contributors);			
			task.setContributors(completeContributorsByList);
		}
		
		TaskPanel taskPanelComplete = taskPanelDao.getTaskPanelWithId(taskPanel.getId());
		task.setTaskPanel(taskPanelComplete);
		
		taskDao.insert(task);
		result.redirectTo(ProjectController.class).showProject(task.getProject());
	}

	@LoggedUser
	@Path("/taskpanel/addTask/{taskPanel.id}")
	public void insertTaskForm(TaskPanel taskPanel) {
		TaskPanel taskPanelComplete = taskPanelDao.getTaskPanelWithId(taskPanel.getId());
		result.include("taskPanel",taskPanelComplete);
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
		if(!taskComplete.isFinalized()) {
			taskComplete.start();
			taskDao.update(taskComplete);
		}
		result.redirectTo(ProjectController.class).showProject(taskComplete.getProject());
	}

	@LoggedUser
	@Path("/task/finalizeTask/{task.id}")
	public void finalize(Task task) {
		Task taskComplete = taskDao.getTaskWithId(task.getId());
		if(!taskComplete.isFinalized()) {
			User user = userSession.getUser();
			user.incrementFinalizedTasks();
			userDao.update(user);

			taskComplete.finalize();
			taskDao.update(taskComplete);
		}
		result.redirectTo(ProjectController.class).showProject(taskComplete.getProject());
	}

	@LoggedUser
	@Path("/task/todoTask/{task.id}")
	public void stop(Task task) {
		Task taskComplete = taskDao.getTaskWithId(task.getId());
		if(!taskComplete.isFinalized()) {
			taskComplete.stop();
			taskDao.update(taskComplete);
		}
		result.redirectTo(ProjectController.class).showProject(taskComplete.getProject());
	}
	

}
