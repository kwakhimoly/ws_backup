package com.kwon.dec122oop.snack;

// access modifier(접근제어자/제한자/...)
//		public : 다
//		protected : 같은 패키지 or 다른 패키지지만 상속관계
//				- java바닥의 유명한 버그
//		안쓰기(default/friendly) : 같은 패키지에서만 접근가능
//		private : 외부에서 접근불가

//		public : 오픈
//		protected/안쓰기 : 패키지 따지겠다
//		private : 잠그기

public class Snack {
	String name;
	int price;
	
	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public Snack(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(price);
	}
}
