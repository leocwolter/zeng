
package br.com.zeng.model;

import static br.com.zeng.infra.Sanitizer.toSlug;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.zeng.model.action.Modifiable;
import br.com.zeng.model.action.Wrapper;

@Entity
public class Category implements Modifiable, Wrapper{
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	@Column(unique = true)
	private String url;
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	private Project project;
	@OneToMany(mappedBy = "category")
	private List<TaskList> taskLists;
	
	/**
	 * @deprecated hibernate eyes only
	 */
	public Category() {
	}

	public Category(Project project, String name){
		this.name = name;
		this.setUrl(name);
		this.setProject(project);
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = toSlug(url);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
		this.setUrl(name);
	}

	public void setTaskLists(List<TaskList> taskLists) {
		this.taskLists = taskLists;
	}

	public Long getId() {
		return id;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public String getName() {
		return name;
	}

	public List<TaskList> getTaskLists() {
		return taskLists;
	}

	@Override
	public String getType() {
		return "Category";
	}


}
