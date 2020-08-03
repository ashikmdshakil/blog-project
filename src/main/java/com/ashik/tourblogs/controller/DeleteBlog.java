package com.ashik.tourblogs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashik.tourblogs.services.BlogService;

@WebServlet("/deleteBlog")
public class DeleteBlog extends HttpServlet {

	private BlogService blogservice = BlogService.getBean();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("blog_id"));
			blogservice.deleteBlog(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("myblogs");
			dispatcher.forward(request, response);
		} catch (NumberFormatException e) {
			String message = "Something went wrong. Please try agaian ....";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("errorpage.jsp");
			dispatcher.forward(request, response);
		} 

	}
}
