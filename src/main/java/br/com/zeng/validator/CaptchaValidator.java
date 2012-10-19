package br.com.zeng.validator;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.zeng.controller.UserController;
import br.com.zeng.simplecaptcha.SimpleCaptcha;

@Component
public class CaptchaValidator {

	
	private final Validator validator;

	public CaptchaValidator(Validator validator) {
		this.validator = validator;
	}
	
	public void validate(SimpleCaptcha captcha, String answer){
		if(!captcha.isCorrect(answer)){
			validator.add(new ValidationMessage("Incorrect Captcha", "error"));
		}
		validator.onErrorRedirectTo(UserController.class).home();
	}
}
