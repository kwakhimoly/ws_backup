package com.kwak.dec125oop.avengers;

public class Hulk extends Avengers {

	private int pants;

	public Hulk() {
		// TODO Auto-generated constructor stub
	}

	public Hulk(String name, int age, int pants) {
		super(name, age);
		this.pants = pants;
	}

	public int getPants() {
		return pants;
	}

	public void setPants(int pants) {
		this.pants = pants;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(pants);
	}

	@Override
	public void attack() {
		System.out.println("헐크 스매쉬");
	}
}
