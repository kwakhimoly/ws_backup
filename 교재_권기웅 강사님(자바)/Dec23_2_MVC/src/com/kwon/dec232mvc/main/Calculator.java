package com.kwon.dec232mvc.main;

import java.util.ArrayList;

// 메소드 결과가 여러개 나와야
//		[], List, Set, Map
//		객체
public class Calculator {
	public static CalcResult calculate(int x, int y) {
		int a = x + y;
		int b = x - y;
		int c = x * y;
		int d = x / y;
		return new CalcResult(a, b, c, d);
	}
}
