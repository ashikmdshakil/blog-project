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
import com.ashik.tourblogs.entities.Comment;

@Component
public class CommentDao {
	
	public void saveComment(Comment comment){
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		session.save(comment);                
		session.beginTransaction().commit();
	}
	
	public void deleteComment(int comment_id) {
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = session.createSQLQuery("select * from Comment where id = '"+comment_id+"';");
		query.addEntity(Comment.class);
		Comment comment = (Comment) query.uniqueResult();
		session.delete(comment);
		session.beginTransaction().commit();
	}
	
	public static CommentDao getBean() {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.ashik.tourblogs.dao.CommentDao.class);
		return context.getBean(CommentDao.class);
	}
}
