package br.com.zeng.mailer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.junit.Test;

import br.com.caelum.vraptor.environment.DefaultEnvironment;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.zeng.model.Action;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.User;
import br.com.zeng.model.action.StartAction;

public class ZengMailerTest {
	

	@Test
	public void shouldParseFreemarkerWithoutException() throws IOException {
		DefaultEnvironment env = new DefaultEnvironment("test");
		Mailer mailer = mock(Mailer.class);
		ServletContext context = mock(ServletContext.class);
		when(context.getRealPath("/WEB-INF/templates")).thenReturn("src/main/webapp/WEB-INF/templates");
		
		ZengMailer zengMailer = new ZengMailer(env, mailer, context);
		
		User author = new User("Leonardo", "leocwolter@gmail.com", "123456");
		Project zeng = new Project("Zeng");
		zeng.addContributor(new User("Hi","leocwolter@gmail.com","12345"));
		Category backEnd = new Category(zeng, "Back-End");
		TaskList refactor = new TaskList(backEnd);
		Task email = new Task(refactor, "Refactor email method");
		zengMailer.montaEEnviaEmail(new Action(author, email, new StartAction()));
	}

}
