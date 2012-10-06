package br.com.zeng.dao;

import static org.hibernate.criterion.Order.desc;
import static org.hibernate.criterion.Restrictions.like;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.model.Notification;
import br.com.zeng.model.Project;

@Component
public class NotificationDao {

	private final Session session;

	public NotificationDao(Session session) {
		this.session = session;
	}
	
	public void insert(Notification notification){
		session.save(notification);
	}

	@SuppressWarnings("unchecked")
	public List<Notification> getNotificationsOfProject(Project project) {
		List<Notification> notifications = session.createCriteria(Notification.class)
											.add(like("project.id", project.getId()))
											.addOrder(desc("creationDate")).list();
		return notifications;
	}
	
	
}
