package com.kwak.dec132oop.main;

import com.kwak.dec132oop.human.Human;
import com.kwak.dec132oop.human.Thor;
import com.kwak.dec132oop.stars.Planet;

public class OMain {

	public static void main(String[] args) {
		Planet earth = new Planet("지구");
//		이름이 지구인 별
		earth.setSize(500);
//		그 별 사이즈 500
		earth.setVisible(true);
//		그 별 보이게
	
		Human hong = new Human("홍길동");
		
		earth.add(hong);
		
//		토르(영웅)
		Thor thor = new Thor();
		
//		홍길동이 자기 전담 영웅으로 토르 찜
		hong.pick(thor);
		
//		홍길동이 도와달라 부탁
		hong.helpMe();
	}
}
