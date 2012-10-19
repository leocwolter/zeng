package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.User;

@Component
public class UserDao {
	private final Session session;

	public UserDao(Session session) {
		this.session = session;
	}

	public User getUserById(Long id) {
		return (User) session.createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	public User getRegistredUser(String email, String password) {
		return (User) session.createCriteria(User.class)
				.add(Restrictions.and(Restrictions.like("email", email), Restrictions.like("password",password)))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> getCompleteContributorsById(List<User> contributors) {
		if(contributors.isEmpty()) return contributors;
		return session.createQuery("from User u where u in :contributors")
						.setParameterList("contributors",contributors)
						.list();
	}

	public void update(User user) {
		session.update(user);
	}

	public User getUserByEmail(User user) {
		return (User) session.createCriteria(User.class).add(Restrictions.like("email", user.getEmail())).uniqueResult();
	}

	public void insert(User user) {
		session.save(user);
	}
	
}
