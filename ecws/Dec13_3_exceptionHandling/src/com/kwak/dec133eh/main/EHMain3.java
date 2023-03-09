package com.kwak.dec133eh.main;

import com.kwak.dec133eh.calculator.Calculator;

public class EHMain3 {

//	이 프로젝트: 동생이 의뢰
//	자바개발자가 보기에 나누기 기능을 다른 프로젝트에서 쓸 것 같다
//	=> .jar로 챙겨놓읍시다
	
	
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		int c = Calculator.getDivision(a, b);
		System.out.println(c);
		
		try {
			int d = Calculator.getDivision2(a, b);
			System.out.println(d);			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("나누기 0?");
		}
		

		System.out.println("----------");


		try {
			System.out.println(a / b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			main 보다는 return 사용하는 메소드에서 주로 사용
		}
		System.out.println("사고여부 상관없이 무조건 실행"); // try-catch 밖에 놔두면 알아서 실행됨 finally 안 써도

	}

}
