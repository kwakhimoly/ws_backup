package com.kwon.dec123oop.coffee;

public class Coffee {
	// 1. 멤버변수
	private String name;
	private int price;
	
	// 2. 생성자시리즈
	public Coffee() {
		// TODO Auto-generated constructor stub
	}

	public Coffee(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	// 3. getter, setter (캡슐화 통로 시리즈(필요한것만))
	// ctrl + shift + s
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
	
	// 4. 기타 메소드
	public void print() {
		System.out.println(name);
		System.out.println(price);
	}
}




