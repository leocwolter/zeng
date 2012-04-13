package br.com.zeng.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.dao.TaskPanelDao;
import br.com.zeng.model.Project;

@Resource
public class ProjectController {
		private final Result result;
		private final TaskPanelDao taskPanelDao;
		private final ProjectDao projectDao;

		public ProjectController(Result result, TaskPanelDao taskPanelDao, ProjectDao projectDao) {
			this.result = result;
			this.taskPanelDao = taskPanelDao;
			this.projectDao = projectDao;
		}

		@Path("/{project.id}")
		public void listTaskPanels(Project project) {
			result.include("project" ,projectDao.getProjectWithId(project.getId()));
			result.include("taskPanels",taskPanelDao.listWithProject(project));
		}

		@Path("/")
		public void listProjects() {
			result.include("project" ,projectDao.list());
		}
		

}
