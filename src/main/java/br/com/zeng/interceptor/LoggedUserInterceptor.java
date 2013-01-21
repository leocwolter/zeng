package br.com.zeng.interceptor;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.zeng.annotation.LoggedUser;
import br.com.zeng.controller.UserController;
import br.com.zeng.dao.ProjectDao;
import br.com.zeng.model.Project;
import br.com.zeng.validator.LoggedRequestValidator;

@Intercepts
public class LoggedUserInterceptor implements Interceptor {

	private final HttpServletRequest req;
	private final ProjectDao projectDao;
	private final LoggedRequestValidator validator;

    public LoggedUserInterceptor(LoggedRequestValidator validator, ProjectDao projectDao, HttpServletRequest req) {
        this.validator = validator;
		this.projectDao = projectDao;
		this.req = req;
    }

    @Override
    public boolean accepts(ResourceMethod method) {
        return method.getMethod().isAnnotationPresent(LoggedUser.class);
    }

    @Override
    public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance)
            throws InterceptionException {
    		String projectUrl = req.getParameter("projectUrl");
        	Project project = projectDao.getProjectWithUrl(projectUrl);
        	if(validator.validate(project)){
        		stack.next(method, resourceInstance);
        	}else{
        		validator.onErrorRedirectTo(UserController.class).home();
        	}
        	
    	}
}
