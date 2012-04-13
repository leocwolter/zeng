package br.com.zeng.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime expirationDate;
	
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

	
	

}
