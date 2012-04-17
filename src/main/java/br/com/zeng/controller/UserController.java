package br.com.zeng.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.Project;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;
import br.com.zeng.validator.UserValidator;

@Resource
public class UserController {
	
	private final Result result;
	private final ProjectDao projectDao;
	private final UserSession userSession;
	private final UserValidator userValidator;
	private final UserDao userDao;

	public UserController(Result result, UserDao userDao, ProjectDao projectDao, UserSession userSession, UserValidator userValidator) {
		this.result = result;
		this.userDao = userDao;
		this.projectDao = projectDao;
		this.userSession = userSession;
		this.userValidator = userValidator;
	}
	
	@Post("/login/")
	public void logIn(User user) {
		User registredUser = userDao.getRegistredUser(user.getEmail(),user.getPassword()) ;
		userValidator.validate(registredUser);
		userSession.logIn(registredUser);
		result.redirectTo(UserController.class).listProjects();
	}
	
	@Path("/projects/")
	public void listProjects() {
		List<Project> listProjectsWithUser = projectDao.listProjectsWithUser(userSession.getUser());
		result.include("projects", listProjectsWithUser);
	}
	
}
