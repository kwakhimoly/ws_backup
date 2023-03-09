package com.kwak.dec132oop.human;

public class Human {
	private String name;
	private Hero hero; // Has A 관계 + 다형성(영웅의 하위 클래스가 다 속함)
	
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hero getHero() {
		return hero;
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public void pick(Hero h) {
		setHero(h);
	}

	public void helpMe() {
		hero.attack();
	}

}
