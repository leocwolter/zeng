package br.com.zeng.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Project {
	
	@GeneratedValue
	@Id
	Long id;
	
	String name;
	
	@ManyToMany
	List<User> contributors;
	
	@OneToMany
	List<TaskList> taskLists;
	
}
