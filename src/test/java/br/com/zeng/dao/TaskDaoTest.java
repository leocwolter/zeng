package br.com.zeng.dao;

import org.junit.Before;

import br.com.zeng.model.Task;

public class TaskDaoTest extends DaoTest {
	private TaskDao taskDao;
	private Task task;

	@Before
	public void setUp() {
		super.setUp();
		taskDao = new TaskDao(session);
		task = new Task();
		task.setName("test task");
		task.setDescription("description of task");
		taskDao.insert(task);
	}

}