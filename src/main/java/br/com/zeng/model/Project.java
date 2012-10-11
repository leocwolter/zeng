package br.com.zeng.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.com.zeng.infra.Sanitizer;

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
	@Column(unique = true)
	private String url;
	@OneToMany
	private List<Notification> notifications;
	public List<Notification> getNotifications() {
		return notifications;
	}
	
	public Project() {
		notifications = new ArrayList<Notification>();
		contributors = new ArrayList<User>();
	}
	
	public Project(String name) {
		super();
		this.name=name;
		this.setUrl(name);
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
		this.setUrl(name);
	}

	public List<User> getContributors() {
		return Collections.unmodifiableList(contributors);
	}

	public void addContributor(User contributor) {
		if(!contributors.contains(contributor))
			this.contributors.add(contributor);
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = Sanitizer.toSlug(url);
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void addNotification(Notification notification) {
		notifications.add(notification);
	}

}