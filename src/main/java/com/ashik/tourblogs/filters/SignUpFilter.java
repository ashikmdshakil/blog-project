package com.ashik.tourblogs.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashik.tourblogs.dao.BloggerDao;

/**
 * Servlet Filter implementation class SignUpFilter
 */
public class SignUpFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SignUpFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String mail = req.getParameter("mail");
		
		BloggerDao bloggerdao = BloggerDao.getBean();
		if(bloggerdao.isBloggerAvalable(mail)) {
			String message = "An account with this email already exists ....";
			req.setAttribute("message", message);
			RequestDispatcher dispatcher = req.getRequestDispatcher("errorpage.jsp");
			dispatcher.forward(req, res);
			
		}
		else {
			chain.doFilter(request, response);
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
