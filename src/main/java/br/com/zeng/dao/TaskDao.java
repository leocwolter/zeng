package br.com.zeng.dao;

import java.util.List;

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

	public void update(Task task) {
		session.update(task);
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTasksWithContent(String content){
		return (List<Task>) session.createQuery("from Task t where t.name like :content or t.description like :content")
							.setString("content", "%"+content+"%")
							.list();
	}
}
