package br.com.zeng.dao;

import static org.junit.Assert.assertEquals;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;

import br.com.zeng.model.Project;
import br.com.zeng.model.User;

public class ProjectDaoTest extends DaoTest {

	private ProjectDao projectDao;
	private Project zeng;
	private User user;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		projectDao = new ProjectDao(session);

		user = new User("user", "user@user.com", "password");
		session.save(user);

		zeng = new Project("Zeng");
		zeng.setUrl("zeng");
		zeng.addContributor(user);
		projectDao.insert(zeng);

		Project projectWithWrongName = new Project("wrong name");
		projectWithWrongName.setUrl("project-two");
		projectDao.insert(projectWithWrongName);
	}

	@Test
	public void shouldReturnOnlyProjectsWithTheSpecifiedUser() {
		assertEquals(1, projectDao.listProjectsWithUser(user).size());
	}

	@Test
	public void shouldReturnACompleteProjectUsingUrl() {
		Project projectComplete = projectDao.getProjectWithUrl(zeng.getUrl());
		assertEquals(zeng.getName(), projectComplete.getName());
		assertEquals(zeng.getUrl(), projectComplete.getUrl());
	}

	@Test
	public void shouldReturnAProjectById() {
		Project projectComplete = projectDao.getWithId(zeng.getId());
		assertEquals(zeng.getName(), projectComplete.getName());
		assertEquals(zeng.getUrl(), projectComplete.getUrl());
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void shouldThrowExceptionIfExistAProjectWithSameName() {
		Project projectWithSameName = new Project(zeng.getName());
		projectDao.insert(projectWithSameName);
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void shouldThrowExceptionIfExistAProjectWithSameUrl() {
		Project anotherZeng = new Project("Another Zeng");
		anotherZeng.setUrl(zeng.getUrl());
		projectDao.insert(anotherZeng);
	}

}
