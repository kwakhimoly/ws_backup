package com.kwon.dec124oop.human;

// static 멤버변수 : 여러객체의 공통속성

// 객체가 필요한가
//		필요없으면 -> static메소드 기반으로
//		필요하면
//			딱 하나필요 : singleton패턴
//			여러개필요 : 평소대로, ...

public class Kwon {
	private String name;
	private int age;
	// 2. 내부에서 객체 하나 만들어서 고정시키기
	private static final Kwon KWON = new Kwon("권", 36);
	
	// 1. 객체를 외부에서 못 만들게
	private Kwon() {
		// TODO Auto-generated constructor stub
	}

	private Kwon(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	// 3. 2번에서 만들어놓은 객체 외부에서 쓸 수 있게
					// getInstance라는 이름 많이 씀
	public static Kwon getKwon() { 
		return KWON;
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
}



