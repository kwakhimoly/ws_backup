package com.kwon.dec135uc.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// deprecated : 현재버전(1.8.x)에서는 ok
//				다음버전에 없어져도 가만히 있어라
//	세월이 가고, 기술이 발전하고...
//	=> 만들어놨던 기술이 실정에 안맞는 순간이 옴
//	=> 그 기술을 업그레이드 or 버리고 새거 만들든지
//	=> 그 기술에 deprecated를 붙임

//	Date : 옛날에 만들어진, 2000년대 생각 안하던 시절


public class UCMain_Date {
	public static void main(String[] args) {
		// 현재시간날짜
		Date now = new Date();
		System.out.println(now);
		
		// Date -> String
		SimpleDateFormat sdf 
			= new SimpleDateFormat("yyyy-MM");
		String now2 = sdf.format(now);
		System.out.println(now2);

		// 특정시간날짜
		// String -> Date
		try {
			String newYear = "2023/01/01";
			SimpleDateFormat sdf2
				= new SimpleDateFormat("yyyy/MM/dd");
			Date newYear2 = sdf2.parse(newYear);
			System.out.println(newYear2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// 본인 무슨요일에 태어났나
		// 나이(한국나이) : 올해는 2022년이 아님
		String birthday = "19870527";
		
		
		// 연도
		// System.out.println(now.getYear());
		// 월
		// System.out.println(now.getMonth());
		// 일
		// System.out.println(now.getDate());
	}
}
