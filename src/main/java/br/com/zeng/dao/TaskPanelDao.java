package br.com.zeng.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.TaskPanel;

@Component
public class TaskPanelDao {

	private final Session session;

	public TaskPanelDao(Session session) {
		this.session = session;
	}

	public TaskPanel getTaskPanelWithId(Long id) {
		return (TaskPanel) session.get(TaskPanel.class, id);
	}

	public void insert(TaskPanel taskPanel) {
		session.save(taskPanel);
	}

}
