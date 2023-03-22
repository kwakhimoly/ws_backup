package com.kwon.dec125oop.main;

import com.kwon.dec125oop.avengers.Avengers;
import com.kwon.dec125oop.avengers.Ironman;

// 다형성(polymorphism)
//		상위타입 변수에 하위타입 객체 대입 가능
//		=> 최종적으로는 하위타입 객체
public class OMain2 {
	public static void main(String[] args) {
		Avengers a = new Ironman();
		a.attack();
	}
}