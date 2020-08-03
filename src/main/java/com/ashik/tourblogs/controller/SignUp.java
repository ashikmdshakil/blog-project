package com.ashik.tourblogs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.wiring.BeanConfigurerSupport;

import com.ashik.tourblogs.dao.BloggerDao;
import com.ashik.tourblogs.entities.Blogger;
import com.ashik.tourblogs.services.BloggerService;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private BloggerService bloggerservice = BloggerService.getBean();
	private BloggerDao bloggerdao = BloggerDao.getBean();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		bloggerdao.saveBlogger(request.getParameter("name"), request.getParameter("mail"),
				request.getParameter("password"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

}
