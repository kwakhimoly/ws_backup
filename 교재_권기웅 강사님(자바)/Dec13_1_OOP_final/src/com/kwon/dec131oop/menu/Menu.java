package com.kwon.dec131oop.menu;

// final 멤버변수 : 상수화
// final 메소드 : 오버라이딩 불가
// final 클래스 : 상속 불가
public final class Menu {
	private String name;
	private int price;
		
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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
	
	public /* final */ void print() {
		System.out.println(name);
		System.out.println(price);
	}
}



