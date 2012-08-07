package br.com.zeng.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.zeng.model.Category;

public class CategoryDaoTest extends DaoTest {
	private CategoryDao categoryDao;
	private Category category;
	
	@Before
	public void setUp() {
		super.setUp();
		categoryDao = new CategoryDao(session);
		category = new Category();
		category.setName("test category");
		categoryDao.insert(category);
	}

	@Test
	public void shouldReturnACategoryById() {
		Category categoryComplete = categoryDao.getCategoryWithId(category.getId());
		assertNotNull(categoryComplete);
		assertEquals(category.getName(), categoryComplete.getName());
	}

}
