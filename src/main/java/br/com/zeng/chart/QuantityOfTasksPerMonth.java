package br.com.zeng.chart;

import org.joda.time.DateTime;

public class QuantityOfTasksPerMonth {

	private final Long quantityOfTasks;
	private final DateTime monthAndYear;

	public QuantityOfTasksPerMonth(Integer year, Integer month, Long quantityOfTasks) {
		this.monthAndYear = new DateTime(year,month,1,0,0,0,0);
		this.quantityOfTasks = quantityOfTasks;
	}

	public Long getQuantityOfTasks() {
		return quantityOfTasks;
	}

	public DateTime getMonth() {
		return monthAndYear;
	}

}
