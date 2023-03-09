package com.kwak.dec141uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FRMain_ans {
	public static void main(String[] args) {
		BufferedReader br = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String cy = sdf.format(new Date());
		int cy2 = Integer.parseInt(cy);
//		=> 데이터가 많을 수록 반복문 실행하는 데 오래 걸려서 그 사이에 현재 년도가 바뀔 수도 있음
//				-> 그러니까 반복문 안에 넣는 게 나을 때도 있다 -> 근데 또 프로그램 실행 동안 연도가 바껴서 나이가 한살 적게 찍힌 사람은 어떡하지?
		try {
			FileInputStream fis = new FileInputStream("C:/kwak/1214/student.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] line2 = line.split(",");
				System.out.println(line2[0]);
				System.out.println(line2[1]);

				String by = line2[1].substring(0, 4); // 연도 4자리만 빼오기
				int by2 = Integer.parseInt(by);
				System.out.println(cy2 - by2 + 1);

				System.out.println(line2[2]);
				System.out.println(line2[3]);
				System.out.println(line2[4]);

				int sum = Integer.parseInt(line2[2]) + Integer.parseInt(line2[3]) + Integer.parseInt(line2[4]);

				System.out.println(sum / 3.0);

				System.out.println("--------");
			}

		} catch (Exception e) {
		}
	}
}
