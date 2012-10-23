package br.com.zeng.builder;

import java.util.List;

import org.joda.time.DateTime;

import br.com.zeng.model.Step;
import br.com.zeng.model.Task;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.User;

public class TaskBuilder {
	private String name;
	private String description;
	private List<User> contributors;
	private TaskList taskList;
	private List<Step> steps;
	private DateTime expirationDate;
	private boolean archived;

	
	public TaskBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public TaskBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public TaskBuilder withContributors(List<User> contributors) {
		this.contributors = contributors;
		return this;
	}

	public TaskBuilder withTaskList(TaskList taskList) {
		this.taskList = taskList;
		return this;
	}

	public TaskBuilder withSteps(List<Step> steps) {
		this.steps = steps;
		return this;
	}

	public TaskBuilder withExpirationDate(DateTime expirationDate) {
		this.expirationDate = expirationDate;
		return this;
	}

	public TaskBuilder archived() {
		this.archived = true;
		return this;
	}
	
	public Task build(){
		Task task = new Task(taskList, name);
		task.setArchived(archived);
		task.setContributors(contributors);
		task.setDescription(description);
		task.setExpirationDate(expirationDate);
		task.setSteps(steps);
		return task;
	}
	
}
