package com.kwon.dec125oop.main;

import com.kwon.dec125oop.avengers.Avengers;
import com.kwon.dec125oop.avengers.Ironman;

// singleton 쓸 상황이 맞기는 한데
// singleton, static - 빼고

// 소스 재사용 -> 클래스 만들때 파일 새로 만드시라
// Java는 객체만들면서 클래스까지 만드는 문법이 존재
public class OMain {
	public static void main(String[] args) {
		// 클래스명이 밝혀지지 않은 Avengers의 하위클래스
		// anonymous inner class
		Avengers a = new Avengers() {
			@Override
			public void attack() {
				System.out.println("방패 던지기");
			}
		};
		a.attack();
		
		System.out.println("-----");
		Ironman i = new Ironman("토니", 40, "자비스");
		i.print();
		i.attack();
		System.out.println("-----");
		// 배너, 30살, 바지사이즈가 40인 헐크
		// 정보출력
		// 공격하기 - 주먹질 콘솔출력
	}
}
