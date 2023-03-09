package com.kwak.dec131oop.tea;

public /*final*/ abstract class Tea {
	private String name;
	private String maker;
	private int time;
	
	public Tea() {
		// TODO Auto-generated constructor stub
	}

	public Tea(String name, String maker, int time) {
		super();
		this.name = name;
		this.maker = maker;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public /*final*/ void printInfo() {
		System.out.println(name);
		System.out.println(maker);
		System.out.println(time);
	}
	

	
	public abstract void taste();
}
