package br.com.zeng.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

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

	@Test
	public void shouldSearchAndReturnAListOfTasksWithNameAndDescription() {
		List<Task> listOfTasks = taskDao.getListTaskWithNameAndDescription("task", "description");
		assertEquals(task.getName(), listOfTasks.get(0).getName());
		assertEquals(task.getDescription(), listOfTasks.get(0).getDescription());
		assertEquals(task.getId(), listOfTasks.get(0).getId());
		assertEquals(1,listOfTasks.size());
	}
}
