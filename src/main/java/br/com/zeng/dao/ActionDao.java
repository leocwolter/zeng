package br.com.zeng.dao;

import static org.hibernate.criterion.Order.desc;
import static org.hibernate.criterion.Restrictions.like;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.zeng.mailer.ZengMailer;
import br.com.zeng.model.Action;
import br.com.zeng.model.Project;

@Component
public class ActionDao {

	private final Session session;
	private final ZengMailer mailer;

	public ActionDao(Session session, ZengMailer mailer) {
		this.session = session;
		this.mailer = mailer;
	}
	
	public void insert(Action action){
		session.save(action);
		mailer.montaEEnviaEmail(action);
	}

	@SuppressWarnings("unchecked")
	public List<Action> getActionsOf(Project project) {
		List<Action> actions = session.createCriteria(Action.class)
											.add(like("project.id", project.getId()))
											.addOrder(desc("creationDate")).list();
		return actions;
	}
	
	
}
