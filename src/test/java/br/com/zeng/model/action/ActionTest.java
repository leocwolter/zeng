package br.com.zeng.model.action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.zeng.model.Action;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.User;

public class ActionTest {

	private Task cleanCode;
	private User leonardo;
	private TaskList refactorList;
	private Category backEnd;


	@Before
	public void setUp(){
		Project zeng = new Project("Zeng");
		
		backEnd = new Category(zeng, "Back-End");
		
		refactorList = new TaskList(backEnd);
		refactorList.setName("Refactor");

		leonardo = new User("Leonardo", "leo@leo.com", "12345");
		
		cleanCode = new Task(refactorList, "Clean Code");
		cleanCode.setName("Clean Code");
	}
	
	@Test
	public void shouldCreateAddActionTextWithATaskToATaskListSuccessfully() {
		Action action = new Action(leonardo, cleanCode, new AddAction(refactorList));
		assertEquals("The Task 'Clean Code' was added to 'Refactor'", action.getText());
	}
	
	@Test
	public void shouldCreateDeleteActionTextWithATaskSuccessfully() {
		Action action = new Action(leonardo, cleanCode, new ArchiveAction());
		assertEquals("The Task 'Clean Code' was archived", action.getText());
	}
	
	@Test
	public void shouldCreateAddActionTextWithATaskListToACategorySuccessfully() {
		Action action = new Action(leonardo, refactorList, new AddAction(backEnd));
		assertEquals("The Task List 'Refactor' was added to 'Back-End'", action.getText());
	}
	
	@Test
	public void shouldCreateArchiveActionTextWithATaskListSuccessfully() {
		Action action = new Action(leonardo, refactorList, new ArchiveAction());
		assertEquals("The Task List 'Refactor' was archived", action.getText());
	}
	
	@Test
	public void shouldCreateDeleteActionTextWithACategorySuccessfully() {
		Action action = new Action(leonardo, backEnd, new ArchiveAction());
		assertEquals("The Category 'Back-End' was archived", action.getText());
	}
	
	@Test
	public void shouldCreateMoveActionTextWithATaskToATaskListSuccessfully() {
		Action action = new Action(leonardo, cleanCode, new MoveAction(refactorList));
		assertEquals("The Task 'Clean Code' was moved to the TaskList 'Refactor'", action.getText());
	}
	
	@Test
	public void shouldCreateMoveActionTextWithATaskToACategorySuccessfully() {
		Action action = new Action(leonardo, cleanCode, new MoveAction(backEnd));
		assertEquals("The Task 'Clean Code' was moved to the Category 'Back-End'", action.getText());
	}
	
	@Test
	public void shouldCreateMoveActionTextWithATaskListToACategorySuccessfully() {
		Action action = new Action(leonardo, refactorList, new MoveAction(backEnd));
		assertEquals("The Task List 'Refactor' was moved to the Category 'Back-End'", action.getText());
	}
	
	@Test
	public void shouldCreateStartActionTextWithATaskSuccessfully() {
		Action action = new Action(leonardo, cleanCode, new StartAction());
		assertEquals("The Task 'Clean Code' was started", action.getText());
	}
	
	@Test
	public void shouldCreateStopActionTextWithATaskSuccessfully() {
		Action action = new Action(leonardo, cleanCode, new StopAction());
		assertEquals("The Task 'Clean Code' was stopped", action.getText());
	}
	
	@Test
	public void shouldCreateFinalizeActionTextWithATaskSuccessfully() {
		Action action = new Action(leonardo, cleanCode, new FinalizeAction());
		assertEquals("The Task 'Clean Code' was finalized", action.getText());
	}
}
