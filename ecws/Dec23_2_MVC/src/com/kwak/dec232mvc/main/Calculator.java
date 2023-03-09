package com.kwak.dec232mvc.main;


public class Calculator {
	public static CalcResult calculate(int x, int y) {
//		ArrayList<Integer> ar = new ArrayList<>();
		
//	 	결과 여러개 return 할 때
//		⇒ [], ArrayList, Set, Map 사용
//		⇒ 여러 형태의 결과 나올 경우 : 객체 하나 더 생성
		
		int plus = x+y;
		int minus = x-y;
		int multiple = x*y;
		int division = x/y;
		
		return new CalcResult(plus, minus, multiple, division);
				
	}

}
