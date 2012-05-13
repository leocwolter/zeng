package br.com.zeng.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@GeneratedValue
	@Id
	private Long id;
	private String name;

	@ManyToOne
	private Project project;

	@OneToMany(mappedBy = "category")
	private List<TaskPanel> taskPanels;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setTaskPanels(List<TaskPanel> taskPanels) {
		this.taskPanels = taskPanels;
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

	public List<TaskPanel> getTaskPanels() {
		return taskPanels;
	}

}
