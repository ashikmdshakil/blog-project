package com.ashik.tourblogs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashik.tourblogs.services.CommentService;
@WebServlet("/comment")
public class Comment extends HttpServlet{
	
	private CommentService commentservice = CommentService.getBean();
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int blogger_id = Integer.parseInt(request.getParameter("blogger_id"));
		int blog_id = Integer.parseInt(request.getParameter("blog_id"));
		String comment = request.getParameter("comment");	
		commentservice.postComment(blogger_id, blog_id, comment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("blogs");
		dispatcher.forward(request, response);
	}

}
