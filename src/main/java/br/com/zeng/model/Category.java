
package br.com.zeng.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.zeng.model.action.Modifiable;
import br.com.zeng.model.action.Wrapper;

@Entity
public class Category implements Modifiable, Wrapper{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne(fetch=FetchType.EAGER)
	private Project project;
	@OneToMany(mappedBy = "category")
	private List<TaskList> taskLists;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setTaskLists(List<TaskList> taskLists) {
		this.taskLists = taskLists;
	}

	public Long getId() {
		return id;
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
