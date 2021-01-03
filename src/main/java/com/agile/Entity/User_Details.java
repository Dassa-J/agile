package com.agile.Entity;

public class User_Details {

	private int id;
	private String name;
	private String orders;
	
	
	public User_Details() {
	
	}

	

	public User_Details(int id, String name, String orders) {
	
		this.id = id;
		this.name = name;
		this.orders = orders;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrders() {
		return orders;
	}


	public void setOrders(String orders) {
		this.orders = orders;
	}
	
	
	
}
