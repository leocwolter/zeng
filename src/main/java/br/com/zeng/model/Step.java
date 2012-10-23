package br.com.zeng.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Step {
	@GeneratedValue @Id
	private Long id;
	@ManyToOne
	@NotNull
	private Task task;
	private String description;

	/**
	 * @deprecated hibernate eyes only
	 */
	public Step() {
	}
	
	public Step(Task task){
		this.task = task;
	}
	
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
