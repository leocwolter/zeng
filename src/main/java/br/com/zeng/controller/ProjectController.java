package br.com.zeng.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.dao.CategoryDao;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.dao.TaskPanelDao;
import br.com.zeng.model.Project;

@Resource
public class ProjectController {
	private final Result result;
	private final TaskPanelDao taskPanelDao;
	private final ProjectDao projectDao;

	public ProjectController(Result result, TaskPanelDao taskPanelDao,CategoryDao categoryDao, ProjectDao projectDao) {
		this.result = result;
		this.taskPanelDao = taskPanelDao;
		this.projectDao = projectDao;
	}

	@Path("/projects/{project.url}/{project.id}")
	public void showProject(Project project) {
		Project projectCompleted = projectDao.getProjectWithId(project.getId());
		result.include("project", projectCompleted);
	}
	

}
