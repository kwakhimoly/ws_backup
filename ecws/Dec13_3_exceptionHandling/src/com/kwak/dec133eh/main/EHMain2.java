package com.kwak.dec133eh.main;

public class EHMain2 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		int[] c = { 12, 123 };

//		b가 5 : 12 - 13 (하다가 펑) - 15 -16
//		b가 0 : 12 - 13 - 14 (하다가 펑) - 17 - 18
//		b가 1: 12 - 13 - 14 
//		try {
//			System.out.println(c[b]); // Array...
//			System.out.println(a / b);	// Arith...		
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열 오류");
//		} catch (ArithmeticException e) {
//			System.out.println("나눗셈 오류");
//		} => 케이스 별로 exception 잡기

//		java : exception 안 만들면 에러
		
//		개발자가 만드는 중에 상황파악은 해야지
		try {
			System.out.println(c[b]);
			System.out.println(a / b);			
		} catch (Exception e) {
			e.printStackTrace(); // -> 오류난 부분 찝어주기 => 만드는 동안은 살려놨다가 출시 직전 빼기 
			System.out.println("어쨌든 이상하다 -> exception e로 퉁치기");
		}	finally {
			System.out.println("정상종료");
			System.out.println("사고 터졌대도");
			System.out.println("무조건 실행");
		}
//		if - else
//		try - catch -finally
	}
}
