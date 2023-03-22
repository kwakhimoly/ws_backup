package com.kwon.dec231mvc.main;

// 프로젝트
//		고객
//		PM
//		PL
//		개발자
//		디자이너

// MVC패턴
//		한 파일은 한명이 책임지고 끝내자
//		한 파일은 M/V/C 중에 한 역할만 하자

// back-end
// Controller - PL급 개발자
//		흐름제어
//		상황 판단해서 
//		M이 필요하면 M소환, V가 필요하면 V소환
public class C {
	public static void main(String[] args) {
		int x = V.getXY();
		String r = M.judge(x);
		V.print(r);
	}
}