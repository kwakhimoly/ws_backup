package com.kwon.dec122oop.main;

import com.kwon.dec122oop.snack.Snack;

public class OMain {
	public static void main(String[] args) {
		Snack s = new Snack("새우깡", 1500);
		s.print();
		System.out.println("-----");
		s.price = 3000; // ????
		s.print();
	}
}
