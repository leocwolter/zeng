package br.com.zeng.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskTest {

	@Test
	public void shouldFinalizeTask() {
		Task task = new Task();
		task.finalize();
		
		assertTrue(task.isFinalized());
	}
	
	@Test
	public void theTaskShouldStartOnToDoState() {
		Task task = new Task();
		
		assertEquals(State.TODO, task.getState());
	}
	
	@Test
	public void shouldStartATask() {
		Task task = new Task();
		task.start();
		
		assertEquals(State.DOING, task.getState());
	}

}
