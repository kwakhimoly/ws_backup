package com.kwon.dec125oop.avengers;

// 생성자 상속은 왜 안해주나
//		게임만든다
//			아이언맨
//			헐크
//			어벤져스 : 아이언맨/헐크 묶어서 부르는 추상적인 개념
//						실체x

// 추상클래스
//		추상메소드가 하나라도 있다면 추상클래스여야
//		객체 못만듬[attack이 미완성인데...]
public abstract class Avengers {
	private String name;
	private int age;
	
	public Avengers() {
		// TODO Auto-generated constructor stub
	}

	public Avengers(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(age);
	}
	
	// 추상 메소드 : 내용 없는 메소드
	//				하위클래스에서 반드시 오버라이딩해야
	public abstract void attack();
}





