package com.kwak.dec231mvc.main;

import java.util.Scanner;

public class V {
//	객체가 따로 필요 없으니까 -> static
	public static int getX() {
		Scanner k = new Scanner(System.in);
		System.out.print("x: ");
		int x = k.nextInt();
		k.close();
		return x;
	}
	
	public static void print(String r) {
		System.out.println(r);
	}

}
