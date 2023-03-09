package com.dec134eh.main;

import com.kwak.dec133eh.calculator.Calculator;

public class EHMain {

	public static void main(String[] args) {
		
//		Thread.sleep(10); (Exception 처리 하라고 에러 뜸)
//		자바는 예외처리 안하면 에러
//		=> 초보자: 언제 해야되는지 몰라도 되니 굿
//		=> 상급자: 별로 처리 안하고 싶은데 해야하니 별로
		
		
		System.out.println("-------------");
		
		int q = 10;
		int w = 0;
		
//		int s = Calculator.getDivision(q, w);
//		System.out.println(s);
//		메소드 안에서 직접 exception 대응하면 안의 try-catch 내용을 바꿀 수 없음
		
		try {
			int e = Calculator.getDivision2(q, w);
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("나누기 0 오류");
		}
//		throws 방법 쓰면 프로젝트마다 다른 오류 대응 방법 쓸 수 있음
//		=> 더 자주 쓰임!
		
	}

}
