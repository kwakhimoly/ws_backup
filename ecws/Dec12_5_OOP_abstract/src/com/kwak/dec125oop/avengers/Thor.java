package com.kwak.dec125oop.avengers;

public class Thor extends Avengers {
	private String weapon;

	private static final Thor THOR = new Thor("Thor", 3000, "Molnir");
	private Thor() {
		// TODO Auto-generated constructor stub
	}

	private Thor(String name, int age, String weapon) {
		super(name, age);
		this.weapon = weapon;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public static Thor getThor() {
		return THOR;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(weapon);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("thunder");
	}

}
