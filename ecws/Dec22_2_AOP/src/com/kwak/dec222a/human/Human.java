package com.kwak.dec222a.human;

public class Human {
	private String name;
	private int age;

	public Human() {
	}

	public Human(String name, int age) {
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
	
	private /*밖에서 안 쓸거니까 잠그기*/ void ready() {
		System.out.println("씻고");
		System.out.println("단장하고");
		System.out.println("나가서");
		System.out.println("엘베타고");		
	}
	
	public void goSchool() {
		ready();
		System.out.println("버스");
		System.out.println("지하철");
		System.out.println("도착");
	}
	
	public void goMart() {
		ready();
		System.out.println("자전거");
		System.out.println("도착");
	}
	
	
}
