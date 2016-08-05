package com.bitwise.helpers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TitlePrinter extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		PrintWriter out = response.getWriter();
		
		if (request.getAttribute("title") == null) {
			out.print("Shopping Cart");
			out.flush();
			return;
		}
		
		if (! (request.getAttribute("title").equals("") || 
				request.getAttribute("title") == null) ) {
			out.print(request.getAttribute("title"));
		} else {
			out.print("Shopping Cart");
		}
		out.flush();
	}
}
