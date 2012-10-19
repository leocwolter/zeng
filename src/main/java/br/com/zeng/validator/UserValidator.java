package br.com.zeng.validator;

import java.util.List;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.zeng.controller.UserController;
import br.com.zeng.model.User;

@Component
public class UserValidator {

	private final Validator validator;
	private final CPFValidator cpfValidator;

	public UserValidator(Validator validator, CPFValidator cpfValidator) {
		this.validator = validator;
		this.cpfValidator = cpfValidator;
	}

	public void validate(User user) {
		if(user == null) {
			validator.add(new ValidationMessage("Invalid User", "error"));
		}else{
			List<br.com.caelum.stella.ValidationMessage> invalidMessages = cpfValidator.invalidMessagesFor(user.getCpf());
			for (br.com.caelum.stella.ValidationMessage validationMessage : invalidMessages) {
				validator.add(new ValidationMessage(validationMessage.getMessage(), "error"));
			}
		}
		validator.onErrorRedirectTo(UserController.class).home();
	}
}
