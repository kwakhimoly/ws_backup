package com.kwon.dec134eh.main;

import com.kwon.dec133eh.calculator.Calculator;

// 정부에서 쓰려고 국무총리가 
// 회사에서 새로 시작하는 프로젝트
// 에도 나누기 기능이 필요
public class EHMain {
	public static void main(String[] args) {
		int q = 10;
		int w = 0;
//		int e = Calculator.getMoks(q, w);
//		System.out.println(e);
		
		try {
			int e = Calculator.getMoks2(q, w);
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("그 나누기가 말입니다..");
		}
		
		
		
	}
}
