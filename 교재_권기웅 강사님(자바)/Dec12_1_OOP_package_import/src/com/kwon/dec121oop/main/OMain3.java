package com.kwon.dec121oop.main;

// 객체 만드는 문법
//	패키지명.클래스명 변수명 = new 패키지명.생성자(...);

// 패키지명 생략가능
//		같은 패키지
//		자바의 기본 패키지(java.lang) 소속
//		import하면

// import
//		OMain3.java를 작업하는 중인데
//		여기서 Scanner라고 쓰면 그건 무조건 java.util소속
//		내가 만든 Scanner는 절대 안쓸거다
import java.util.Scanner;
import java.util.Random;

// ctrl + shift + o
public class OMain3 {

	public static void main(String[] args) {
		// java.util.Random
		Random r = new Random();
		
		Scanner k = new Scanner(System.in);
		
		java.lang.String s = "ASd";
		
		Cup cc = new Cup();
		
		com.kwon.dec121oop.animal.Cat c 
			= new com.kwon.dec121oop.animal.Cat("나비", 1);
		c.print();
		
		
		
	}
}



