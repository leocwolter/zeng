package br.com.zeng.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class TaskPerContributor {
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private User contributor;
	
	@OneToOne
	private Task task;
	
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime dateOfCompletion;

	//hibernate eyes only
	public TaskPerContributor() {
	}
	
	public TaskPerContributor(User contributor, Task task) {
		this.contributor = contributor;
		this.task = task;
		this.dateOfCompletion = new DateTime();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
