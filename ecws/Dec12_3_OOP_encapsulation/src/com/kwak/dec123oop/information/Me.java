package com.kwak.dec123oop.information;

public class Me {
	private String name;
	private int age;
	private boolean cold;

	public Me() {
		// TODO Auto-generated constructor stub
	}

	public Me(String name, int age, boolean cold) {
		super();
		this.name = name;
		this.age = age;
		this.cold = cold;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCold() {
		return cold;
	}

	public void setCold(boolean cold) {
		this.cold = cold;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(cold);
	}

}
