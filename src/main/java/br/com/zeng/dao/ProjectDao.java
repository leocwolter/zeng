package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Project;
import br.com.zeng.model.User;

@Component
public class ProjectDao {

	private final Session session;

	public ProjectDao(Session session) {
		this.session = session;
	}

	public Project getProjectWithId(Long id) {
		return (Project) session.get(Project.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Project> list() {
		return session.createCriteria(Project.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Project> listProjectsWithUser(User user) {
		String hql = "select distinct project from Project project "
				+ "join project.contributors contributor where contributor.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", user.getId());
		return query.list();

	}

	public void insert(Project project) {
		session.save(project);
	}

}
