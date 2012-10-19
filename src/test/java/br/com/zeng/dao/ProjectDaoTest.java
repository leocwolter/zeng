package br.com.zeng.dao;

import static org.junit.Assert.assertEquals;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;

import br.com.zeng.model.Project;
import br.com.zeng.model.User;

public class ProjectDaoTest extends DaoTest {

	private ProjectDao projectDao;
	private Project project;
	private User user;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		projectDao = new ProjectDao(session);

		user = new User("user", "user@user.com", "password", "230.234.234-32");
		session.save(user);

		String url = "project-one";
		String correctName = "Project One";

		project = new Project();
		project.setUrl(url);
		project.setName(correctName);
		project.addContributor(user);
		projectDao.insert(project);

		String urlTwo = "project-two";
		String incorrectName = "wrong name";

		Project project2 = new Project();
		project2.setUrl(urlTwo);
		project2.setName(incorrectName);
		projectDao.insert(project2);
	}

	@Test
	public void shouldReturnOnlyProjectsWithTheSpecifiedUser() {
		assertEquals(1, projectDao.listProjectsWithUser(user).size());
	}

	@Test
	public void shouldReturnACompleteProjectUsingUrl() {
		Project projectComplete = projectDao.getProjectWithUrl(project.getUrl());
		assertEquals(project.getName(), projectComplete.getName());
		assertEquals(project.getUrl(), projectComplete.getUrl());
	}

	@Test
	public void shouldReturnAProjectById() {
		Project projectComplete = projectDao.getProjectWithId(project.getId());
		assertEquals(project.getName(), projectComplete.getName());
		assertEquals(project.getUrl(), projectComplete.getUrl());
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void shouldThrowExceptionIfExistAProjectWithSameName() {
		Project projectWithSameName = new Project();
		projectWithSameName.setName(project.getName());
		projectDao.insert(projectWithSameName);
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void shouldThrowExceptionIfExistAProjectWithSameUrl() {
		Project projectWithSameUrl = new Project();
		projectWithSameUrl.setUrl(project.getUrl());
		projectDao.insert(projectWithSameUrl);
	}

}
