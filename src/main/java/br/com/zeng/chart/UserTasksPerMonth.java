package br.com.zeng.chart;

import java.util.Collection;
import java.util.Map;

import org.joda.time.DateTime;

import br.com.zeng.model.User;

public class UserTasksPerMonth {

	private final User user;
	private Map<DateTime, Long> tasksPerMonth;

	public UserTasksPerMonth(User user, Map<DateTime, Long> tasksPerMonth) {
		this.user = user;
		this.tasksPerMonth = tasksPerMonth;
	}
	
	public UserTasksPerMonth(User user, Integer year, Integer month, Long quantityOfTasks) {
		this.user = user;
		System.out.println(user.getName());
		System.out.println(year);
		System.out.println(month);
		System.out.println(quantityOfTasks);
	}

	public User getUser() {
		return user;
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
