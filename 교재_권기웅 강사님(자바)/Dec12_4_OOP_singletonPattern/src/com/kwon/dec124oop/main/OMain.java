package com.kwon.dec124oop.main;

import java.util.Calendar;

import com.kwon.dec124oop.human.Kwon;

// pattern programming
//		singleton : only one
public class OMain {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		Kwon k = Kwon.getKwon();
		System.out.println(k);
		
		Kwon k2 = Kwon.getKwon();
		System.out.println(k2);
	}
}



