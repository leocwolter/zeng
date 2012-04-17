package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.TaskPanel;
import br.com.zeng.model.User;

@Component
public class UserDao {
	private final Session session;

	public UserDao(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<TaskPanel> getUserById(Long id) {
		return session.createCriteria(User.class).add(Restrictions.eq("id", id)).list();
	}

	public User getUser(User user) {
		Criteria returnedUser = session.createCriteria(User.class).add(Restrictions.eq("email", user.getEmail()))
				.add(Restrictions.eq("password", user.getPassword()));
		return (User) returnedUser.uniqueResult();
	}

}
