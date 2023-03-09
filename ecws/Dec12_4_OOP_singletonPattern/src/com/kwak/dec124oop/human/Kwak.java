package com.kwak.dec124oop.human;

public class Kwak {
	private String name;
	private int age;

	
//	2. 내부에서 객체 하나 만들어서 고정시키기
	private static final Kwak KWAK = new Kwak("곽하영", 25);
	
	
//	1. 객체를 외부에서 못 만들게 => 생성자 잠그기(private)
	private Kwak() {
		// TODO Auto-generated constructor stub
	}
	
	private Kwak(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

//	3. 2번에서 만들어놓은 객체 외부에서 쓸 수 있게 하기
// 					   getInstance() 라는 이름 많이 씀
	public static Kwak getKwak() {
		return KWAK;
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
