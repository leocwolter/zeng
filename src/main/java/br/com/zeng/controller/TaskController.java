package br.com.zeng.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.dao.TaskDao;
import br.com.zeng.dao.TaskPanelDao;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskPanel;
import br.com.zeng.model.User;

@Resource
public class TaskController {
	private final TaskDao taskDao;
	private final Result result;
	private final TaskPanelDao taskPanelDao;
	private final UserDao userDao;

	public TaskController(TaskDao taskDao,TaskPanelDao taskPanelDao, UserDao userDao, Result result) {
		this.taskDao = taskDao;
		this.taskPanelDao = taskPanelDao;
		this.userDao = userDao;
		this.result = result;
	}


	@Post("/taskpanel/task/add")
	public void insert(Task task, TaskPanel taskPanel, List<User> contributors) {
		System.out.println(contributors.size());
		List<User> completeContributorsByList = userDao.getCompleteContributorsByList(contributors);
		TaskPanel taskPanelComplete = taskPanelDao.getTaskPanelWithId(taskPanel.getId());
		
		task.setContributors(completeContributorsByList);
		task.setTaskPanel(taskPanelComplete);
		
		taskDao.insert(task);
		result.redirectTo(ProjectController.class).listProjects();
	}

	@Path("/taskpanel/addTask/{taskPanel.id}")
	public void insertTaskForm(TaskPanel taskPanel) {
		TaskPanel taskPanelComplete = taskPanelDao.getTaskPanelWithId(taskPanel.getId());
		result.include("taskPanel",taskPanelComplete);
	}	
	
	@Path("/task/{task.id}")
	public Task showTask(Task task) {
		return taskDao.getTaskWithId(task.getId());
	}	
	
	

}
