package com.kwak.dec222a.main;

import com.kwak.dec222a.human.Human;

public class AMain {
	public static void main(String[] args) {
		Human hong = new Human("홍길동", 30);
		hong.print();
		System.out.println("---------");
		hong.goSchool();
		System.out.println("---------");
		hong.goMart();
	}
}
