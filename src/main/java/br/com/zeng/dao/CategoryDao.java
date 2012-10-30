package br.com.zeng.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Category;

@Component
public class CategoryDao {
	private GenericDao<Category> dao;

	public CategoryDao(Session session) {
		dao = new GenericDao<Category>(session, Category.class);
	}

	public Category getCategoryWithId(Long id) {
		return dao.getById(id);
	}

	public void insert(Category category) {
		dao.insert(category);
	}

	public Category getCategoryWithUrl(String categoryUrl) {
		return dao.getByUrl(categoryUrl);
	}
	
}
