package br.com.zeng.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.dao.UserDao;
import br.com.zeng.infra.Criptografador;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;
import br.com.zeng.validator.UserValidator;

@Resource
public class UserController {
	
	private final Result result;
	private final UserSession userSession;
	private final UserValidator userValidator;
	private final UserDao userDao;
	private Criptografador cripto;

	public UserController(Result result, UserDao userDao, UserSession userSession, UserValidator userValidator, Criptografador cripto) {
		this.result = result;
		this.userDao = userDao;
		this.userSession = userSession;
		this.userValidator = userValidator;
		this.cripto = cripto;
	}

	@Get("/")
	public void home() {
	}
	
	@Post("/register")
	public void register(User user) {
		String password = cripto.criptografa(user.getPassword());
		user.setPassword(password);
		userDao.insert(user);
		userSession.logIn(user);
		result.redirectTo(ProjectController.class).listProjects();
	}
	
	@Post("/login")
	public void logIn(User user) {
		String password = cripto.criptografa(user.getPassword());
		User registredUser = userDao.getRegistredUser(user.getEmail(),password) ;
		userValidator.validate(registredUser);
		userSession.logIn(registredUser);
		result.redirectTo(ProjectController.class).listProjects();
	}
	
	@Get("/logout")
	public void logOut() {
		userSession.logOut();
		result.redirectTo(UserController.class).home();
	}

	@Get("/purchase")
	public void purchase(User user) {
	}
}
