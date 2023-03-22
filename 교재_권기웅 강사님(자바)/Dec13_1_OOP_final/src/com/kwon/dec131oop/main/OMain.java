package com.kwon.dec131oop.main;

import com.kwon.dec131oop.menu.Sool;
import com.kwon.dec131oop.random.KwonRandom;

public class OMain {
	public static void main(String[] args) {
		
		System.out.println("-----");
		KwonRandom kr = new KwonRandom();
		int x = kr.nextInt(10);
		System.out.println(x);
		
		System.out.println("-----");
		Sool s = new Sool("이과두주", 5000, 40);
		s.print();
	}
}
