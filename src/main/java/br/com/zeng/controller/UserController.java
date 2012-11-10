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
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.UserDao;
import br.com.zeng.infra.Criptografador;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;
import br.com.zeng.simplecaptcha.SimpleCaptcha;
import br.com.zeng.validator.CaptchaValidator;
import br.com.zeng.validator.UserValidator;

@Resource
public class UserController {
	
	private final Result result;
	private final UserSession userSession;
	private final UserValidator userValidator;
	private final UserDao userDao;
	private Criptografador cripto;
	private final Environment env;
	private final SimpleCaptcha captcha;
	private final CaptchaValidator captchaValidator;

	public UserController(Result result,
			UserDao userDao,
			UserSession userSession,
			UserValidator userValidator,
			Criptografador cripto,
			Environment env,
			SimpleCaptcha captcha,
			CaptchaValidator captchaValidator
			) {
		this.result = result;
		this.userDao = userDao;
		this.userSession = userSession;
		this.userValidator = userValidator;
		this.cripto = cripto;
		this.env = env;
		this.captcha = captcha;
		this.captchaValidator = captchaValidator;
	}

	@Get("/")
	public void home() {
	}
	
	@Post("/register")
	public void register(User user, String captchaAnswer) {
		captchaValidator.validate(captcha, captchaAnswer);
		userValidator.validate(user);
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
	public void edit(UploadedFile userPhoto, User editedUser) throws FileNotFoundException, IOException {
		User user = userSession.getUser();
		if(validField(editedUser.getPassword())){
			String password = cripto.criptografa(editedUser.getPassword());
			user.setPassword(password);
		}
		user.setEmail(editedUser.getEmail());
		user.setName(editedUser.getName());
		if (userPhoto != null) {
			String photoHash = cripto.criptografa(userPhoto.getFileName());
			copyPhoto(userPhoto, photoHash);
			user.setPhoto(photoHash);
		}
		userDao.update(user);
		result.include("confirmacao","Edition Completed Successfully!");
		result.redirectTo(ProjectController.class).listProjects();
	}

	private void copyPhoto(UploadedFile userPhoto, String photoHash) throws FileNotFoundException, IOException {
		String photoPath = env.get("user.photo.path")+File.separator+photoHash;
		FileOutputStream userPhotoOutput = new FileOutputStream(photoPath);
		copy(userPhoto.getFile(), userPhotoOutput);
	}
	
	private boolean validField(String field) {
		return field != null && !field.isEmpty();
	}

	
}
