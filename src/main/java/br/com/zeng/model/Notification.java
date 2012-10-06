package br.com.zeng.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class Notification {
	@GeneratedValue
	@Id
	private Long id;
	private String action;
	@OneToOne
	private User author;
	@ManyToOne
	private Project project;
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime creationDate;

	
	//hibernate eyes only
	public Notification(){
	}

	public Notification(String action, User author, Project project) {
		this.action = action;
		this.author = author;
		this.project = project;
		this.creationDate = new DateTime();
		project.addNotification(this);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public User getAuthor() {
		return author;
	}

	public Project getProject() {
		return project;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}
}
