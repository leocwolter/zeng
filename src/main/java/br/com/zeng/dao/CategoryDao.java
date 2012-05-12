package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Category;
import br.com.zeng.model.Project;

@Component
public class CategoryDao {
	
	private final Session session;

	public CategoryDao(Session session) {
		this.session = session;
	}
	
	public List<Category> listWithProject(Project project) {
		return session.createCriteria(Category.class).add(Restrictions.eq("project.id", project.getId())).list();
	}
}
