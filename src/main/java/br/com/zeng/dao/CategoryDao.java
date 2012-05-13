package br.com.zeng.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Category;

@Component
public class CategoryDao {

	private final Session session;

	public CategoryDao(Session session) {
		this.session = session;
	}

	public Category getCategoryWithId(Long id) {
		return (Category) session.get(Category.class, id);
	}

	public void insert(Category category) {
		session.save(category);
	}
	
	
	
}
