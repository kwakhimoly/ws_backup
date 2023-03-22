package com.kwon.dec135uc.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// 본인 무슨요일에 태어났나
// 나이(한국나이) : 올해는 2022년이 아님
public class UCMain_Date2 {
	public static void main(String[] args) {
		try {
			String birthday = "19870527";
			
			SimpleDateFormat sdf 
				= new SimpleDateFormat("yyyyMMdd");
		
			Date birthday2 = sdf.parse(birthday);
			System.out.println(birthday2);
			
			sdf = new SimpleDateFormat("E", Locale.ENGLISH);
			String yoil = sdf.format(birthday2);
			System.out.println(yoil);

			Date now = new Date();
			sdf = new SimpleDateFormat("yyyy");
			String curYear = sdf.format(now);
			int curYear2 = Integer.parseInt(curYear);
			String birthYear = sdf.format(birthday2);
			int birthYear2 = Integer.parseInt(birthYear);
			int age = curYear2 - birthYear2 + 1;
			System.out.println(age);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
