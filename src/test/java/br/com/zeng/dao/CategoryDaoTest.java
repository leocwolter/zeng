package br.com.zeng.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintViolationException;

import org.hibernate.ObjectNotFoundException;
import org.junit.Before;
import org.junit.Test;

import br.com.zeng.model.Category;
import br.com.zeng.model.Project;

public class CategoryDaoTest extends DaoTest {
	private CategoryDao categoryDao;
	
	@Before
	public void setUp() {
		super.setUp();
		categoryDao = new CategoryDao(session);
	}

	@Test
	public void shouldReturnACategoryById() {
		Project zeng = new Project("Zeng");
		session.save(zeng);
		Category test = new Category(zeng, "test category");
		categoryDao.insert(test);
		Category categoryComplete = categoryDao.getCategoryWithId(test.getId());
		assertNotNull(categoryComplete);
		assertEquals(test.getName(), categoryComplete.getName());
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void shouldThrowConstraintViolationExceptionForCategoryWithoutProject() {
		Category category = new Category(null,"");
		categoryDao.insert(category);
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void shouldThrowConstraintViolationExceptionForCategoryWithoutName() {
		Project zeng = new Project("Zeng");
		session.save(zeng);
		Category category = new Category(zeng,"");
		categoryDao.insert(category);
	}

	@Test
	public void shouldGetCategoryByUrlAndProject() {
		Project zeng = new Project("Zeng");
		session.save(zeng);
		Category category = new Category(zeng,"back-end");
		categoryDao.insert(category);
		Category gotCategory = categoryDao.getCategoryWithUrlAndProject("back-end", "zeng");
		assertTrue(gotCategory.getUrl().equals(category.getUrl()));
	}
	
	@Test(expected=ObjectNotFoundException.class)
	public void shouldThrowExceptionIfDidntFindCategory() {
		categoryDao.getCategoryWithUrlAndProject("unexistent", "zeng");
	}

}
