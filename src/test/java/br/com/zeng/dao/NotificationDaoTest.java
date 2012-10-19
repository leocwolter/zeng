package br.com.zeng.dao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import br.com.zeng.model.Notification;
import br.com.zeng.model.Project;
import br.com.zeng.model.User;

public class NotificationDaoTest extends DaoTest {
	private NotificationDao notificationDao;
	private Project project;

	@Before
	public void setUp() {
		super.setUp();
		notificationDao = new NotificationDao(session);
		project = new Project();
		session.save(project);

		Project project2 = new Project();
		session.save(project2);
		
		User author = new User("Leonardo", "leo@leo.com", "123");
		session.save(author);
		
		Notification notification = new Notification("Test", author, project);
		notificationDao.insert(notification);
		Notification notification2 = new Notification("Test2", author, project);
		notificationDao.insert(notification2);
		Notification notification3 = new Notification("Test2", author, project2);
		notificationDao.insert(notification3);

	}
	
	
	@Test
	public void shouldGetAllNotificationsOfAProject() {
		List<Notification> notificationsOfProject = notificationDao.getNotificationsOfProject(project);
		assertEquals(2, notificationsOfProject.size());
	}

	@Test
	public void shouldGetNotificationsOfAProjectWithTheNewerFirst() {
		List<Notification> notificationsOfProject = notificationDao.getNotificationsOfProject(project);
		
		DateTime dataDaPrimeiraNotificacao = notificationsOfProject.get(0).getCreationDate();
		DateTime dataDaSegundaNotificacao = notificationsOfProject.get(1).getCreationDate();
		
		assertTrue(dataDaPrimeiraNotificacao.isAfter(dataDaSegundaNotificacao));
	}

}
