package com.kwak.dec124oop.main;

import java.util.Calendar;

import com.kwak.dec124oop.human.Kwak;

public class OMain {

	public static void main(String[] args) {
		// pattern programming
		// singleton : only one
		
		Calendar c = Calendar.getInstance();
//		new 안 붙이고 이런 형태로도 사용

		Kwak k = Kwak.getKwak(); 
		System.out.println(k);
		
		Kwak k2 = Kwak.getKwak();
		System.out.println(k2);
		
//		-> k = k2가 되도록
	}

}
