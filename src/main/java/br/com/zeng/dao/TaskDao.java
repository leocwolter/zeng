package br.com.zeng.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Task;

@Component
public class TaskDao {
	
	private final Session session;


	public TaskDao(Session session) {
		this.session = session;
	}
	
	
	public void insertTask(Task task) {
		session.save(task);
	}

}
