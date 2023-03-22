package com.kwon.dec222a.main;

import com.kwon.dec222a.human.Human;

// PP -> OOP -> 
// AOP(Aspect Oriented Programming)
//		관점 지향 프로그래밍
//		OOP를 다른 관점에서 봐가지고
//		공통된 기능 파악해서 정리
public class AMain {
	public static void main(String[] args) {
		Human h = new Human("홍길동", 30);
		h.print();
		System.out.println("----");
		h.goSchool();
		System.out.println("----");
		h.goMart();
	}
}





