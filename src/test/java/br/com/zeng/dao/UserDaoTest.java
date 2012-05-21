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
	}

	@Test
	public void shouldReturnACompleteUser() {
		session.save(new User("user", "user@user.com", "password"));
		session.save(new User("user2", "user2@user.com", "password2"));

		User registredUser = userDao.getRegistredUser("user@user.com", "password");

		assertNotNull(registredUser);

		assertEquals("user@user.com", registredUser.getEmail());
		assertEquals("user", registredUser.getName());
		assertEquals("password", registredUser.getPassword());
	}
	
	@Test
	public void shouldIterateAndReturnAListOfCompleteUsers() {
		session.save(new User("user", "user@user.com", "password"));
		session.save(new User("user2", "user2@user.com", "password2"));

		User user1 = new User();
		user1.setId(1L);

		User user2 = new User();
		user2.setId(2L);
		
		List<User> registredUsers = userDao.getCompleteContributorsByList(Arrays.asList(user1, user2));
		assertEquals(2, registredUsers.size());

	}

	@Test
	public void shouldNotLogInWithWrongPasswordOrEmail() {
		session.save(new User("user", "user@user.com", "password"));
		session.save(new User("user2", "user2@user.com", "password2"));
		
		User registredUser = userDao.getRegistredUser("user@invalid.com", "password");
		User registredUser2 = userDao.getRegistredUser("user@user.com", "invalidPassword");
		
		assertNull(registredUser);
		assertNull(registredUser2);

	}
	
}
