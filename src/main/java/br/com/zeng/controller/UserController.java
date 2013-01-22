package br.com.zeng.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.UserDao;
import br.com.zeng.infra.Cryptographer;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;
import br.com.zeng.validator.UserValidator;

@Resource
public class UserController {
	
	private static final String GRAVATAR_URL = "http://www.gravatar.com/avatar/";
	private final Result result;
	private final UserSession userSession;
	private final UserValidator userValidator;
	private final UserDao userDao;
	private Cryptographer cripto;

	public UserController(Result result,
			UserDao userDao,
			UserSession userSession,
			UserValidator userValidator,
			Cryptographer cripto
			) {
		this.result = result;
		this.userDao = userDao;
		this.userSession = userSession;
		this.userValidator = userValidator;
		this.cripto = cripto;
	}

	@Get("/index")
	public void home() {
	}
	
	@Post("/register")
	public void register(User user) {
		userValidator.validate(user);
		String password = cripto.cryptoSha256(user.getPassword());
		user.setPassword(password);
		String photo = cripto.cryptoMd5(user.getEmail());
		user.setPhoto(GRAVATAR_URL+photo);
		userDao.insert(user);
		userSession.logIn(user);
		result.redirectTo(ProjectController.class).listProjects();
	}
	
	@Post("/login")
	public void logIn(User user) {
		String password = cripto.cryptoSha256(user.getPassword());
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

	@LoggedUser
	@Get("/user/editForm")
	public void editForm() {
	}
	
	@LoggedUser
	@Get("/user/profile/{userId}")
	public void profile(Long userId){
		User user = userDao.getById(userId);
		result.include("user", user);
	}

	
	@Post("/user/profile/edit")
	public void edit(User editedUser) throws FileNotFoundException, IOException {
		User user = userSession.getUser();
		if(validField(editedUser.getPassword())){
			String password = cripto.cryptoSha256(editedUser.getPassword());
			user.setPassword(password);
		}
		user.setEmail(editedUser.getEmail());
		user.setName(editedUser.getName());
		userDao.update(user);
		result.include("confirmacao","Edition Completed Successfully!");
		result.redirectTo(ProjectController.class).listProjects();
	}

	private boolean validField(String field) {
		return field != null && !field.isEmpty();
	}

	
}
