package com.bitwise.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitwise.model.User;
import com.bitwise.model.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User (username, password);
		PrintWriter out = response.getWriter();
		
		if (isValidUser(user)) {
			System.out.println("User is Valid");
			redirectToHome(request, response);
			startSession(request, username);
			return;
		} else {
			System.out.println("User is invalid");
			response.setContentType("text/html");
			out.println("<div class='container'>"
					+ "<span style='color: red;'>Invalid Credentials!</span>"
					+ "</div>");
			invalidateSession(request);
			request.getRequestDispatcher("login.jsp").include(request, response);
			return;
		}
	}

	private void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("title", "Login");
		response.sendRedirect("login.jsp");
		return;
	}

	private void redirectToHome(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("title", "Home Cart");
		response.sendRedirect("home.jsp");
	}

	private void invalidateSession(HttpServletRequest request) {
		request.getSession(false).invalidate();
	}

	private boolean isValidUser(User user) {
		return new Users().getUsers().contains(user);
	}

	private void startSession(HttpServletRequest request, String username) {
		HttpSession session = request.getSession(true);
		session.setAttribute("username", username);
	}

}
