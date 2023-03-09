package com.kwak.dec122oop.product;

public class Product {
	String name;
	int price;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(price);
	}
	

}
