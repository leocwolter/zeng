package br.com.zeng.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TaskList {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany
	private List<Task> tasks;
	
}
