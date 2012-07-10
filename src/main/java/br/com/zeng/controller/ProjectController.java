package br.com.zeng.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.dao.UserDao;
import br.com.zeng.model.Project;
import br.com.zeng.model.User;
import br.com.zeng.session.UserSession;

@Resource
public class ProjectController {
	private final Result result;
	private final ProjectDao projectDao;
	private final UserSession userSession;
	private final UserDao userDao;

	public ProjectController(Result result, ProjectDao projectDao, UserSession userSession, UserDao userDao) {
		this.result = result;
		this.projectDao = projectDao;
		this.userSession = userSession;
		this.userDao = userDao;
	}

	@LoggedUser
	@Path("/projects/{project.url}")
	public void showProject(Project project) {
		Project projectCompleted = projectDao.getProjectWithUrl(project.getUrl());
		result.include("project", projectCompleted);
	}

	@LoggedUser
	@Path("/projects")
	public void listProjects() {
		List<Project> listProjectsWithUser = projectDao.listProjectsWithUser(userSession.getUser());
		result.include("projects", listProjectsWithUser);
	}

	@LoggedUser
	@Post("/project/add")
	public void insert(Project project, List<User> contributors) {
		for (User contributor : contributors) {
			project.addContributor(userDao.getUserByEmail(contributor));
		}
		project.addContributor(userSession.getUser());
		projectDao.insert(project);
		result.redirectTo(ProjectController.class).listProjects();
	}

	@LoggedUser
	@Get("/project/add")
	public void insertProjectForm() {

	}
}
