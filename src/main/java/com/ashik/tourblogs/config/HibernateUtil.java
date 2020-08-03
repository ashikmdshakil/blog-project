package com.ashik.tourblogs.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration().configure("myhibernate.cfg.xml")
				.addAnnotatedClass(com.ashik.tourblogs.entities.Blogger.class)
				.addAnnotatedClass(com.ashik.tourblogs.entities.Blog.class)
				.addAnnotatedClass(com.ashik.tourblogs.entities.Comment.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		return sf;
	}

}
