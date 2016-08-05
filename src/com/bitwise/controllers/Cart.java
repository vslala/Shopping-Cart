package com.bitwise.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bitwise.model.Product;

public class Cart {
	private List<Product> cartItems = new ArrayList<>();
	
	public void addItem (Product prod) {
		cartItems.add(prod);
	}
	
	public void removeItem (Product prod) {
		if (cartItems.contains(prod)) {
			cartItems.remove(prod);
		}
	}
	
	public List<Product> getCartItems () {
		return this.cartItems;
	}
	
}
