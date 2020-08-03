package com.ashik.tourblogs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ashik.tourblogs.dao.BlogDao;
import com.ashik.tourblogs.dao.BloggerDao;
import com.ashik.tourblogs.entities.Blogger;
import com.ashik.tourblogs.services.BlogService;

@WebServlet("/myblogs")
public class MyBlogs extends HttpServlet{
	private BlogService blogservice = BlogService.getBean();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Blogger blogger = (Blogger) session.getAttribute("blogger");
			request.setAttribute("blogs", blogservice.getMyBlogs(blogger.getId()));
			RequestDispatcher dispatcher = request.getRequestDispatcher("myblogpage.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			String message = "Something went wrong. Please try agaian ....";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("errorpage.jsp");
			dispatcher.forward(request, response);
		} 
	}
}
