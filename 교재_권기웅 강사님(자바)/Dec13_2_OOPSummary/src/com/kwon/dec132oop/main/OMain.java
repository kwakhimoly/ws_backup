package com.kwon.dec132oop.main;

import com.kwon.dec132oop.hero.Ironman;
import com.kwon.dec132oop.human.Human;
import com.kwon.dec132oop.planet.Planet;

public class OMain {
	public static void main(String[] args) {
		// 이름이 지구인 별
		Planet p = new Planet("지구");
		
		// 이름이 홍길동인 사람
		Human h = new Human("홍길동");
		
		// 사수의 영역--------------------------------
		// 영웅 : 공격하기 기능이 반드시 있어야하는
		//		  공격하기를 추.메로 하자
		//		  추.클 or 인터페이스
		//		  상속라인 막기는 싫으니 => 인터페이스
		// -------------------------------------------
		
		// 아이언맨(영웅) - singleton말고
		Ironman i = new Ironman();
		
		// 저 사람이 자기 전담영웅으로 아이언맨 찜
		h.pick(i);
		
		// 저 사람이 도와달라
		h.helpMe();
		
		// 저 별에 저 사람을 등록
		p.add(h);
		
		// 그 별 사이즈 500
		p.setSize(500);
		
		// 보이게
		p.setVisible(true);
	}
}
