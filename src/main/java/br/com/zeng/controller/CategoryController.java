package br.com.zeng.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
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
	public void insert(Category category, Project project) {
		Project projectComplete = projectDao.getProjectWithId(project.getId());
		category.setProject(projectComplete);
		categoryDao.insert(category);
		result.redirectTo(ProjectController.class).showProject(project);
	}

	@Path("/addCategory/{project.id}")
	public Project insertCategoryForm(Project project) {
		return project;
	}	

}
