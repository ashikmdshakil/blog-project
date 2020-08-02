package com.ashik.tourblogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ashik.tourblogs.dao.BloggerDao;
import com.ashik.tourblogs.entities.Blog;
import com.ashik.tourblogs.entities.Blogger;
import com.ashik.tourblogs.repositories.BloggerRepo;
@Component
public class BloggerService implements BloggerRepo {
	private BloggerDao bloggerdao = BloggerDao.getBean();

	public void signup(String name, String mail, String password) {
		// TODO Auto-generated method stub
		bloggerdao.saveBlogger(name, mail, password);
	}

	public boolean login(String mail, String password) {
		// TODO Auto-generated method stub
		boolean exist = false;
		if(bloggerdao.isUserAvalable(mail, password)) {
			exist = true;
		}
		else {
			exist = false;
		}
		return exist;

	}

	public void post(Blog blog) {
		// TODO Auto-generated method stub
		bloggerdao.postBlog(blog);
	}

	public void comment() {
		// TODO Auto-generated method stub
		System.out.println("hello");

	}

	public void showOwnPost() {
		// TODO Auto-generated method stub
		System.out.println("hello");

	}

	public void logout() {
		// TODO Auto-generated method stub
		System.out.println("hello");

	}
	public static BloggerService getBean() {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.ashik.tourblogs.services.BloggerService.class);
		return context.getBean(BloggerService.class);
	}

	public Blogger bloggerInfo(String mail) {
		// TODO Auto-generated method stub
		return bloggerdao.getBloggerInfo(mail);
	}

}
