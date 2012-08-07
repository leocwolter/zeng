package br.com.zeng.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;

public class DaoTest {

	protected Session session;
	private SessionFactory sf;

	@Before
	public void setUp() {
		Configuration configuration = new Configuration();
		sf = configuration.configure("/hibernate.test.cfg.xml").buildSessionFactory();
		session = sf.openSession();
		session.beginTransaction();
	}

	@After
	public void tearDown() {
		session.getTransaction().rollback();
		session.close();
		sf.close();
	}

}
