package com.kwon.dec123oop.human;

// 쓸려고 만든건데 -> public을 줘야
// public줘서 직접 수정하게 하면 위험

// encapsulation(캡슐화)
// 데이터를 안전하게 취급하자
public class Human {
// 		1. 멤버변수 private줘서 외부에서 못건들게
	private String name;
	private int age;

	public Human() {
		// TODO Auto-generated constructor stub
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

// 	2. 멤버변수에 접근할 수 있는 통로를 파서
	public void setAge(int age) {
		// 	3. 그 통로에 안전장치
		if (age < 0) {
			age *= -1;
		}
		this.age = age;
	}

	public void print() {
		System.out.println(name);
		System.out.println(age);
	}
}
