package com.ashik.tourblogs.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashik.tourblogs.entities.Blog;
import com.ashik.tourblogs.entities.Blogger;
import com.ashik.tourblogs.services.BlogService;
import com.ashik.tourblogs.services.BloggerService;
@WebServlet("/post")
public class PostBlogs extends HttpServlet{
	private Blog blog = Blog.getBean();
	private Blogger blogger = Blogger.getBean();
	private BloggerService bloggerservice = BloggerService.getBean();
	private BlogService blogservice = BlogService.getBean();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		blog.setTitle(request.getParameter("title"));
		blog.setBlog(request.getParameter("blog"));
		blog.setTime(LocalDateTime.now());
		blog.setBlogger((Blogger)request.getSession().getAttribute("blogger"));
		bloggerservice.post(blog);
		
		request.setAttribute("blogs", blogservice.getBlogs());
		RequestDispatcher dispatcher = request.getRequestDispatcher("blogpage.jsp");
		dispatcher.forward(request, response);
	}

}
