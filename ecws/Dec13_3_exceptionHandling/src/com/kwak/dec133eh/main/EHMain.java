package com.kwak.dec133eh.main;

import java.util.Scanner;

public class EHMain {

	public static void main(String[] args) {
//		내 동생: 초딩 => 정수 2개 입력하면 사칙연산결과 출력하는 프로그램
		Scanner k = new Scanner(System.in);
		System.out.print("x: ");
		int a = k.nextInt();
		System.out.print("y: ");
		int b = k.nextInt();
		System.out.println("-----------");
		
//		정상 => try -> 19 -> 20 -> 27
//		사고 => catch -> 19 -> 실패 -> 22
		try {
			System.out.println(a/b);
			System.out.println("계산 끝");
		} catch (ArithmeticException e) {
			System.out.println("나누기 0은 안됩니다");
		}
		

//		나누기 0은 없는데 그거 모르는 사람 많음
		System.out.printf("나눗셈: %d\n", a / b); // 위험
	}
}
