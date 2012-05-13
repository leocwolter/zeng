package br.com.zeng.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.dao.TaskDao;
import br.com.zeng.dao.TaskPanelDao;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskPanel;

@Resource
public class TaskController {
	private final TaskDao taskDao;
	private final Result result;
	private final TaskPanelDao taskPanelDao;

	public TaskController(TaskDao taskDao,TaskPanelDao taskPanelDao, Result result) {
		this.taskDao = taskDao;
		this.taskPanelDao = taskPanelDao;
		this.result = result;
	}


	@Post("/taskpanel/task/add")
	public void insert(Task task, TaskPanel taskPanel) {
		TaskPanel taskPanelComplete = taskPanelDao.getTaskPanelWithId(taskPanel.getId());
		task.setTaskPanel(taskPanelComplete);
		taskDao.insertTask(task);
		result.redirectTo(ProjectController.class).listProjects();
	}

	@Path("/taskpanel/addTask/{taskPanel.id}")
	public TaskPanel insertTaskForm(TaskPanel taskPanel) {
		return taskPanel;
	}	

}
