package com.kwon.dec121oop.animal;

public class Cat {
	String name;
	int age;
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(age);
	}
}
