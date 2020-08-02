package com.ashik.tourblogs.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.ashik.tourblogs.config.HibernateUtil;
import com.ashik.tourblogs.dao.BlogDao;
import com.ashik.tourblogs.entities.Blog;
@Component
public class BlogService {
	
	private BlogDao blogdao = BlogDao.getBean();
	
public List<Blog> getBlogs(){
		return blogdao.getBlogs();
	}

public List<Blog> getMyBlogs(int id){
	return blogdao.getMyBlogs(id);
}

	
	public static BlogService getBean() {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.ashik.tourblogs.services.BlogService.class);
		return context.getBean(BlogService.class);
	}

}
