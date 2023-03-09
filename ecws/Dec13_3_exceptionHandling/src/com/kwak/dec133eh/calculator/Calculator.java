package com.kwak.dec133eh.calculator;

public class Calculator {
	public static int getDivision(int a, int b) {
//		정상: 8 -> 10 -> 16 -> 19 -> 11
//		사고: 8 -> 10(하다가 펑) -> 12 -> 14 -> 16 -> 19 -> 15

		try {
//			여기 하다가
			int z = a / b;
			return z;
		} catch (Exception e) {
//			예외가 터지면 여기 잡혀서 처리
			e.printStackTrace();
			System.out.println("나누기 0은 안됩니다");
			return 0;
		} finally {
//			정상종료됐든 예외 터졌든 무조건?? -> 그냥 try-catch 밖에 따로 쓰면 됨
//			리턴 직전에 실행!
			System.out.println("bye");
		} 
	}
//	 ↑↑ 1. 직접 해결 방법


//		2. 미루기
//	getDivision2 하다가 ArithmeticException 발생한 건
//	=> getDivision2 을 호출한 쪽(main)에서 해결하라고 미루기
	public static int getDivision2(int x, int y) throws ArithmeticException{
		int z = x / y;
		return z;
	}
}
