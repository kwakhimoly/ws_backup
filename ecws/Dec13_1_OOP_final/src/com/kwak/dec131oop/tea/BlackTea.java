package com.kwak.dec131oop.tea;

public class BlackTea extends Tea {
	
	private boolean milkTea;
	
	@Override
	public void taste() {
		System.out.println("good");
	}
	
	public BlackTea() {
		// TODO Auto-generated constructor stub
	}

	public BlackTea(String name, String maker, int time, boolean milkTea) {
		super(name, maker, time);
		this.milkTea = milkTea;
	}

	public boolean isMilkTea() {
		return milkTea;
	}

	public void setMilkTea(boolean milkTea) {
		this.milkTea = milkTea;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(milkTea);
	}

	
	

}
