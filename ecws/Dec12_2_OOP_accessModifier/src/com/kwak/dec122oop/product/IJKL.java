package com.kwak.dec122oop.product;

import com.kwak.dec122oop.test.Test;


//	Test, IJKL의 관계: 다른 패키지, 상속관계 O

public class IJKL extends Test {
	public void gogo() {
		Test t = new Test();
		
		t.a = 10;
//		t.b = 20; => 다른 패키지지만 상속관계인데 왜 안 되나? => 자바 버그 때문에!
//		t.c = 30;
//		t.d = 40;
	}
}
