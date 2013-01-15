package br.com.zeng.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component @RequestScoped
public class SessionCreator implements ComponentFactory<Session> {
    
    private final SessionFactory sf;
    private Session session;

    public SessionCreator(SessionFactory sf) {
        this.sf = sf;
    }
    @PostConstruct
    public void create() {
        session = sf.openSession();
    }
    
    @Override
    public Session getInstance() {
    	return session;
    }
    
    @PreDestroy
    public void destroy() {
        session.close();
    }

}