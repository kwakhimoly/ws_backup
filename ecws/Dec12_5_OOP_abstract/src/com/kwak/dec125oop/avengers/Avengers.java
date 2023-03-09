package com.kwak.dec125oop.avengers;

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

	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
	}

	public abstract void attack();
//		추상 메소드: 내용 없는 메소드
//					하위 클래스에서 반드시 오버라이딩 해야함
//		Avengers: attack이라는 추상 메소드를 갖고 있음 
//		=> 추상 클래스 (abstract class)
//				: 객체 못 만듦 => attack이 미완성인데...
		
		

}
