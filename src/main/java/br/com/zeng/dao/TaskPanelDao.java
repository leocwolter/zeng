package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Project;
import br.com.zeng.model.TaskPanel;

@Component
public class TaskPanelDao {

	private final Session session;

	public TaskPanelDao(Session session) {
		this.session = session;

	}

	public List<TaskPanel> listWithProject(Project project) {
		return session.createCriteria(TaskPanel.class).add(Restrictions.eq("project.id", project.getId())).list();
	}

}
