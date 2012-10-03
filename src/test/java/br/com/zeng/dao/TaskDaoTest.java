package br.com.zeng.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.zeng.model.Task;

public class TaskDaoTest extends DaoTest{

	@Test
	public void shouldSearchAndReturnAllTasksThatHasTheProvidedStringInNameOrDescription() {
		TaskDao taskDao = new TaskDao(session);
		Task task = new Task();
		task.setName("test");
		Task task2 = new Task();
		task2.setName("test2");
		Task task3 = new Task();
		
		task3.setDescription("Lorem test ipsum");
		
		taskDao.insert(task);
		taskDao.insert(task2);
		taskDao.insert(task3);
		List<Task> tasks = taskDao.getTasksWithContent("test");
		assertEquals(3, tasks.size());
	}

}
