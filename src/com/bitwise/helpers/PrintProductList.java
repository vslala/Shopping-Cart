package com.bitwise.helpers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.bitwise.model.Product;
import com.bitwise.model.Products;

public class PrintProductList extends SimpleTagSupport {
	

	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		PrintWriter out = response.getWriter();
		
		List<Product> products = new Products().getProducts();
/*		
		out.println("<select name='currProduct'>");
		for (int index=0; index < products.size(); index++) {
			out.println(
					"<option value='"+products.get(index).getName()+
					","+products.get(index).getPrice()+","+
							products.get(index).getDesc()
							+ "'>"
					+products.get(index).getName()
					+"</option>"
					);
		}
		out.println("</select>");*/
		
		for (Product p: products) {
			printCartItems(out, p);
		}
		out.flush();
	}

	private void printCartItems(PrintWriter out, Product p) {
		out.println("<center>");
		out.println("<table>");
		out.println("<form action='CartServlet' method='post' >");
		out.println("<input type='hidden' value='"+p.getDesc()+"' name='prodDesc'/> ");
		out.println("<input type='hidden' value='"+p.getPrice()+"' name='prodPrice'/> ");
		out.println("<input type='hidden' value='"+p.getName()+"' name='prodName'/> ");
		out.println("<tr>");
		out.println("<td>"
				+ p.getName()
				+ "</td>");
		out.println("<td>"
				+ p.getPrice()
				+ "</td>");
		out.println("<td>"
				+ "<input class='btn' type='submit' name='submit' value='add' /> "
				+ "</td>");
		out.println("<td>"
				+ "<input class='btn' type='submit' name='submit' value='remove' /> "
				+ "</td>");
		out.println("</tr>");
		
		out.println("</form>");
		out.println("</table>");
		out.println("</center>");
	}
}
