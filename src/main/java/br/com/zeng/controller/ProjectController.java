package br.com.zeng.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.model.Project;
import br.com.zeng.session.UserSession;

@Resource
public class ProjectController {
	private final Result result;
	private final ProjectDao projectDao;
	private final UserSession userSession;

	public ProjectController(Result result, ProjectDao projectDao, UserSession userSession) {
		this.result = result;
		this.projectDao = projectDao;
		this.userSession = userSession;
	}

	@LoggedUser
	@Path("/projects/{project.url}/{project.id}")
	public void showProject(Project project) {
		Project projectCompleted = projectDao.getProjectWithId(project.getId());
		result.include("project", projectCompleted);
	}

	@LoggedUser
	@Path("/projects/")
	public void listProjects() {
		List<Project> listProjectsWithUser = projectDao.listProjectsWithUser(userSession.getUser());
		result.include("projects", listProjectsWithUser);
	}
}
