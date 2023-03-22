package com.kwon.dec123oop.human;

// static 멤버변수 : 객체가 여러개인데 그게 다 같은 값...
public class Kwon {
	private String name;
	private int age;
	private boolean cold;
	
	public Kwon() {
		// TODO Auto-generated constructor stub
	}

	public Kwon(String name, int age, boolean cold) {
		super();
		this.name = name;
		this.age = age;
		this.cold = cold;
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

	public boolean isCold() {
		return cold;
	}

	public void setCold(boolean cold) {
		this.cold = cold;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(cold);
	}
	
}
