package br.com.zeng.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime expirationDate;
	
	

}
