package br.com.zeng.model;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

public class TaskTest {

	@Test
	public void shouldFinalizeTask() {
		Task task = new Task(null);
		task.finalize();
		
		assertTrue(task.isFinalized());
	}
	
	@Test
	public void theTaskShouldStartOnToDoState() {
		Task task = new Task(null);
		
		assertEquals(State.TODO, task.getState());
	}
	
	@Test
	public void shouldStartATask() {
		Task task = new Task(null);
		task.start();
		
		assertEquals(State.DOING, task.getState());
	}
	
	@Test
	public void shouldVerifyIfATaskIsCloseToExpiring() {
		Task task = new Task(null);
		assertFalse(task.isCloseToExpiring());
		task.setExpirationDate(new DateTime().plusDays(7));
		assertTrue(task.isCloseToExpiring());
	}
	
	@Test
	public void shouldBeCloseToExpiringIfExpirationDayIsToday() {
		Task task = new Task(null);
		assertFalse(task.isCloseToExpiring());
		task.setExpirationDate(new DateTime());
		assertTrue(task.isCloseToExpiring());
	}
	
	@Test
	public void shouldNotBeCloseIfExpirationDateIsNull() {
		Task task = new Task(null);
		task.setExpirationDate(null);
		assertFalse(task.isCloseToExpiring());
	}
	
	@Test
	public void shouldVerifyIfATaskIsExpired() {
		Task task = new Task(null);
		assertFalse(task.isExpired());
		task.setExpirationDate(new DateTime().minusMonths(1));
		assertTrue(task.isExpired());
	}

	@Test
	public void shouldNotBeExpiredIfExpirationDateIsToday() {
		Task task = new Task(null);
		assertFalse(task.isExpired());
		task.setExpirationDate(new DateTime());
		assertFalse(task.isExpired());
	}
	
	@Test
	public void shouldNotBeExpiredIfExpirationDateIsNull() {
		Task task = new Task(null);
		task.setExpirationDate(null);
		assertFalse(task.isExpired());
	}
	

}
