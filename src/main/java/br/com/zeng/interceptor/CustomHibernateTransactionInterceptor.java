package br.com.zeng.interceptor;

import org.hibernate.Session;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.util.hibernate.HibernateTransactionInterceptor;

@Intercepts
public class CustomHibernateTransactionInterceptor extends HibernateTransactionInterceptor{

	public CustomHibernateTransactionInterceptor(Session session, Validator validator) {
		super(session, validator);
	}

}
