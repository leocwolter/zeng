package br.com.zeng.validator;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.zeng.controller.ZengController;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.User;

@Component
public class UserValidator {

	private final Validator validator;
	private final UserDao userDao;

	public UserValidator(Validator validator, UserDao userDao) {
		this.validator = validator;
		this.userDao = userDao;
	}
	
	public void validate(User user) {
		if(user == null) {
			validator.add(new ValidationMessage("Usuario invalido", "error"));
		}else if(userDao.getUser(user) == null) {
			validator.add(new ValidationMessage("Email ou Senha invalidos", "error"));
		}
		validator.onErrorRedirectTo(ZengController.class).loginForm();
	}
}
