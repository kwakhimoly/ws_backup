package com.kwak.dec121oop.main;

import java.util.Random;
import java.util.Scanner; // => 여기서 쓰는 Scanner는 무조건 java.util 소속

public class OMain2 {
	public static void main(String[] args) {
		com.kwak.dec121oop.animal.Cat c 
			= new com.kwak.dec121oop.animal.Cat("구름이", 10);

//		c.age = 2;
		c.printInfo();
		
		
		Cup_forexample cup = new Cup_forexample();
//		=> 같은 package 소속이기 때문에 위의 Cat처럼 구구절절 안 써도 됨
		
		java.lang.String s = "안녕";
		
		Scanner k = new Scanner(System.in);
		
		Random r = new Random();
	}
}
