package br.com.zeng.chart;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import br.com.zeng.model.User;

public class UserTasksPerMonth {

	private final User user;
	private HashMap<DateTime, Long> tasksPerMonth;

	public UserTasksPerMonth(User user, HashMap<DateTime, Long> tasksPerMonth) {
		this.user = user;
		this.tasksPerMonth = tasksPerMonth;
	}

	public User getUser() {
		return user;
	}

	public Long getQuantityOfTasksInMonth(DateTime date){
		return tasksPerMonth.get(date);
	}
	
	public void addQuantityOfTasksPerMonth(DateTime date, Long quantityOfTasks) {
		tasksPerMonth.put(date, quantityOfTasks);
	}

	public Long getQuantityOfTasks() {
		Collection<Long> tasks = tasksPerMonth.values();
		int totalQuantityOfTasks = 0;
		for (Long tasksInAMonth : tasks) {
			totalQuantityOfTasks  += tasksInAMonth;
		}
		return (long) totalQuantityOfTasks;
	}


}
