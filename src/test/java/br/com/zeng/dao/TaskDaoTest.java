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

import br.com.zeng.builder.TaskBuilder;
import br.com.zeng.chart.UserTasksPerMonth;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.User;

public class TaskDaoTest extends DaoTest {

	private TaskDao taskDao;
	private Project project;
	private Task task;
	private TaskBuilder builder;
	private TaskList taskList;

	@Before
	public void setUp() {
		super.setUp();
		taskDao = new TaskDao(session);
		builder = new TaskBuilder();
		
		project = new Project("zeng");
		session.save(project);

		Category category = new Category();
		category.setProject(project);
		session.save(category);

		taskList = new TaskList();
		taskList.setCategory(category);
		session.save(taskList);

		task = builder.withTaskList(taskList).build();
		taskDao.insert(task);

		
		session.flush();
	}
	
	@Test
	public void shouldFinalizeATask() {
		assertFalse(task.isFinalized());
		taskDao.finalize(task);
		assertTrue(task.isFinalized());
	}

	@Test
	public void shouldStopATask() {
		taskDao.start(task);
		assertFalse(task.isStopped());
		taskDao.stop(task);
		assertTrue(task.isStopped());
	}

	@Test
	public void shouldStartATask() {
		assertFalse(task.isStarted());
		taskDao.start(task);
		assertTrue(task.isStarted());
	}

	@Test
	public void shouldReturnNumberOfTasksGroupedByDateOfCompletionAndContributors() {
		User leonardo = new User("Leonardo",null,null);
		session.save(leonardo);
		
		User joao = new User("Joao",null,null);
		session.save(joao);
		
		List<User> joaoELeonardoList = Arrays.asList(leonardo,joao);
		List<User> joaoList = Arrays.asList(joao);

		Task task = builder.withContributors(joaoELeonardoList).withTaskList(taskList).build();
		taskDao.insert(task);
		
		Task task3 = builder.withContributors(joaoList).withTaskList(taskList).build();
		taskDao.insert(task3);
		taskDao.finalize(task3);
		
		Task task4 = builder.withContributors(joaoELeonardoList).withTaskList(taskList).build();
		taskDao.insert(task4);
		taskDao.finalize(task4);
		
		Task task5 = builder.withContributors(joaoELeonardoList).withTaskList(null).build();
		taskDao.insert(task5);
		taskDao.finalize(task5);
		
		List<UserTasksPerMonth> quantityOfTasksGroupedByDateAndUser = taskDao.getQuantityOfTasksGroupedByDateAndUser(project);
		DateTime dateTime = new DateTime();
		DateTime today = new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),1,0,0,0,0);

		for (UserTasksPerMonth userTasksPerMonth : quantityOfTasksGroupedByDateAndUser) {
			if(userTasksPerMonth.getUser().equals(leonardo))
				assertEquals(valueOf(1), userTasksPerMonth.getQuantityOfTasksInMonth(today));
			if(userTasksPerMonth.getUser().equals(joao))
				assertEquals(valueOf(2), userTasksPerMonth.getQuantityOfTasksInMonth(today));
		}
	}

	@Test
	public void shouldSearchAndReturnAllTasksThatHasTheProvidedStringInNameOrDescription() {
		Task task = builder.withName("Invalid").withDescription("Invalid").withTaskList(taskList).build();
		taskDao.insert(task);

		Task task2 = builder.withName("test2").withDescription("Invalid").withTaskList(taskList).build();
		taskDao.insert(task2);
		
		Task task3 = builder.withName("Invalid").withDescription("Lorem test ipsum").withTaskList(null).build();
		taskDao.insert(task3);
		
		Task task4 = builder.withName("test2").withDescription("Invalid").withTaskList(null).build();
		taskDao.insert(task4);
		
		Task task5 = builder.withName("Invalid").withDescription("Lorem test ipsum").withTaskList(taskList).build();
		taskDao.insert(task5);

		List<Task> tasks = taskDao.getTasksWithContentInAProject("test", taskList.getProject().getUrl());
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
	public void shouldVerifyIfThereIsManyTasksWithTheSameExpirationDate() {
		DateTime expirationDate = new DateTime(2012,12,1,0,0,0,0);
		Task task = builder.withTaskList(taskList).withExpirationDate(expirationDate).build();
		taskDao.insert(task);
		assertFalse(taskDao.manyTasksWithSameExpirationDate(project));
		for (int i = 0; i < 9; i++) {
			taskDao.insert(builder.withTaskList(taskList).withExpirationDate(expirationDate).build());
		}
		assertTrue(taskDao.manyTasksWithSameExpirationDate(project));
	}
	
	@Test
	public void shouldNotReturnTrueIfTheTasksHasNoExpirationDate() {
		Task task = builder.withTaskList(taskList).withExpirationDate(null).build();
		taskDao.insert(task);
		assertFalse(taskDao.manyTasksWithSameExpirationDate(project));
		for (int i = 0; i < 9; i++) {
			taskDao.insert(builder.withTaskList(taskList).withExpirationDate(null).build());
		}
		assertFalse(taskDao.manyTasksWithSameExpirationDate(project));
	}
	
	@Test
	public void shouldSearchOnlyTheNotArchivedTasks() {
		taskDao.archive(task);
		List<Task> tasks = taskDao.getTasksWithContentInAProject("test", project.getUrl() );
		assertEquals(0, tasks.size());
	}

}
