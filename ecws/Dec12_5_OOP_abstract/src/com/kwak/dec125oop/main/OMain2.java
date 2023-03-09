package com.kwak.dec125oop.main;

import com.kwak.dec125oop.avengers.Avengers;
import com.kwak.dec125oop.avengers.Ironman;

public class OMain2 {
	public static void main(String[] args) {
		
		Avengers a = new Ironman();
		a.attack();
		
		
	}
//변수 : 
//	데이터 담는 그릇
//IronMan ii = new SpiderMan();
//	ii는 아이언맨 담는 그릇인데 스파이더맨 담기 x
//Avengers a = new IronMan(); => 가능
//	a는 어벤져스 담는 그릇인데 아이언맨 담기(어벤져스만 입장할 수 있는 건물 a에 아이언맨 들어옴)
//SpiderMan ss = new Avengers();
//	ss는 스파이더맨 담는 그릇인데 어벤져스 담기 x
}
