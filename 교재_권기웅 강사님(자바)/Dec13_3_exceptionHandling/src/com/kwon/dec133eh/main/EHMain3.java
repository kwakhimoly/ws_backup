package com.kwon.dec133eh.main;

import com.kwon.dec133eh.calculator.Calculator;

public class EHMain3 {
	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		int c = Calculator.getMoks(a, b);
		System.out.println(c);

		try {
			int d = Calculator.getMoks2(a, b);
			System.out.println(d);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("얔ㅋㅋㅋㅋ");
		}
		
		// Java는 예외처리 안하면 에러
		// 초보자 : 언제 처리해야하나 몰라도 되니 굿
		// 상급자 : 별로 처리 안하고 싶은데 해야하니 끙
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}



