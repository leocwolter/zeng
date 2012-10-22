package br.com.zeng.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.dao.ActionDao;
import br.com.zeng.dao.CategoryDao;
import br.com.zeng.dao.TaskListDao;
import br.com.zeng.model.Action;
import br.com.zeng.model.Category;
import br.com.zeng.model.TaskList;
import br.com.zeng.model.action.AddAction;
import br.com.zeng.session.UserSession;

@Resource
public class TaskListController {
	private final Result result;
	private final TaskListDao taskListDao;
	private final CategoryDao categoryDao;
	private final UserSession userSession;
	private final ActionDao actionDao;

	public TaskListController(TaskListDao taskListDao,
			CategoryDao categoryDao,
			Result result, 
			UserSession userSession, 
			ActionDao actionDao) {
		this.taskListDao = taskListDao;
		this.categoryDao = categoryDao;
		this.result = result;
		this.userSession = userSession;
		this.actionDao = actionDao;
	}


	@Post("/addTaskList/")
	public void insert(TaskList taskList, Long categoryId) {
		Category category = categoryDao.getCategoryWithId(categoryId);
		taskList.setCategory(category);
		taskListDao.insert(taskList);
		Action action = new Action(userSession.getUser(), taskList , new AddAction(category));
		actionDao.insert(action);
		result.use(json()).from(taskList).serialize();
	}

	@LoggedUser
	@Path("/addTaskListForm/{categoryId}")
	public void insertTaskListForm(Long categoryId) {
		result.include("category", categoryDao.getCategoryWithId(categoryId));
	}	

}
