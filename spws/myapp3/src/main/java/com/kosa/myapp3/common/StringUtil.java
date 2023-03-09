package com.kosa.myapp3.common;

public class StringUtil {
//	생성자 private으로 만들어서 객체 생성 못하게
	private StringUtil() { }
	
	public static String nullToValue(Object obj, String value) {
		if(obj==null) {
//		전달된 객체가 null일 경우 두번째 인자가 전달한 값을 반환
			return value;
		} else {
//		null이 아닐 경우에 obj의 toString()을 이용해 String 값을 전달	
			return obj.toString();
		}
//		String 객체에만 사용 가능하다.
//		객체 안 만들고 함수 사용이 가능하게 하기 위해서 static 키워드를 붙임. 
	}
}
//		DB에 ' -> '' 바꿔서 넣어야 함.
//			% -> 	바꿔서 넣어야 함.
//			> -> &gt;(이런걸로) 바꿔서 넣어야 함.