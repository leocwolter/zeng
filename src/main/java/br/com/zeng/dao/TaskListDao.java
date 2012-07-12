package br.com.zeng.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.TaskList;

@Component
public class TaskListDao {

	private final Session session;

	public TaskListDao(Session session) {
		this.session = session;
	}

	public TaskList getTaskListWithId(Long id) {
		return (TaskList) session.get(TaskList.class, id);
	}

	public void insert(TaskList taskList) {
		session.save(taskList);
	}

}
