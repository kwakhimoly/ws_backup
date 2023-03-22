package com.kwon.dec132oop.human;

import com.kwon.dec132oop.hero.Hero;

// Avengers a = new Ironman();
// Avengers a = new Spiderman();
public class Human {
	private String name;
	private Hero hero;

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

	public void pick(Hero h) {
		hero = h;
	}
	
	public void helpMe() {
		hero.attack();
	}
	
}



