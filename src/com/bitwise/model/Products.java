package com.bitwise.model;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private List<Product> products = new ArrayList<>();
	
	public Products () {
		this.initProducts();
	}
	
	public void initProducts () {
		products.add(new Product("HP Spectre X30", 87000.00, "Best Performer"));
		products.add(new Product("Dell Latitude 5230", 77999.00, "Rigid Hard"));
		products.add(new Product("Dell Alienware", 187000.00, "Rigged for Gaming"));
		products.add(new Product("Asus Firefighter", 97000.00, "Best in the league"));
		products.add(new Product("HP Spectre X30", 87000.00, "Best Performer"));
	}
	
	public List getProducts () {
		return this.products;
	}
}
