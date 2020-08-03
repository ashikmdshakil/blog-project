package com.ashik.tourblogs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.wiring.BeanConfigurerSupport;

import com.ashik.tourblogs.dao.BloggerDao;
import com.ashik.tourblogs.entities.Blogger;
import com.ashik.tourblogs.services.BlogService;
import com.ashik.tourblogs.services.BloggerService;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private BloggerService bloggerservice = BloggerService.getBean();
	BlogService blogservice = BlogService.getBean();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try {
			bloggerservice.signup(request.getParameter("name"), request.getParameter("mail"),
					request.getParameter("password"));
			Blogger blogger = bloggerservice.bloggerInfo(request.getParameter("mail"));
			HttpSession session = request.getSession();
			session.setAttribute("blogger", blogger);
			request.setAttribute("blogs", blogservice.getBlogs());
			RequestDispatcher dispatcher = request.getRequestDispatcher("blogpage.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			String message = "Something went wrong ....";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("errorpage.jsp");
			dispatcher.forward(request, response);
		} 

	}

}
