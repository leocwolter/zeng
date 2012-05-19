package br.com.zeng.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskPanel;

@Component
public class TaskDao {
	
	private final Session session;


	public TaskDao(Session session) {
		this.session = session;
	}
	
	
	public void insert(Task task) {
		session.save(task);
	}


	public Task getTaskWithId(Long id) {
		return (Task) session.get(Task.class, id);
	}


	public void update(Task task) {
		session.update(task);
	}

}
