package br.com.zeng.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String description;

	@ManyToMany
	private List<User> contributors;

	@ManyToOne
	private TaskPanel taskPanel;

	private State state;

	@OneToMany(mappedBy = "task")
	private List<Step> steps;

	public Long getId() {
		return id;
	}

	public TaskPanel getTaskPanel() {
		return taskPanel;
	}

	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime expirationDate;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setContributors(List<User> contributors) {
		this.contributors = contributors;
	}

	public void setTaskPanel(TaskPanel taskPanel) {
		this.taskPanel = taskPanel;
	}

	public void setExpirationDate(DateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<User> getContributors() {
		return contributors;
	}

	public DateTime getExpirationDate() {
		return expirationDate;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
