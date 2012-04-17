package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Project;

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

}
