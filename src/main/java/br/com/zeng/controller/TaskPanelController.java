package br.com.zeng.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.dao.CategoryDao;
import br.com.zeng.dao.TaskPanelDao;
import br.com.zeng.model.Category;
import br.com.zeng.model.TaskPanel;

@Resource
public class TaskPanelController {
	private final Result result;
	private final TaskPanelDao taskPanelDao;
	private final CategoryDao categoryDao;

	public TaskPanelController(TaskPanelDao taskPanelDao, CategoryDao categoryDao, Result result) {
		this.taskPanelDao = taskPanelDao;
		this.categoryDao = categoryDao;
		this.result = result;
	}


	@Post("/addTaskPanel/")
	public void insert(TaskPanel taskPanel, Category category) {
		Category categoryComplete = categoryDao.getCategoryWithId(category.getId());
		taskPanel.setCategory(categoryComplete);
		taskPanelDao.insert(taskPanel);
		result.redirectTo(ProjectController.class).showProject(taskPanel.getProject());
	}

	@Path("/addTaskPanel/{category.id}")
	public Category insertTaskPanelForm(Category category) {
		return category;
	}	

}
