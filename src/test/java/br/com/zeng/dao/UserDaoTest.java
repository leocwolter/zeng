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

	@Override
	@Before
	public void setUp() {
		super.setUp();
		userDao = new UserDao(session);
		userDao.insert(new User("user", "user@user.com", "password"));
		userDao.insert(new User("user2", "user2@user.com", "password2"));
	}

	@Test
	public void shouldReturnACompleteUser() {
		User registredUser = userDao.getRegistredUser("user@user.com", "password");
		assertNotNull(registredUser);
		assertEquals("user@user.com", registredUser.getEmail());
		assertEquals("user", registredUser.getName());
		assertEquals("password", registredUser.getPassword());
	}
	
	@Test
	public void shouldIterateAndReturnAListOfCompleteUsers() {
		User user1 = new User();
		user1.setId(1L);

		User user2 = new User();
		user2.setId(2L);
		
		List<User> registredUsers = userDao.getCompleteContributorsById(Arrays.asList(user1, user2));
		assertEquals(2, registredUsers.size());

	}

	@Test
	public void shouldNotLogInWithWrongPasswordOrEmail() {
		User registredUser = userDao.getRegistredUser("user@invalid.com", "password");
		User registredUser2 = userDao.getRegistredUser("user@user.com", "invalidPassword");
		
		assertNull(registredUser);
		assertNull(registredUser2);

	}
	
}
