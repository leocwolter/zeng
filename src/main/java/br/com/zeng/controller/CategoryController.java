package br.com.zeng.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.CategoryDao;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;

@Resource
public class CategoryController {
	private final Result result;
	private final ProjectDao projectDao;
	private final CategoryDao categoryDao;

	public CategoryController(CategoryDao categoryDao, ProjectDao projectDao, Result result) {
		this.categoryDao = categoryDao;
		this.projectDao = projectDao;
		this.result = result;
	}


	@Post("/addCategory/")
	public void insert(Category category, Long projectId) {
		Project project = projectDao.getProjectWithId(projectId);
		category.setProject(project);
		categoryDao.insert(category);
		result.redirectTo(ProjectController.class).showProject(category.getProject());
	}

	@LoggedUser
	@Path("/addCategory/{projectId}")
	public void insertCategoryForm(Long projectId) {
		result.include("projectId", projectId);
	}	

}
