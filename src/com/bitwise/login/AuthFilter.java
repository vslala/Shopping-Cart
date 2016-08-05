package com.bitwise.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.management.RuntimeErrorException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */

public class AuthFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		PrintWriter out = res.getWriter();
		
		System.out.println(req.getRequestURI());

		if (isLogoutRequest(req)) {
			System.out.println("Session Invalidated");
			session.invalidate();
			res.sendRedirect("login.jsp");
			return;
		}
		if (req.getRequestURI().equals("/ShoppingCart/cart.jsp")) {
			if (isNotAValidUser(req)) {
				res.sendRedirect("login.jsp");
				return;
			}
		}
		
		chain.doFilter(req, res);
	}

	private boolean isLoginRequest(HttpServletRequest req) {
		return req.getRequestURI().equals("/ShoppingCart/login.jsp");
	}

	private boolean isLogoutRequest(HttpServletRequest req) {
		return req.getRequestURI().equals("/ShoppingCart/logout.jsp");
	}

	private boolean isValidUser(HttpServletRequest req) {
		if (req.getSession(false) != null)
			return req.getSession(false).getAttribute("username") != null;
		return false;
	}

	private boolean isNotAValidUser(HttpServletRequest req) {
		return req.getSession(false).getAttribute("username") == null;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
