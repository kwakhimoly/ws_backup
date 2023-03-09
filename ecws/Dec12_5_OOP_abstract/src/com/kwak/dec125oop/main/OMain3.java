package com.kwak.dec125oop.main;

import com.kwak.dec125oop.avengers.Ironman;

public class OMain3 {
	public static void main(String[] args) {
//		사람
//			밥 먹기 - 냠 출력
		
//		다중상속: Java는 안 됨
//		-> 인터페이스 활용
//		Ironman is a Avengers
//		Ironman is a Human
//		Ironman is a Flyer
		
		Ironman i = new Ironman("토니", 40, "자비스");
		i.attack();
		i.eat();
		i.fly();
	}
}
