package com.kwon.dec133eh.main;

import java.util.Scanner;

// 한국어 -개발-> java -컴파일-> 기계어 -압축-> 실행

// error : java문법에 안맞게 써서, 기계어로 번역불가
//		최종 산출물이 안나옴
//		개발자 잘못

// warning : 지저분한 소스
//		실행 잘 됨
//		개발자 잘못

// exception : 프로그램은 완성, 문제없이 실행 됨
//		사용자가 실행할 때 외부적인 요인에 의해 제대로 안되는
//		개발자 잘못 - x
//		그 상황에 대한 대처는 개발자가...

// exception handling
//		1.
//		2. 
public class EHMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("x : ");
		int x = k.nextInt();
		System.out.print("y : ");
		int y = k.nextInt();
		System.out.println("-----");

		// 정상 : 34 - 35 - 36
		// 사고 : 34 - 35(하다가 펑) - 37 - 38
		try {
			System.out.println(x / y);
			System.out.println("계산 끝");
		} catch (ArithmeticException e) {
			System.out.println("야 나누기 0이 어딨냐");
		}
		
		
	}
}


