package com.kwak.dec12tij.main;

import com.kwak.dec126.avengers.Hulk;

//프로젝트: 어벤져스 게임 만들기 
//			아이언맨 작업을 신입한테 지시

//		아이언맨
//			공격하기 - 빔 발사
//			=> 사수: 10 넣으면 10번 쏴야지 메소드명도 attack이 뭐냐! -> 개똥회사
//			=> 사수: 아예 제대로된 오더를 내리기 -> 딴 짓 못하게 => 추상 메소드를 줘버림
//					추상 메소드를 줘서 반드시 작업 하도록 만듦 -> 제대로된 회사
public class TIJMain {

	public static void main(String[] args) {
		Hulk h = new Hulk();
		h.throwPunch();
		
		Ironman i = new Ironman();
		i.attack();
	}

}
