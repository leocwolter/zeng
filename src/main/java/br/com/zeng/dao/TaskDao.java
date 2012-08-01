package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Task;

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
	
	@SuppressWarnings("unchecked")
	public List<Task> getListTaskWithNameAndDescription(String name, String description) {
		//return (List<Task>) session.get(Task.class, name);
		String hql = "select distinct Task from Task task where task.name like:name or task.description like:description";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%"+name+"%");
		query.setParameter("description", "%"+description+"%");
		return query.list();
	}


	public void update(Task task) {
		session.update(task);
	}


	@SuppressWarnings("unchecked")
	public List<Task> getTasksWithState(String taskState, Long taskListId) {
		String hql = "select Task from Task task where task.state like:state and task.taskList.id =:taskListId";
		Query query = session.createQuery(hql);
		query.setParameter("state", "%"+taskState+"%");
		query.setParameter("taskListId", "%"+taskListId+"%");
		return query.list();
	}

}
