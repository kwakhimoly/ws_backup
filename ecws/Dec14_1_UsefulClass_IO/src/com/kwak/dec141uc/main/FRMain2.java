package com.kwak.dec141uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

//데이터 준 사람: student.csv는 utf-8로 인코딩해서 저장했다

public class FRMain2 {
	public static void main(String[] args) {

		BufferedReader br = null;
		String info = null;

		try {
			FileInputStream fis = new FileInputStream("C:/kwak/1214/student.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			int kor = 0;
			int eng = 0;
			int mat = 0;
//			=> 굳이 얘네 변수에 담을 필요 없었던 것 같다..! 어차피 평균 구할 때 한 번 쓰임
			double avg = 0;
			int birthYear = 0;
			int age = 0;
			String birth = null;
			String birth2 = null;
			String birth3 = null;
			int birthMonth = 0;
			int birthDate = 0;

			Date now = new Date();
			SimpleDateFormat year = new SimpleDateFormat("yyyy");
			String current = year.format(now);
			int curYear = Integer.parseInt(current);
			SimpleDateFormat month = new SimpleDateFormat("MM");
			String currentMonth = month.format(now);
			int curMonth = Integer.parseInt(currentMonth);
			SimpleDateFormat date = new SimpleDateFormat("dd");
			String currentDate = date.format(now);
			int curDate = Integer.parseInt(currentDate);

			while ((info = br.readLine()) != null) {
				String[] ar = info.split(",");
				System.out.printf("이름: %s\r\n", ar[0]);
				System.out.printf("생년월일: %s\r\n", ar[1]);
				birth = ar[1].substring(0, 4);
				birthYear = Integer.parseInt(birth);

				birth2 = ar[1].substring(4, 6);
				birthMonth = Integer.parseInt(birth2);

				birth3 = ar[1].substring(6, 8);
				birthDate = Integer.parseInt(birth3);

				if (curMonth - birthMonth >= 0 && curDate - birthDate >= 0) {
					age = curYear - birthYear;
				} else {
					age = curYear - birthYear - 1;
				}

				System.out.printf("나이: %s살\r\n", age);
				System.out.printf("국어: %s점\r\n", ar[2]);
				System.out.printf("영어: %s점\r\n", ar[3]);
				System.out.printf("수학: %s점\r\n", ar[4]);
				kor = Integer.parseInt(ar[2]);
				eng = Integer.parseInt(ar[3]);
				mat = Integer.parseInt(ar[4]);
				avg = ((double) kor + eng + mat) / 3;
				System.out.printf("평균: %.1f점\r\n", avg);
				System.out.println("=============");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
