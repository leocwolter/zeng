package br.com.zeng.session;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.zeng.model.User;

public class UserSessionTest {

	@Test
	public void shouldLogInUser() {
		UserSession userSession = new UserSession();
		User user = new User("name", "email", "password", "230.234.234-32");
		userSession.logIn(user);
		
		assertEquals(user, userSession.getUser());
	}
	
	@Test
	public void shouldLogOutUser() {
		UserSession userSession = new UserSession();
		User user = new User("name", "email", "password", "230.234.234-31");
		userSession.logIn(user);
		
		userSession.logOut();
		
		assertEquals(null, userSession.getUser());
		assertFalse(userSession.isLogged());
	}

}
