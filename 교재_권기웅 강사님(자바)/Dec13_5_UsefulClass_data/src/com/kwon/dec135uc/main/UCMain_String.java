package com.kwon.dec135uc.main;

import java.util.StringTokenizer;

// String : 수정 불가능한 문자열 객체
public class UCMain_String {
	public static void main(String[] args) {
		// String s = new String("ㅋㅋㅋ");

		// 하도 써대니
		// 기본형처럼 쓸 수 있게 만들어놓은 새 문법
		String s = "뭐라도 좀 쓰고";

		System.out.println(s.startsWith("뭐"));
		System.out.println(s.charAt(1));
		System.out.println(s.replace("좀", "쫌"));
		System.out.println(s.length());

		// 문자열 만들때 형식지정
		String s2 = String.format("%.1f", 1.12312);
		System.out.println(s2);
		
		// 문자열 붙이는데 비추
		String s3 = "ㅋㅋㅋ";
		s3 += "ㅎㅎㅎ";
		s3 = s3.concat("ㅇㅇ");
		System.out.println(s3);
		
		// 문자열을 대량으로 붙여야하면
		StringBuffer sb = new StringBuffer("ㅋㅋㅋ");
		sb.append("ㅎㅎㅎ");
		sb.append("ㅇㅇ");
		String s4 = sb.toString();
		System.out.println(s4);
		
		// 문자열 분리
		String s5 = "홍길동,김길동,최길동";
		// 분리해서 배열로 줌 => 정형데이터에 유리할...
		String[] sAr = s5.split(",");
		System.out.println(sAr[1]);
		// 비정형데이터에 유리할...
		StringTokenizer st = new StringTokenizer(s5, ",");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
		
	}
}



