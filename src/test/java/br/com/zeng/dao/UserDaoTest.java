package br.com.zeng.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.zeng.model.User;

public class UserDaoTest extends DaoTest {

	private UserDao userDao;
	private User leonardo;
	private User enzo;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		userDao = new UserDao(session);
		leonardo = new User("Leonardo", "leo@user.com", "password");
		userDao.insert(leonardo);
		enzo = new User("Enzo", "enzo@user.com", "password2");
		userDao.insert(enzo);
	}

	@Test
	public void shouldReturnACompleteUser() {
		User registredUser = userDao.getRegistredUser("leo@user.com", "password");
		assertNotNull(registredUser);
		assertEquals("leo@user.com", registredUser.getEmail());
		assertEquals("Leonardo", registredUser.getName());
		assertEquals("password", registredUser.getPassword());
	}
	
	@Test
	public void shouldIterateAndReturnAListOfCompleteUsers() {
		List<User> registredUsers = userDao.getCompleteContributorsById(Arrays.asList(leonardo, enzo));
		assertEquals(2, registredUsers.size());
		assertEquals("leo@user.com", registredUsers.get(0).getEmail());
		assertEquals("Leonardo", registredUsers.get(0).getName());
		assertEquals("enzo@user.com", registredUsers.get(1).getEmail());
		assertEquals("Enzo", registredUsers.get(1).getName());
		
	}

	@Test
	public void shouldNotLogInWithWrongPasswordOrEmail() {
		User registredUser = userDao.getRegistredUser("user@invalid.com", "password");
		User registredUser2 = userDao.getRegistredUser("user@user.com", "invalidPassword");
		
		assertNull(registredUser);
		assertNull(registredUser2);

	}
	
}
