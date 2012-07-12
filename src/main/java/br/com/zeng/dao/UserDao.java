package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.User;

@Component
public class UserDao {
	private final Session session;

	public UserDao(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<TaskList> getUserById(Long id) {
		return session.createCriteria(User.class).add(Restrictions.eq("id", id)).list();
	}

	public User getRegistredUser(String email, String password) {
		return (User) session.createCriteria(User.class)
				.add(Restrictions.and(Restrictions.like("email", email), Restrictions.like("password",password)))
				.uniqueResult();
	}

	public List<User> getCompleteContributorsById(List<User> contributors) {
		for (User user : contributors) {
			user = (User) session.get(User.class,user.getId());
		}
		return contributors;
	}

	public void update(User user) {
		session.update(user);
	}

	public User getUserByEmail(User user) {
		return (User) session.createCriteria(User.class).add(Restrictions.like("email", user.getEmail())).uniqueResult();
	}

	public void register(User user) {
		session.save(user);
	}

}
