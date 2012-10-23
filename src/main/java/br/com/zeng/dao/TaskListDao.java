package br.com.zeng.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.TaskList;

@Component
public class TaskListDao {

	private GenericDao<TaskList> dao;

	public TaskListDao(Session session) {
		dao = new GenericDao<TaskList>(session, TaskList.class);
	}

	public TaskList getWithId(Long id) {
		return dao.getById(id);
	}

	public void insert(TaskList taskList) {
		dao.insert(taskList);
	}

}
