package com.kwon.dec133eh.calculator;

// 1. 프로젝트마다 대응방법이 다를텐데
// 2. 신입개발자가 대응방법까지 하나
//		대응은 main쪽을 작업할 사수가 해야

// 예외처리
//		1. 직접 해결
	//		try {
	//			// 여기 하다가
	//		} catch (Exception e) {
	//			// 예외가 터지면 잡힘
	//		} finally {
	//			// 정상종료됐든 예외 터졌든 무조건 
	//			// 리턴 직전에
	//			// 중간에 리턴 있을때 활용하면...
	//		}
//		2. 미루기
//			throws
public class Calculator {
	// 정상 : 16 - 17 - 22 - 23 - 18 
	// 사고 : 16 - 17(하다가 펑) - 19 - 20 - 22 - 23 - 21
	public static int getMoks(int x, int y) {
		try {
			int z = x / y;
			return z;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("야 나누기 0이 어딨냨ㅋㅋㅋ");
			return -999;
		} finally {
			System.out.println("ㅋ");
		}
	}
	
	// getMoks2 하다가 Arith...발생한거는
	// getMoks2를 호출한 쪽에서 해결해
	public static int getMoks2(int x, int y) throws ArithmeticException {
		int z = x / y;
		return z;
	}
	
	
}




