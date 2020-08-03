package com.ashik.tourblogs.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ashik.tourblogs.config.HibernateUtil;
import com.ashik.tourblogs.entities.Blog;
import com.ashik.tourblogs.entities.Blogger;

@Component
public class BloggerDao {
	private Blogger blogger = Blogger.getBean();

	public void saveBlogger(String name, String mail, String password) {
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		blogger.setName(name);
		blogger.setMail(mail);
		blogger.setPassword(password);
		session.save(blogger);
		txn.commit();
		session.close();
	}

	public boolean isUserAvalable(String mail, String password) {
		boolean exist = false;

		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Blogger where mail = :mail and password = :password");
		query.setParameter("mail", mail);
		query.setParameter("password", password);

		Blogger blogger = (Blogger) query.uniqueResult();

		if (blogger != null) {
			exist = true;
		} else {
			exist = false;
		}
		// session.beginTransaction().commit();

		return exist;
	}
	
	public Blogger getBloggerInfo(String mail) {
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Blogger where mail = :mail");
		query.setParameter("mail", mail);
		

		Blogger blogger = (Blogger) query.uniqueResult();

		return blogger;
	}
	
	public void postBlog(Blog blog) {

		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		session.save(blog);
		session.beginTransaction().commit();

	}

	public static BloggerDao getBean() {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.ashik.tourblogs.dao.BloggerDao.class);
		return context.getBean(BloggerDao.class);
	}

}
