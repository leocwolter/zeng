package br.com.zeng.infra;


import java.net.URL;
import java.util.Properties;

import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.zeng.model.Action;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.Step;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.User;
import br.com.zeng.model.action.AddAction;
import br.com.zeng.model.action.ArchiveAction;
import br.com.zeng.model.action.FinalizeAction;
import br.com.zeng.model.action.MoveAction;
import br.com.zeng.model.action.StartAction;
import br.com.zeng.model.action.StopAction;

@Component
@ApplicationScoped
public class SessionFactoryCreator implements ComponentFactory<SessionFactory> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SessionFactoryCreator.class);
	private Configuration cfg;

	public SessionFactoryCreator(Environment env) {
		URL xml = env.getResource("/hibernate.cfg.xml");
		LOGGER.info("Loading hibernate xml from " + xml);
		this.cfg = new Configuration().configure(xml);
		
		String databaseUrl = System.getenv("DATABASE_URL");
		LOGGER.info("env got " + databaseUrl);
		if (databaseUrl != null) {
			LOGGER.info("ready to use heroku database");
			HerokuDatabaseInformation info = new HerokuDatabaseInformation(
					databaseUrl);
			Properties heroku = info.exportToProperties();
			LOGGER.info(heroku.toString());
			cfg.addProperties(heroku);
		}		

		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Project.class);
		cfg.addAnnotatedClass(Category.class);
		cfg.addAnnotatedClass(Task.class);
		cfg.addAnnotatedClass(TaskList.class);
		cfg.addAnnotatedClass(Step.class);
		cfg.addAnnotatedClass(Action.class);
		cfg.addAnnotatedClass(AddAction.class);
		cfg.addAnnotatedClass(ArchiveAction.class);
		cfg.addAnnotatedClass(MoveAction.class);
		cfg.addAnnotatedClass(FinalizeAction.class);
		cfg.addAnnotatedClass(StartAction.class);
		cfg.addAnnotatedClass(StopAction.class);

		init();
	}

	private void init() {
		this.factory = cfg.buildSessionFactory();
	}

	private SessionFactory factory;

	public SessionFactory getInstance() {
		return factory;
	}

	@PreDestroy
	void destroy() {
		if(!factory.isClosed()) {
		factory.close();
		}
		factory = null;
	}

	
	public Configuration getCfg() {
		return cfg;
	}
}