package br.com.zeng.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class GenericDao<T> {

	private final Class<T> clazz;
	private final Session session;

	public GenericDao(Session session, Class<T> clazz) {
		this.session = session;
		this.clazz = clazz;
	}
	
	@SuppressWarnings("unchecked")
	public T getById(Long id) {
		return (T) session.get(clazz, id);
	}

	public void insert(T t) {
		session.save(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		return session.createCriteria(clazz).list();
	}

	public void update(T t) {
		session.update(t);
	}
	
	
}
