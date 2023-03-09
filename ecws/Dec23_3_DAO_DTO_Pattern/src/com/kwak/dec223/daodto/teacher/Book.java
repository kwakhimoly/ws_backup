package com.kwak.dec223.daodto.teacher;

public class Book {
	private String name; // 멤버변수, 속성, 필드
	private int price;
	private String genre;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String name, int price, String genre) {
		super();
		this.name = name;
		this.price = price;
		this.genre = genre;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
