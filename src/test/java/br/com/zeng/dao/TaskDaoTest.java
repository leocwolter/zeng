package br.com.zeng.dao;

import static java.lang.Long.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import br.com.zeng.chart.UserTasksPerMonth;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.User;

public class TaskDaoTest extends DaoTest {

	private TaskDao taskDao;
	private Project project;

	@Before
	public void setUp() {
		super.setUp();
		taskDao = new TaskDao(session);

		project = new Project();
		project.setName("zeng");
		session.save(project);

		Category category = new Category();
		category.setProject(project);
		session.save(category);

		User user = new User();
		user.setName("Leonardo");
		user.setEmail("leo@gmail.com");
		session.save(user);
		
		User user2 = new User();
		user2.setName("Joao");
		user2.setEmail("joao@gmail.com");
		session.save(user2);
		List<User> contributors = Arrays.asList(user);
		List<User> contributors2 = Arrays.asList(user2);

		TaskList taskList = new TaskList();
		taskList.setCategory(category);
		session.save(taskList);

		Task task = new Task();
		task.setName("invalid");
		task.setTaskList(taskList);
		task.setContributors(contributors);
		session.save(task);

		Task task2 = new Task();
		task2.setName("test2");
		task2.setTaskList(taskList);
		task2.setContributors(contributors2);
		session.save(task2);

		Task task3 = new Task();
		task3.setDescription("Lorem test ipsum");
		task3.setTaskList(taskList);
		task3.setContributors(contributors2);
		session.save(task3);
		taskDao.finalize(task3);

		Task task4 = new Task();
		task4.setDescription("Lorem test ipsum");
		task4.setContributors(contributors);
		session.save(task4);
		taskDao.finalize(task4);

		Task task5 = new Task();
		task5.setDescription("Lorem test ipsum");
		task5.setContributors(contributors);
		session.save(task5);
		taskDao.finalize(task5);
		session.flush();
	}

	@Test
	public void shouldFinalizeATask() {
		Task task = new Task();
		session.save(task);

		assertFalse(task.isFinalized());
		taskDao.finalize(task);
		assertTrue(task.isFinalized());
	}

	@Test
	public void shouldStopATask() {
		Task task = new Task();
		task.start();
		session.save(task);

		assertFalse(task.isStopped());
		taskDao.stop(task);
		assertTrue(task.isStopped());
	}

	@Test
	public void shouldStartATask() {
		Task task = new Task();
		session.save(task);

		assertFalse(task.isStarted());
		taskDao.start(task);
		assertTrue(task.isStarted());
	}

	@Test
	public void shouldReturnTasksGroupedByDateOfCompletionAndContributors() {
		List<UserTasksPerMonth> quantityOfTasksGroupedByDateAndUser = taskDao.getQuantityOfTasksGroupedByDateAndUser(project);
		DateTime dateTime = new DateTime();
		DateTime today = new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),1,0,0,0,0);
		
		Long quantityOfTasksInMonthForJoao = quantityOfTasksGroupedByDateAndUser.get(0).getQuantityOfTasksInMonth(today);
		assertEquals(valueOf(1), quantityOfTasksInMonthForJoao);
		Long quantityOfTasksInMonthForLeonardo = quantityOfTasksGroupedByDateAndUser.get(1).getQuantityOfTasksInMonth(today);
		assertEquals(valueOf(2), quantityOfTasksInMonthForLeonardo);
		
	}

	@Test
	public void shouldSearchAndReturnAllTasksThatHasTheProvidedStringInNameOrDescription() {
		List<Task> tasks = taskDao.getTasksWithContentInAProject("test", project);
		assertEquals(2, tasks.size());
	}
	
	@Test
	public void shouldSetArchivedToTrue() {
		TaskDao taskDao = new TaskDao(session);
		
		Task task = new Task();
		task.setName("invalid");
		
		session.save(task);
		
		assertFalse(task.isArchived());
		taskDao.archive(task);
		assertTrue(task.isArchived());
		
	}
	
	@Test
	public void shouldSearchOnlyTheNotArchivedTasks() {
		TaskDao taskDao = new TaskDao(session);

		Project project = new Project();
		project.setName("zeng");
		session.save(project);

		Category category = new Category();
		category.setProject(project);
		session.save(category);
		
		TaskList taskList = new TaskList();
		taskList.setCategory(category);
		session.save(taskList);
		
		Task task = new Task();
		task.setName("test");
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

		taskDao.archive(task3);
		
		List<Task> tasks = taskDao.getTasksWithContentInAProject("test", project );
		assertEquals(2, tasks.size());
	}

}
