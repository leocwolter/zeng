package br.com.zeng.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@GeneratedValue
	@Id
	private Long id;

	private String name;

	@ManyToMany
	List<User> contributors;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getContributors() {
		return contributors;
	}
	
	public String getUrl() {
		return name.replace(" ", "-").toLowerCase();
	}
}
