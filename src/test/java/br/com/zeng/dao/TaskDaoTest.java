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
	private Project projectZeng;
	private Task task;
	private TaskBuilder builder;
	private TaskList taskListOfZeng;
	private Project projectRails;
	private TaskList taskListOfRails;

	@Before
	public void setUp() {
		super.setUp();
		taskDao = new TaskDao(session);
		builder = new TaskBuilder();
		
		projectZeng = new Project("zeng");
		session.save(projectZeng);
		Category categoryBackEnd = new Category();
		categoryBackEnd.setProject(projectZeng);
		session.save(categoryBackEnd);
		taskListOfZeng = new TaskList();
		taskListOfZeng.setCategory(categoryBackEnd);
		session.save(taskListOfZeng);

		projectRails = new Project("rails");
		session.save(projectRails);
		Category categoryFrontEnd = new Category();
		categoryFrontEnd.setProject(projectRails);
		session.save(categoryFrontEnd);
		taskListOfRails = new TaskList();
		taskListOfRails.setCategory(categoryFrontEnd);
		session.save(taskListOfRails);

		task = builder.withTaskList(taskListOfZeng).build();
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

		Task task = builder.withContributors(joaoELeonardoList).withTaskList(taskListOfZeng).build();
		taskDao.insert(task);
		
		Task task3 = builder.withContributors(joaoList).withTaskList(taskListOfZeng).build();
		taskDao.insert(task3);
		taskDao.finalize(task3);
		
		Task task4 = builder.withContributors(joaoELeonardoList).withTaskList(taskListOfZeng).build();
		taskDao.insert(task4);
		taskDao.finalize(task4);
		
		Task task5 = builder.withContributors(joaoELeonardoList).withTaskList(null).build();
		taskDao.insert(task5);
		taskDao.finalize(task5);
		
		List<UserTasksPerMonth> quantityOfTasksGroupedByDateAndUser = taskDao.getQuantityOfTasksGroupedByDateAndUser(projectZeng);
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
		Task task = builder.withName("Invalid").withDescription("Invalid").withTaskList(taskListOfZeng).build();
		taskDao.insert(task);

		Task task2 = builder.withName("test2").withDescription("Invalid").withTaskList(taskListOfZeng).build();
		taskDao.insert(task2);
		
		Task task3 = builder.withName("Invalid").withDescription("Lorem test ipsum").withTaskList(taskListOfRails).build();
		taskDao.insert(task3);
		
		Task task4 = builder.withName("test2").withDescription("Invalid").withTaskList(taskListOfRails).build();
		taskDao.insert(task4);
		
		Task task5 = builder.withName("Invalid").withDescription("Lorem test ipsum").withTaskList(taskListOfZeng).build();
		taskDao.insert(task5);

		Task task6 = builder.withName("test2").withDescription("Lorem test ipsum").withTaskList(taskListOfRails).build();
		taskDao.insert(task6);

		List<Task> tasks = taskDao.getTasksWithContentInAProject("test", projectZeng.getId());
		
		assertEquals(2, tasks.size());
		
		assertTrue(tasks.contains(task2));
		assertTrue(tasks.contains(task5));
		
		assertFalse(tasks.contains(task));
		assertFalse(tasks.contains(task3));
		assertFalse(tasks.contains(task4));
		assertFalse(tasks.contains(task6));
		
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
		Task task = builder.withTaskList(taskListOfZeng).withExpirationDate(expirationDate).build();
		taskDao.insert(task);
		assertFalse(taskDao.manyTasksWithSameExpirationDate(projectZeng));
		for (int i = 0; i < 9; i++) {
			taskDao.insert(builder.withTaskList(taskListOfZeng).withExpirationDate(expirationDate).build());
		}
		assertTrue(taskDao.manyTasksWithSameExpirationDate(projectZeng));
	}
	
	@Test
	public void shouldNotReturnTrueIfTheTasksHasNoExpirationDate() {
		Task task = builder.withTaskList(taskListOfZeng).withExpirationDate(null).build();
		taskDao.insert(task);
		assertFalse(taskDao.manyTasksWithSameExpirationDate(projectZeng));
		for (int i = 0; i < 9; i++) {
			taskDao.insert(builder.withTaskList(taskListOfZeng).withExpirationDate(null).build());
		}
		assertFalse(taskDao.manyTasksWithSameExpirationDate(projectZeng));
	}
	
	@Test
	public void shouldSearchForOnlyNotArchivedTasks() {
		taskDao.archive(task);
		List<Task> tasks = taskDao.getTasksWithContentInAProject("test", projectZeng.getId() );
		assertEquals(0, tasks.size());
	}

}
