package br.com.zeng.dao;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Category;

@Component
public class CategoryDao {
	private GenericDao<Category> dao;
	private final Session session;

	public CategoryDao(Session session) {
		this.session = session;
		dao = new GenericDao<Category>(session, Category.class);
	}

	public Category getCategoryWithId(Long id) {
		return dao.getById(id);
	}

	public void insert(Category category) {
		dao.insert(category);
	}

	public Category getCategoryWithUrlAndProject(String categoryUrl, String projectUrl) {
		Query query = session.createQuery("from Category c where c.url like :categoryUrl and c.project.url like :projectUrl")
			.setString("categoryUrl", categoryUrl)
			.setString("projectUrl", projectUrl);
		Category category = (Category) query.uniqueResult();
		if(category == null) throw new ObjectNotFoundException(categoryUrl+" in project "+projectUrl, "Category");
		return category;
	}
	
	
	public Category getCategoryWithUrl(String categoryUrl) {
		return dao.getByUrl(categoryUrl);
	}
	
}
