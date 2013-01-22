package br.com.zeng.dao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import br.com.zeng.mailer.ZengMailer;
import br.com.zeng.model.Action;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.User;
import br.com.zeng.model.action.AddAction;

public class ActionDaoTest extends DaoTest {
	private ActionDao actionDao;
	private Project zeng;

	@Before
	public void setUp() {
		super.setUp();
		ZengMailer mailer = mock(ZengMailer.class);
		actionDao = new ActionDao(session, mailer);
		zeng = new Project("Zeng");
		session.save(zeng);

		Category backEnd = new Category(zeng, "Back-End");
		TaskList refactor = new TaskList(backEnd);
		Task cleanCode = new Task(refactor, "Clean Code");

		Project trello = new Project("Trello");
		session.save(trello);
		
		Category frontEnd = new Category(trello, "Front-End");
		TaskList refactorJavascript = new TaskList(frontEnd);
		Task cleanJavascript = new Task(refactorJavascript, "Clean Javascript");
		
		User leonardo = new User("Leonardo", "leo@leo.com", "12345678", "photo");
		session.save(leonardo);
		
		Action Action = new Action(leonardo, cleanCode, new AddAction(refactorJavascript));
		actionDao.insert(Action);
		Action Action2 = new Action(leonardo, cleanCode, new AddAction(refactorJavascript));
		actionDao.insert(Action2);
		Action Action3 = new Action(leonardo, cleanJavascript, new AddAction(refactorJavascript));
		actionDao.insert(Action3);

	}
	
	@Test
	public void shouldGetAllActionsOfAProject() {
		List<Action> actionsOfProject = actionDao.getActionsOf(zeng);
		assertEquals(2, actionsOfProject.size());
	}

	@Test
	public void shouldGetActionsOfAProjectWithTheNewerFirst() {
		List<Action> actionsOfProject = actionDao.getActionsOf(zeng);
		
		DateTime dataDaPrimeiraNotificacao = actionsOfProject.get(0).getCreationDate();
		DateTime dataDaSegundaNotificacao = actionsOfProject.get(1).getCreationDate();
		
		assertTrue(dataDaPrimeiraNotificacao.isAfter(dataDaSegundaNotificacao));
	}

}
