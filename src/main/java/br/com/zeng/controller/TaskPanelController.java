package br.com.zeng.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.CategoryDao;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.dao.TaskPanelDao;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.TaskPanel;

@Resource
public class TaskPanelController {
	private final Result result;
	private final TaskPanelDao taskPanelDao;
	private final CategoryDao categoryDao;
	private final ProjectDao projectDao;

	public TaskPanelController(TaskPanelDao taskPanelDao, CategoryDao categoryDao, ProjectDao projectDao, Result result) {
		this.taskPanelDao = taskPanelDao;
		this.categoryDao = categoryDao;
		this.projectDao = projectDao;
		this.result = result;
	}


	@Post("/addTaskPanel/")
	public void insert(TaskPanel taskPanel, Long categoryId) {
		Category category = categoryDao.getCategoryWithId(categoryId);
		taskPanel.setCategory(category);
		taskPanelDao.insert(taskPanel);
		result.redirectTo(ProjectController.class).showProject(taskPanel.getProject());
	}

	@LoggedUser
	@Path("/addTaskPanel/{projectId}")
	public Project insertTaskPanelForm(Long projectId) {
		return projectDao.getProjectWithId(projectId);
	}	

}
