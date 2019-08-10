package com.accolite.au;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Utility {
	public Session getsession()
	{
		Configuration con=new Configuration().configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(con.getProperties());
		SessionFactory sessionFactory = con.buildSessionFactory(ssrb.build());
		Session session = sessionFactory.openSession();
		return session;
	}

}
