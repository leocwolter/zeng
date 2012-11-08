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

	private static final int MANY_TASKS = 2;
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
		
		Category categoryBackEnd = new Category(projectZeng, "Back-End");
		session.save(categoryBackEnd);
		
		taskListOfZeng = new TaskList(categoryBackEnd);
		taskListOfZeng.setName("Zeng Task List");
		session.save(taskListOfZeng);

		projectRails = new Project("rails");
		session.save(projectRails);
		
		Category categoryFrontEnd = new Category(projectRails, "Front-End");
		session.save(categoryFrontEnd);

		taskListOfRails = new TaskList(categoryFrontEnd);
		session.save(taskListOfRails);

		task = builder.withTaskList(taskListOfZeng).withName("do something").build();
		taskDao.insert(task);

		
		session.flush();
	}
	
	@Test
	public void shouldGetATaskById() {
		Task completeTask = taskDao.getWithId(task.getId());
		assertEquals("do something", completeTask.getName());
		assertEquals("Zeng Task List", completeTask.getTaskList().getName());
		assertEquals("Back-End", completeTask.getCategory().getName());
		assertEquals("zeng", completeTask.getProject().getName());
		
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
	public void shouldIgnoreNumberOfTasksInOtherProjects() {
		User leonardo = new User("Leonardo","leo@leo.com","12345678");
		session.save(leonardo);
		
		User joao = new User("Joao", "joao@joao.com", "12345678");
		session.save(joao);
		
		projectZeng.addContributor(leonardo);
		projectZeng.addContributor(joao);
		session.update(projectZeng);
		
		projectRails.addContributor(leonardo);
		projectRails.addContributor(joao);
		session.update(projectRails);
		
		List<User> joaoELeonardoList = Arrays.asList(leonardo,joao);
		List<User> joaoList = Arrays.asList(joao);
		
		Task task = builder.withContributors(joaoELeonardoList).withTaskList(taskListOfZeng).build();
		taskDao.insert(task);
		taskDao.finalize(task);
		
		Task task3 = builder.withContributors(joaoList).withTaskList(taskListOfRails).build();
		taskDao.insert(task3);
		taskDao.finalize(task3);
		
		Task task4 = builder.withContributors(joaoELeonardoList).withTaskList(taskListOfRails).build();
		taskDao.insert(task4);
		taskDao.finalize(task4);

		List<UserTasksPerMonth> quantityOfTasksGroupedByDateAndUser = taskDao.getQuantityOfTasksGroupedByDateAndUser(projectZeng);
		for (UserTasksPerMonth userTasksPerMonth : quantityOfTasksGroupedByDateAndUser) {
			if(userTasksPerMonth.getUser().equals(leonardo))
				assertEquals(valueOf(1), userTasksPerMonth.getQuantityOfTasks());
			if(userTasksPerMonth.getUser().equals(joao))
				assertEquals(valueOf(1), userTasksPerMonth.getQuantityOfTasks());
		}
	}
	
	@Test
	public void shouldIgnoreTasksThatAreNotFinalizedYet() {
		User leonardo = new User("Leonardo","leo@leo.com","12345678");
		session.save(leonardo);
		
		User joao = new User("Joao", "joao@joao.com", "12345678");
		session.save(joao);
		
		projectZeng.addContributor(leonardo);
		projectZeng.addContributor(joao);
		session.update(projectZeng);
		
		projectRails.addContributor(leonardo);
		projectRails.addContributor(joao);
		session.update(projectRails);
		
		List<User> joaoELeonardoList = Arrays.asList(leonardo,joao);
		List<User> joaoList = Arrays.asList(joao);
		
		Task task = builder.withContributors(joaoELeonardoList).withTaskList(taskListOfZeng).build();
		taskDao.insert(task);
		
		Task task3 = builder.withContributors(joaoList).withTaskList(taskListOfZeng).build();
		taskDao.insert(task3);
		taskDao.finalize(task3);
		
		Task task4 = builder.withContributors(joaoELeonardoList).withTaskList(taskListOfZeng).build();
		taskDao.insert(task4);
		
		List<UserTasksPerMonth> quantityOfTasksGroupedByDateAndUser = taskDao.getQuantityOfTasksGroupedByDateAndUser(projectZeng);
		for (UserTasksPerMonth userTasksPerMonth : quantityOfTasksGroupedByDateAndUser) {
			if(userTasksPerMonth.getUser().equals(leonardo))
				assertEquals(valueOf(0), userTasksPerMonth.getQuantityOfTasks());
			if(userTasksPerMonth.getUser().equals(joao))
				assertEquals(valueOf(1), userTasksPerMonth.getQuantityOfTasks());
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
		Project trello = new Project("Trello");
		session.save(trello);
		Category backEnd = new Category(trello, "Back-End2");
		session.save(backEnd);
		TaskList refactor = new TaskList(backEnd);
		session.save(refactor);
		Task email = new Task(refactor, "Email");
		
		session.save(email);
		
		assertFalse(email.isArchived());
		taskDao.archive(email);
		assertTrue(email.isArchived());
		
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
	public void shouldVerifyIfThereIsManyTasksInAProjectWithTheExpirationDate() {
		DateTime expirationDate = new DateTime(2012,12,1,0,0,0,0);
		Task task = builder.withTaskList(taskListOfZeng).withExpirationDate(expirationDate).build();
		taskDao.insert(task);
		assertFalse(taskDao.manyTasksInAProjectWith(expirationDate, projectZeng));
		for (int i = 0; i < MANY_TASKS; i++) {
			taskDao.insert(builder.withTaskList(taskListOfZeng).withExpirationDate(expirationDate).build());
		}
		assertTrue(taskDao.manyTasksInAProjectWith(expirationDate, projectZeng));
	}
	
	@Test
	public void shouldNotReturnTrueIfTheTasksHasNoExpirationDate() {
		Task task = builder.withTaskList(taskListOfZeng).withExpirationDate(null).build();
		taskDao.insert(task);
		assertFalse(taskDao.manyTasksWithSameExpirationDate(projectZeng));
		for (int i = 0; i < TaskDao.MANY_TASKS; i++) {
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
