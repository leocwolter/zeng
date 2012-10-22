package br.com.zeng.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.ActionDao;
import br.com.zeng.dao.CategoryDao;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.model.Action;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.action.AddAction;
import br.com.zeng.session.UserSession;

@Resource
public class CategoryController {
	private final Result result;
	private final ProjectDao projectDao;
	private final CategoryDao categoryDao;
	private final UserSession userSesion;
	private final ActionDao actionDao;

	public CategoryController(CategoryDao categoryDao, ProjectDao projectDao, Result result, UserSession userSesion, ActionDao actionDao) {
		this.categoryDao = categoryDao;
		this.projectDao = projectDao;
		this.result = result;
		this.userSesion = userSesion;
		this.actionDao = actionDao;
	}


	@Post("/addCategory/")
	public void insert(Category category, String projectUrl) {
		Project project = projectDao.getProjectWithUrl(projectUrl);
		category.setProject(project);
		categoryDao.insert(category);
		Action action = new Action(userSesion.getUser(),category,new AddAction(project));
		actionDao.insert(action);
		result.use(json()).from(category).serialize();
	}

	@LoggedUser
	@Path("/addCategoryForm/{projectUrl}")
	public void insertCategoryForm(String projectUrl) {
		result.include("projectUrl", projectUrl);
	}	
	
	@LoggedUser
	@Get("/project/category/{categoryId}")
	public void getCategory(Long categoryId) {
		Category category = categoryDao.getCategoryWithId(categoryId);
		result.include("currentCategory", category);
		result.forwardTo(ProjectController.class).showProject(category.getProject());
	}

}
