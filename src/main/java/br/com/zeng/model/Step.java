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
	private StepByStep stepByStep;
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStepByStep(StepByStep stepByStep) {
		this.stepByStep = stepByStep;
	}

	
	

}
