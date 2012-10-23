package br.com.zeng.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import br.com.zeng.model.action.ActionType;
import br.com.zeng.model.action.Modifiable;

@Entity
public class Action {
	@GeneratedValue
	@Id
	private Long id;
	@NotNull
	@OneToOne
	private User author;
	@NotNull
	@ManyToOne
	private Project project;
	@Transient
	protected Modifiable target;
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@NotNull
	private DateTime creationDate;
	private String text;

	/**
	 * @deprecated hibernate eyes only
	 */
	public Action() {
		this.creationDate = new DateTime();
	}
	
	public Action(User author, Modifiable target, ActionType actionType) {
		this();
		this.author = author;
		this.project = target.getProject();
		this.target = target;
		this.text = "The "+target.getType()+" '"+target.getName()+"' was "+actionType.getActionText();
	}
	
	public User getAuthor() {
		return author;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public String getText(){
		return text;
	}

}
