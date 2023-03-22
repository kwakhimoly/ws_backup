package com.kwon.dec126tij.main;

import com.kwon.dec126tij.avengers.Hulk;

// 회사측 결정사항 
// 프로젝트 시작 : 어벤져스 게임을 만들어야 함
// 사수 : 공격하기 기능이 있는 아이언맨 가져와
// 나 : 제출(.jar + 문서)
// 사수 : 야 뭐냐, 10넣으면 10번 쏴야지
//			메소드명이 attack이 뭐냐

// 회사측 결정사항 
// 프로젝트 시작 : 어벤져스 게임을 만들어야 함
// 사수 : 공격하기 기능이 있는 헐크 가져와
//		  + 반드시 작업하게 추상메소드(상속라인 안막는 인터페이스)
// 나 : 추상메소드가 왔으니 그대로 작업해야
// 사수 : 부하직원은 그거 작업했을테니...

public class TIJMain {
	public static void main(String[] args) {
		Hulk h = new Hulk();
		h.throwPunch();
		
		Ironman i = new Ironman();
		// i.shootBeam(10); // ?
	}
}
