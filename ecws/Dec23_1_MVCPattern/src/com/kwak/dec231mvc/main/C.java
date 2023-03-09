package com.kwak.dec231mvc.main;

//프로젝트
//	- 고객
//	- PM
//	- PL
//	- 개발자
//	- 디자이너

//💡 MVC
//	한 파일은 한 명이 책임지고 끝내자
//	한 파일은 M / V / C 중에 한 역할만 하자

//Model
//⇒ 개발자(작업) + 고객(커뮤니케이션)
//- 비즈니스 로직
//- 실제 계산

//View
//⇒ 디자이너
//- 사용자한테 보여지는 영역
//- 입력 , 결과 출력

//Controller
//⇒ PL급 개발자
//- 흐름 제어
//- 상황 판단
//    → M이 필요하면 M 소환
//    → V이 필요하면 V 소환

public class C {

	public static void main(String[] args) {
		int x = V.getX();
		String r = M.judge(x);
		V.print(r);
	}


}
