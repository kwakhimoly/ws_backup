package com.kwak.dec135uc.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//	java.util.Date : 일반
//	java.sql.Date : DB 어쩌고 할 때 -> 에도 잘 안 씀
//		SQL: Database를 제어하는 언어		
//	Java - 		JSP 	- 	Spring
//	JDBC - ConnectionPoll - MyBatis(util을)
//		util/sql

public class UCMain_Date {
	public static void main(String[] args) {
//		현재 시간 날짜
		Date now = new Date(); // 얘도 객체!!!!
		System.out.println(now);
	
		
//		deprecated: 현재 버전(1.8.x)에서는 ok 
//					다음 버전에 없어질 예정
//			세월이 가고, 기술이 발전하면서.. => 만들어 놨던 기술이 실정에 안 맞는 순간이 옴
//			-> 그 기술을 업그레이드 or 버리고 새거 만들거나
//				=> 그 기술에 deprecated 붙임
//		Date: 옛날에 만들어진 객체 -> 2000년대 생각 안하던 시절
//				=> 버리고 새거 만들기 전법!
		
//		년
//		System.out.println(now.getYear());
//		객체지향 사용 표준
//		월
//		System.out.println(now.getMonth());
		
//		일
//		System.out.println(now.getDate());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMM-dd");
		String today = sdf.format(now); // 지정한 포맷(yyyy-MM-dd)으로 String 변환
		System.out.println(today);
		
		System.out.println("--------------");
		
//		특정 시간 날짜 (String -> Date)
		try {
			String birthday = "2012/04/15";
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
			Date bday = sdf2.parse(birthday);
			System.out.println(bday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			String newYear = "2022/12/32";
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd");
			Date newY = sdf3.parse(newYear);
			System.out.println(newY);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("------------");
//		본인 무슨 요일에 태어났나
//		본인 한국 나이
		
//		String myBirth = "1998-03-15";
//		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			Date myBday = sdf4.parse(myBirth);
//			System.out.println(myBday);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		try {
			String myBirth = "19980315";
			SimpleDateFormat sdf4 = new SimpleDateFormat("yyyyMMdd");
			
			Date myBday = sdf4.parse(myBirth);
			sdf4 = new SimpleDateFormat("E", Locale.FRENCH);
			String yoil = sdf4.format(myBday); // 요일 지정해서 변수에 담기
			System.out.println(yoil); 
			
			Date current = new Date();
			sdf4 = new SimpleDateFormat("yyyy");
			String curYear = sdf4.format(current);
			int curYear2 = Integer.parseInt(curYear);
			String birthYear = sdf4.format(myBday);
			int birthYear2 = Integer.parseInt(birthYear);
//			String birthYear = myBirth.substring(0, 4);
			int age = curYear2 - birthYear2 + 1;
			System.out.println(age);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
