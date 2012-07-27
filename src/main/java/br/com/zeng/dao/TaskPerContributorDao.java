package br.com.zeng.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.TaskPerContributor;
import br.com.zeng.model.User;

@Component
public class TaskPerContributorDao {
	private final Session session;

	public TaskPerContributorDao(Session session) {
		this.session = session;
	}

	public void insert(TaskPerContributor taskPerContributor) {
		session.save(taskPerContributor);
	}

	public List<TaskPerContributor> getDataWithUsers(List<User> contributors) {
		List<TaskPerContributor> data = new ArrayList<TaskPerContributor>();
		for (User user : contributors) {
			@SuppressWarnings("unchecked")
			List<TaskPerContributor> datum = session.createCriteria(TaskPerContributor.class).add(Restrictions.eq("contributor.id", user.getId())).list();
			data.addAll(datum);
		}
		return data;
	}

}
