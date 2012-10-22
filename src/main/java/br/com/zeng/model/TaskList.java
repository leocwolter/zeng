package br.com.zeng.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.zeng.model.action.Modifiable;
import br.com.zeng.model.action.Wrapper;

@Entity
public class TaskList implements Modifiable, Wrapper {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne(fetch=FetchType.EAGER)
	private Category category;
	@OneToMany(mappedBy = "taskList")
	private List<Task> tasks;
	
	public List<Task> getTasks() {
		ArrayList<Task> notArchivedTasks = new ArrayList<Task>();
		for (Task task : tasks) {
			if(!task.isArchived())
				notArchivedTasks.add(task);
		}
		return notArchivedTasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Project getProject() {
		return category.getProject();
	}

	public List<User> getProjectContributors(){
		return this.getProject().getContributors();
	}

	@Override
	public String getType() {
		return "Task List";
	}
}
