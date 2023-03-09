package com.kwak.dec122oop.main;

import com.kwak.dec122oop.product.*;

public class OMain {

	public static void main(String[] args) {
		Product p = new Product("새우깡", 1500);
		p.print();
		
		System.out.println("-------------");
		
		p.price = 3000;
		p.print();
	}

}
