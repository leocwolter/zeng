package br.com.zeng.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;

public class TaskDaoTest extends DaoTest{

	@Test
	public void shouldSearchAndReturnAllTasksThatHasTheProvidedStringInNameOrDescription() {
		TaskDao taskDao = new TaskDao(session);

		Project project = new Project();
		session.save(project);

		Category category = new Category();
		category.setProject(project);
		session.save(category);
		
		TaskList taskList = new TaskList();
		taskList.setCategory(category);
		session.save(taskList);
		
		Task task = new Task();
		task.setName("invalid");
		task.setTaskList(taskList);
		session.save(task);
		
		Task task2 = new Task();
		task2.setName("test2");
		task2.setTaskList(taskList);
		session.save(task2);

		Task task3 = new Task();
		task3.setDescription("Lorem test ipsum");
		task3.setTaskList(taskList);
		session.save(task3);

		Task task4 = new Task();
		task4.setDescription("Lorem test ipsum");
		session.save(task4);
		
		
		List<Task> tasks = taskDao.getTasksWithContentInAProject("test", project );
		assertEquals(2, tasks.size());
	}

}
