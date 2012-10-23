package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Project;
import br.com.zeng.model.User;

@Component
public class ProjectDao {

	private final Session session;
	private GenericDao<Project> dao;

	public ProjectDao(Session session) {
		this.session = session;
		dao = new GenericDao<Project>(session, Project.class);
	}

	public Project getWithId(Long id) {
		return dao.getById(id);
	}

	public List<Project> list() {
		return dao.list();
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
		dao.insert(project);
	}

	public Project getProjectWithUrl(String url) {
		return (Project) session.createCriteria(Project.class).add(Restrictions.like("url", url)).uniqueResult();
	}
}
