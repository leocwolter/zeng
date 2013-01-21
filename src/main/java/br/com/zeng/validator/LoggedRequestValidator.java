package br.com.zeng.validator;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.model.Project;
import br.com.zeng.session.UserSession;


@Component
public class LoggedRequestValidator {

	private final ProjectDao projectDao;
	private final Validator validator;
	private final UserSession userSession;

	public LoggedRequestValidator(Validator validator, ProjectDao projectDao, UserSession userSession) {
		this.validator = validator;
		this.projectDao = projectDao;
		this.userSession = userSession;
	}
	
	public boolean validate(Project project){
		if(!userSession.isLogged()){
			validator.add(new ValidationMessage("You have to be logged in to visualize this page", "error"));
		}
		if(doesNotHavePermissionToAccess(project)){
			validator.add(new ValidationMessage("You do not have permission to see this project", "error"));
		}
		return !validator.hasErrors();
	}

	private boolean doesNotHavePermissionToAccess(Project project) {
		return isTryingToAccessAProject(project) && doesNotHavePermission(project);
	}

	private boolean doesNotHavePermission(Project project) {
		return !projectDao.checkPermissionOfUserInProject(userSession.getUser(), project);
	}

	private boolean isTryingToAccessAProject(Project project) {
		return userSession.isLogged() && project != null;
	}
	
	public <T> T onErrorRedirectTo(Class<T> controller){
		return validator.onErrorRedirectTo(controller);
	}
	
}
