package br.com.zeng.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;
import br.com.zeng.validator.UserValidator;

@Resource
public class UserController {
	
	private final Result result;
	private final ProjectDao projectDao;
	private final UserSession userSession;
	private final UserValidator userValidator;

	public UserController(Result result, ProjectDao projectDao, UserSession userSession, UserValidator userValidator) {
		this.result = result;
		this.projectDao = projectDao;
		this.userSession = userSession;
		this.userValidator = userValidator;
	}
	
	@Post("/login/")
	public void logIn(User user) {
		userValidator.validate(user);
		userSession.logIn(user);
		result.redirectTo(UserController.class).listProjects();
	}
	
	@Path("/projects/")
	public void listProjects() {
		result.include("projects", projectDao.listWithUser(userSession.getUser()));
	}
	
}
