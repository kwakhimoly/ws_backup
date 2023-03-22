package com.kwon.dec135uc.main;

import java.util.Scanner;

// Wrapper Class
// 		기본형에 해당하는 클래스
//		heap영역에 데이터 갖다놔야하면
//		String -> 기본형 : 클래스명.parseXXX(...)
public class UCMain_WrapperClass {
	public static void main(String[] args) {
		int a = 10;
		Integer aa = new Integer(10);

		double b = 123.12;
		// 기본형 -> 객체형 : 생성자
		Double bb = new Double(b);
		// 객체형 -> 기본형 : .xxxValue();
		double bbb = bb.doubleValue();

		boolean c = true;
		// 기본형 -> 객체형 : autoboxing(자동으로)
		Boolean cc = c;
		// 객체형 -> 기본형 : autounboxing(자동으로)
		boolean ccc = cc;

		System.out.println("-----");

		int d = 345;
		// 기본형 -> String
		// String dd = String.format("%d", d);
		String dd = d + "";

		// String -> 객체형 -> 기본형
		Integer ddd = Integer.parseInt(dd);
		int dddd = ddd.intValue();

		String e = "123.2342";
		double ee = Double.parseDouble(e);

		System.out.println("-----");

		Scanner k = new Scanner(System.in);
		System.out.print("숫자(a,b,c,...) : ");
		String f = k.next();

		String[] f2 = f.split(",");
		int sum = 0;
		int cnt = 0;
		for (String s : f2) {
			try {
				sum += Integer.parseInt(s);
			} catch (Exception e2) {
				cnt++;
			}
		}
		System.out.println(sum / (double) (f2.length - cnt));
	}
}
