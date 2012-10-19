package br.com.zeng.simplecaptcha;

import static nl.captcha.Captcha.NAME;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class SimpleCaptcha {
	private final HttpServletRequest req;

	public SimpleCaptcha(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
	}
	
	public boolean isCorrect(String answer){
		Captcha captcha = (Captcha) req.getSession().getAttribute(NAME);
		return captcha.isCorrect(answer);
	}
}
