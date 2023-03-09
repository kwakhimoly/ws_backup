package com.kwak.dec135uc.main;

import java.util.StringTokenizer;

public class UCMain_String {

	public static void main(String[] args) {

//		String s2 = new String("hi");
		String s = "뭐라도 좀 쓰고";
//		사실 s2처럼 쓰는건데 하도 자주 쓰이니깐 
//		s처럼 기본형 변수 같이 쓸 수 있게 새 문법 만들어줌

//		s가 "뭐"라는 글자로 시작하는지 => boolean
		System.out.println(s.startsWith("뭐"));
		System.out.println(s.startsWith("아니"));

//		s의 두번째 글자 => String, char
		System.out.println(s.charAt(1));
//		charAt => 0부터 셈

//		s에서 좀 -> 쫌으로 바꿔서
		System.out.println(s.replace("좀", "쫌"));

//		s 총 몇 글자
		System.out.println(s.length());

		System.out.println("-----------");

//		그냥 %d를 써먹고 싶을 때
//		=> 문자열을 만들 때 형식 지정할 수 있도록 (콘솔 출력 아닌 상황에서도 쓰도록)
		String s2 = String.format("%.1f", 1.12312);
		System.out.println(s2);

		System.out.println("-----------");

		String s3 = "ㅋㅋㅋ";
		s3 += "ㅎㅎㅎ"; // s3 = new String(s3 + "ㅎㅎㅎ"); -> 메모리에 새 객체 생성 -> garbage collection 발동
		s3 = s3.concat("ㅇㅇ"); // 결합 -> 얘도 마찬가지로 새로운 객체 생성
		/*
		 * ↑↑ 웹개발 할거면 하덩가.. 근데 웹개발도 좀.... 
		 * 글자 붙일 때 + 쓰지말자 -> 객체 생성 자꾸 하면 컴퓨터 할 일이 늘어나요
		 * String : 수정 불가능한 문자열 객체
		 */
		System.out.println(s3);
		
		System.out.println("-------------");
//		문자열을 대량으로 붙여야 한다면
//		수정 가능한 String 문자열 만들기
		
		StringBuffer sb = new StringBuffer("ㅋㅋㅋ");
		sb.append("ㅎㅎㅎ");
		sb.append(52);
		String s4 = sb.toString();
		System.out.println(s4);
//		=> StringBuffer 활용하면 새 객체 생성 없이 수정(글자,숫자 등등 추가) 가능
//		=> 글자열에 추가 완료하면 .toString() 이용해서 일반 String으로 변환해서 사용
//					-> String으로 변환해야 다른 기능들을 사용할 수 있기 때문(ex. s.concat)
		
		System.out.println("-------------");
//		문자열 분리
		
		String s5 = "홍길동,김길동,최길동";
		
//		split : 지정한 단위(,)로 분리해서 배열로 줌 => 정형데이터에 유리
		String[] sAr = s5.split(",");
		System.out.println(sAr[1]);
		System.out.println();
		
//		StringTokenizer : 지정한 단위(,)에 따라 차례대로 => 비정형 데이터에 유리
		StringTokenizer st = new StringTokenizer(s5, ",");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
		
		String birthday = "19980315";
		System.out.println(birthday.substring(0, 4)); //0번째 문자부터 4번째 문자까지 출력
	}
}
