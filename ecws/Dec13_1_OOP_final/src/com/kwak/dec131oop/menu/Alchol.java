package com.kwak.dec131oop.menu;

public class Alchol extends Menu {
	private double _do;

	public Alchol() {
		// TODO Auto-generated constructor stub
	}

	public Alchol(String name, int price, double _do) {
		super(name, price);
		this._do = _do;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(_do);
	}
}
