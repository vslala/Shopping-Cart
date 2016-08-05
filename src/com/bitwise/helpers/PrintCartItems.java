package com.bitwise.helpers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.bitwise.controllers.Cart;
import com.bitwise.model.Product;

public class PrintCartItems extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
		PrintWriter out = response.getWriter();
		Cart cart = (Cart)request.getSession(false).getAttribute("cart");
		List<Product> cartItems = cart.getCartItems();
		
		double sum = 0d;
		out.println("<center>"
				+ "<table>"
				+ "<tr><th>Cart Items</th></tr>");
		for (Product item: cartItems) {
			out.println("<tr>"
					+ "<td>"+item.getName() + "</td><td>" + item.getPrice()+"</td>"
							+ "</tr>");
			sum += sum + item.getPrice();
		}
		out.println("<tr><td>Total Price: <span class='red'>" + sum + " INR</span></td></tr>");
		out.println("</table>"
				+ "</center>");
		
		out.flush();
		
	}
}
