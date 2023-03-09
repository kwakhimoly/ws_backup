package com.kwak.jan02.myhome;

public class CommonUtil {
	private CommonUtil() {
	}
	static public String nullToVal(Object ob1, String value) {
		if (ob1 == null) {
			return value;
		} else {
			return ob1.toString();
		}
	}
}
