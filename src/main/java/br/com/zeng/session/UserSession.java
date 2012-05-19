package br.com.zeng.session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.zeng.model.User;

@SessionScoped
@Component
public class UserSession {

	private User user;

	public User getUser() {
		return user;
	}

	public void logIn(User user) {
		this.user = user;
	}

	public void logOut() {
		this.user = null;
	}

	public boolean isLogged() {
		return user != null;
	}
}
