package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.TaskPanel;

@Component
public class TaskPanelDao {

	private final Session session;

	public TaskPanelDao(Session session) {
		this.session = session;

	}

	public List<TaskPanel> listInCategoriesWithProject(Project project) {
		Query query = session.createQuery("from TaskPanel taskPanel" +
				" join taskPanel.category category" +
				" join category.project project where project.id = :projectId")
				.setParameter("projectId", project.getId());
		return query.list();
	}

}
