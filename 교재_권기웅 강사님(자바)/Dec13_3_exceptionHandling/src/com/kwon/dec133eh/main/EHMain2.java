package com.kwon.dec133eh.main;

public class EHMain2 {
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		int[] c = { 12, 123 };
		
		// b가 5 : 12 - 13(하다가 펑) - 15 - 16
		// b가 0 : 12 - 13 - 14(하다가 펑) - 17 - 18
		// b가 1 : 12 - 13 - 14
//		try {
//			System.out.println(c[b]);  // Array...
//			System.out.println(a / b); // Arith...
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열이...");
//		} catch (ArithmeticException e) {
//			System.out.println("나누기0?");
//		}
		
		try {
			System.out.println(c[b]);
			System.out.println(a / b);
		} catch (Exception e) {
			e.printStackTrace(); // 개발자용
			System.out.println("어쨌든 이상하다");
		} finally {
			System.out.println("정상종료됐든지");
			System.out.println("사고 터졌든지");
			System.out.println("무조건 실행");
		}
	}
}
