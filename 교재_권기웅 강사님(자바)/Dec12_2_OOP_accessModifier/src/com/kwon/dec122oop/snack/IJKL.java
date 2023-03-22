package com.kwon.dec122oop.snack;

import com.kwon.dec122oop.test.Test;

// Test, IJKL의 관계 : 다른 패키지, 상속라인
public class IJKL extends Test {
	public void gogo() {
		Test t = new Test();
		t.a = 10;
		t.b = 20;
		t.c = 30;
		t.d = 40;
	}
}
