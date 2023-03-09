package com.kwak.dec132oop.stars;

import com.kwak.dec132oop.human.Human;

public class Planet {
	private String name;
	private int size;
	private boolean visible;

	public Planet() {
	}

	public Planet(String name) {
		super();
		this.name = name;
	}

//	public Planet(String name, int size, boolean visible) {
//		super();
//		this.name = name;
//		this.size = size;
//		this.visible = visible;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void add(Human h) {
		System.out.printf("%s에 %s 등록 완료\n", name, h.getName());
	}

}
