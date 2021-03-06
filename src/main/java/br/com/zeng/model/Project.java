package br.com.zeng.model;

import static br.com.zeng.infra.Sanitizer.toSlug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.zeng.model.action.Wrapper;

@Entity
public class Project implements Wrapper {

	@GeneratedValue
	@Id
	private Long id;
	@NotEmpty
	private String name;
	@NotNull
	@ManyToMany
	List<User> contributors;
	@OneToMany(mappedBy = "project")
	private List<Category> categories;
	@NotEmpty
	@Column(unique = true)
	private String url;
	@OneToMany(mappedBy = "project")
	private List<Action> actions;

	
	/**
	 * @deprecated hibernate eyes only
	 */
	public Project() {
		actions = new ArrayList<Action>();
		contributors = new ArrayList<User>();
	}
	
	public Project(String name) {
		this();
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
		this.url = toSlug(url);
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void addAction(Action action) {
		actions.add(action);
	}
	
	public List<Action> getActions() {
		return actions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
}