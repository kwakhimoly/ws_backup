package com.myhome.jan03.servlet;

public class CommonUtil {
	private CommonUtil() {
	}
	static public String nullToVal(Object ob1, String value) {
		if (ob1 == null || ob1 == "") {
			return value;
		} else {
			return ob1.toString();
		}
	}
}
