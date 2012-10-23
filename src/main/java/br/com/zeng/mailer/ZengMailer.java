package br.com.zeng.mailer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.zeng.freemarker.FreeMarkerUtils;
import br.com.zeng.model.Action;

public class ZengMailer {
	private final Environment environment;
	private final Mailer mailer;
	private final ServletContext context;
	private Logger logger;

	public ZengMailer(Environment environment, Mailer mailer, ServletContext context) {
		this.environment = environment;
		this.mailer = mailer;
		this.context = context;
		logger = Logger.getLogger(ZengMailer.class);
		BasicConfigurator.configure();
	}
	
	public void montaEEnviaEmail(Action action) {
		Map<String, Object> configuracoes = configuraFreeMarker(action);
		String emailString = parseiaFreemarker(configuracoes);
		ZengEmail email = configureEmail(action, emailString);
		enviaOuLogaEmail(email);
	}

	private ZengEmail configureEmail(Action action, String content) {
		ZengEmail email = new ZengEmail();
		email.setContent(content);
		email.setSubject("Hello! You have a new notification in "+action.getProject().getName()+"!");
		email.setCharset("utf-8");
		email.setFrom("contato.zeng@gmail.com");
		email.setBcc(action.getProject().getContributors());
		return email;
	}

	private Map<String, Object> configuraFreeMarker(Action action) {
		Map<String, Object> configuracoes = new HashMap<String, Object>();
		configuracoes.put("action", action);
		return configuracoes;
	}
	
	private String parseiaFreemarker(Map<String, Object> configuracoes) {
		String pastaTemplates = context.getRealPath("/WEB-INF/templates");
		String emailString;
		try {
			emailString = FreeMarkerUtils.parseTemplate(configuracoes, "zeng-email.ftl", pastaTemplates);
		} catch (Exception e) {
			throw new RuntimeException("An error ocurred while parsing freemarker template",e);
		}
		return emailString;
	}

	private void enviaOuLogaEmail(ZengEmail email) {
		if (environment.getName().equals("production")) {
			enviaEmail(email);
		}else{
			logger.debug("Subject: "+email.getSubject());
			logger.debug("Content: "+email.getContent());
		}
	}

	private void enviaEmail(ZengEmail email) {
		try {
			mailer.send(email.getHtmlEmail());
		} catch (EmailException e) {
			throw new RuntimeException("An error ocurred while sending email",e);
		}
	}	
	
}

