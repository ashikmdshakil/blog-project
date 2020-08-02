package com.ashik.tourblogs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ashik.tourblogs.entities.Blog;
import com.ashik.tourblogs.entities.Blogger;
import com.ashik.tourblogs.services.BlogService;
import com.ashik.tourblogs.services.BloggerService;

@WebServlet("/login")
public class LogIn extends HttpServlet {

	private BloggerService bloggerservice = BloggerService.getBean();
	private BlogService blogservice = BlogService.getBean();
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if (bloggerservice.login(request.getParameter("mail"), request.getParameter("password"))) {
			Blogger blogger = bloggerservice.bloggerInfo(request.getParameter("mail"));
			HttpSession session = request.getSession();
			session.setAttribute("blogger", blogger);
			
			request.setAttribute("blogs", blogservice.getBlogs());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("blogpage.jsp");
			dispatcher.forward(request, response);
			
		}

		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	}

}
