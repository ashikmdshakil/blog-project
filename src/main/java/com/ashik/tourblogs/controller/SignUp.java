package com.ashik.tourblogs.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.wiring.BeanConfigurerSupport;


import com.ashik.tourblogs.entities.Blogger;
import com.ashik.tourblogs.services.BloggerService;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private BloggerService bloggerservice = BloggerService.getBean();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		bloggerservice.signup(request.getParameter("name"), request.getParameter("mail"),
				request.getParameter("password"));
		response.sendRedirect("home.jsp");
	}

}
