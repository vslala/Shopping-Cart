package com.bitwise.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitwise.model.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		System.out.println(request.getParameter("currProduct"));
		String productName = request.getParameter("prodName");
		Double productPrice = Double.parseDouble(request.getParameter("prodPrice"));
		String productDesc = request.getParameter("prodDesc");
		String submit = request.getParameter("submit");
		HttpSession session = request.getSession();
		
		if (submit == null) {
			System.out.println("No Product Added");
			return;
		}
		
		if (submit.equals("add")) {
			if (isCartNull(session)) {
				initializeCart(productName, productPrice, productDesc, session);
				response.sendRedirect("cart.jsp");
				return;
			} else {
				addItemToCart(productName, productPrice, productDesc, session);
				response.sendRedirect("cart.jsp");
				return;
			}
		}
		
		if (submit.equals("remove")) {
			if (isCartNotEmpty(session)) {
				removeItemFromCart(productName, productPrice, productDesc, session);
				response.sendRedirect("cart.jsp");
				return;
			}
		}
		
	}

	private boolean isCartNotEmpty(HttpSession session) {
		return session.getAttribute("cart") != null;
	}

	private boolean isCartNull(HttpSession session) {
		return session.getAttribute("cart") == null;
	}

	private void addItemToCart(String productName, Double productPrice, String productDesc, HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		cart.addItem(new Product(productName, productPrice, productDesc));
	}

	private void removeItemFromCart(String productName, Double productPrice, String productDesc, HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		cart.removeItem(new Product(productName, productPrice, productDesc));
	}

	private void initializeCart(String productName, Double productPrice, String productDesc, HttpSession session) {
		Cart cart = new Cart ();
		session.setAttribute("cart", cart);
		cart.addItem(new Product(productName, productPrice, productDesc));
	}

}
