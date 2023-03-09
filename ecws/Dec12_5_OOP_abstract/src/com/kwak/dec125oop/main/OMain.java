package com.kwak.dec125oop.main;

import com.kwak.dec125oop.avengers.Avengers;
import com.kwak.dec125oop.avengers.Hulk;
import com.kwak.dec125oop.avengers.Ironman;
import com.kwak.dec125oop.avengers.Thor;




//	객체 지향 사용 주 이유 -> 소스 재사용 => 클래스 만들 때 파일 새로 만들어라!
public class OMain {

	public static void main(String[] args) {
		Avengers a = new Avengers() {
//			클래스명이 밝혀지지 않은 Avengers의 하위 클래스
//			= annonymous inner class
			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("방패 던지기");
			}
		}; // {} 부분이 클래스 => 자바엔 객체 만들면서 클래스까지 만드는 문법이 존재 => annonymous inner class
		a.attack();
		
		System.out.println("----------------");
		
//		토니, 40살, 자비스(인공지능 이름)인 아이언맨 => 싱글턴!!
//		정보출력
//		공격하기 - 빔 발사
		Ironman iron = new Ironman("토니", 40, "자비스");
		iron.printInfo();
		iron.attack();
		
		System.out.println("-------------");
//		배너, 30살, 40(바지 사이즈)인 헐크 => 싱글턴 !!
//		정보출력
//		공격하기 - 주먹질
		Hulk hulk = new Hulk("배너", 30, 40);
		hulk.printInfo();
		hulk.attack();
		
		System.out.println("-------------");
//		싱글턴 사용해서 토르 해보기
		Thor thor = Thor.getThor();
		thor.printInfo();
		thor.attack();
	}

}
