package br.com.zeng.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.CategoryDao;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.dao.TaskListDao;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.TaskList;

@Resource
public class TaskListController {
	private final Result result;
	private final TaskListDao taskListDao;
	private final CategoryDao categoryDao;
	private final ProjectDao projectDao;

	public TaskListController(TaskListDao taskListDao, CategoryDao categoryDao, ProjectDao projectDao, Result result) {
		this.taskListDao = taskListDao;
		this.categoryDao = categoryDao;
		this.projectDao = projectDao;
		this.result = result;
	}


	@Post("/addTaskPanel/")
	public void insert(TaskList taskList, Long categoryId) {
		Category category = categoryDao.getCategoryWithId(categoryId);
		taskList.setCategory(category);
		taskListDao.insert(taskList);
		result.redirectTo(ProjectController.class).showProject(taskList.getProject());
	}

	@LoggedUser
	@Path("/addTaskPanel/{projectId}")
	public Project insertTaskListForm(Long projectId) {
		return projectDao.getProjectWithId(projectId);
	}	

}
