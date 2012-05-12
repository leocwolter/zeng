package br.com.zeng.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.zeng.model.Project;
import br.com.zeng.model.User;

public class ProjectDaoTest extends DaoTest{

	private ProjectDao projectDao;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		projectDao = new ProjectDao(session);
	}
	
	@Test
	public void shouldReturnOnlyProjectsWithTheSpecifiedUser() {
	
		User user = new User("user","user@user.com","password");
		session.save(user);
		
		Project project = new Project();
		project.addContributor(user);
		session.save(project);

		Project project2 = new Project();
		session.save(project2);
		
		assertEquals(1, projectDao.listProjectsWithUser(user).size());
	
	}

}
