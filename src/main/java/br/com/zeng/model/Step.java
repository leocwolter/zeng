package br.com.zeng.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Step {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@ManyToOne
	private Task task;
	
	private String description;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public Task getTask() {
		return task;
	}

	public void setStepByStep(Task task) {
		this.task = task;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
