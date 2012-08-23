package br.com.zeng.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Notification;

@Component
public class NotificationDao {

	private final Session session;

	public NotificationDao(Session session) {
		this.session = session;
	}
	
	public void insert(Notification notification){
		session.save(notification);
	}
}
