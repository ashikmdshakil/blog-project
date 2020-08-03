package com.ashik.tourblogs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.cglib.proxy.Dispatcher;

import com.ashik.tourblogs.entities.Blog;
import com.ashik.tourblogs.services.BlogService;
import com.ashik.tourblogs.services.BloggerService;

@WebServlet("/blogs")
public class Blogs extends HttpServlet {
	private BlogService blogservice = BlogService.getBean();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {	
		try {
			request.setAttribute("blogs", blogservice.getBlogs());
			RequestDispatcher dispatcher = request.getRequestDispatcher("blogpage.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			String message = "Something went wrong. Please try agaian ....";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("errorpage.jsp");
			dispatcher.forward(request, response);
		}
	}
}
