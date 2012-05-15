package br.com.zeng.model;

import java.util.ArrayList;
import java.util.Collections;
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
	private Long id;

	private String name;

	@ManyToMany
	List<User> contributors;

	@OneToMany(mappedBy = "project")
	private List<Category> categories;
	
	public Project() {
		contributors = new ArrayList<User>();
	}
	
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
		return Collections.unmodifiableList(contributors);
	}
	
	public String getUrl() {
		return name.replace(" ", "-").toLowerCase();
	}
	
	public void addContributor(User contributor) {
		this.contributors.add(contributor);
	}

	public List<Category> getCategories() {
		return categories;
	}

}