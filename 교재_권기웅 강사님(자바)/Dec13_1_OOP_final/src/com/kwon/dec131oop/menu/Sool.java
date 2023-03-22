package com.kwon.dec131oop.menu;

public class Sool extends Menu {
	private double _do;

	public Sool() {
		// TODO Auto-generated constructor stub
	}

	public Sool(String name, int price, double _do) {
		super(name, price);
		this._do = _do;
	}

	public double get_do() {
		return _do;
	}

	public void set_do(double _do) {
		this._do = _do;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(_do);
	}
}
