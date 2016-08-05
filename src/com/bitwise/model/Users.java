package com.bitwise.model;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private List<User> users = new ArrayList<>();
	
	public Users () {
		this.initUsers();
	}
	
	public void initUsers () {
		users.add(new User("pikachu", "electric"));
		users.add(new User("balbasaur", "forests"));
		users.add(new User("charizard", "fire"));
		users.add(new User("meow", "cat"));
		users.add(new User("richu", "electric"));
	}
	
	public List getUsers () {
		return this.users;
	}
}
