package com.ashik.tourblogs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.ashik.tourblogs.config.HibernateUtil;
import com.ashik.tourblogs.entities.Blog;

@Component
public class BlogDao {
	
	public List<Blog> getBlogs(){
		
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Blog order by time DESC");
		List<Blog> blogs = query.list();                   
		//session.beginTransaction().commit();
		session.close();
		return blogs;
	}
	public List<Blog> getMyBlogs(int id){
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = session.createSQLQuery("select * from Blog where blogger_id = '"+id+"' order by time DESC;");
		query.addEntity(Blog.class);
		List<Blog> blogs = query.list();
		session.close();
		return blogs;
	}
	public void deleteBlog(int id) {
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = session.createSQLQuery("delete from Blog where id = '"+id+"'");
		query.addEntity(Blog.class);
		query.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}
	
	public static BlogDao getBean() {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.ashik.tourblogs.dao.BlogDao.class);
		return context.getBean(BlogDao.class);
	}
}
