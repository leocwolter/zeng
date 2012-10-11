package br.com.zeng.controller;

import static org.apache.commons.io.IOUtils.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
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
	private final Environment env;

	public UserController(Result result, UserDao userDao,
			UserSession userSession,
			UserValidator userValidator,
			Criptografador cripto,
			Environment env) {
		this.result = result;
		this.userDao = userDao;
		this.userSession = userSession;
		this.userValidator = userValidator;
		this.cripto = cripto;
		this.env = env;
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
	
	@Get("/editForm")
	public void editForm() {
	}
	
	@Post("/edit")
	public void edit(UploadedFile userPhoto) throws FileNotFoundException, IOException {
		String photoPath = env.get("user.photo.path")+File.separator+userPhoto.getFileName();
		FileOutputStream userPhotoOutput = new FileOutputStream(photoPath);
		copy(userPhoto.getFile(), userPhotoOutput);
		User user = userSession.getUser();
		user.setPhoto(userPhoto.getFileName());
		userDao.update(user);
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
