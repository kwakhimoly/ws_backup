package com.kwak.dec135uc.main;

import java.util.Scanner;

//	data: 변수/개체

//	작업하다보면 stack에 있는 변수가 heap에 있도록 해야할 때가 있음
//	String => 기본형: 클래스명.parseXXX(...);
//	Wrapper Class
//	기본형에 해당하는 클래스
public class UCMain_WrapperClass {

	public static void main(String[] args) {
//	기본형 데이터를 heap 영역에 데려다 놔야할 때 객체형으로 만들어서 사용
		int a = 10;
		Integer aa = new Integer(10);

//		기본형 <-> 객체형
		double b = 1.213;
//		기본형을 객체형으로 바꾸고 싶으면 : 생성자 사용? => 자동으로 해줌(autoboxing)
//		Double bb = new Double(b);
		Double bb = b; // 이건 기본형을 객체형으로 바꾼 거! 기본형이랑 다름!
//		객체형을 기본형으로 바꾸고 싶으면 : .xxxValue(); => 이것도 자동으로 해줌(autounboxing)
//		double bbb = bb.doubleValue();
		double bbb = bb;

		System.out.println("------------");

//		숫자를 글자로 변환

		int d = 345;
		String dd = d + "";
//		String dd = String.format("%d", d); => 형변환 가능 근데 조금 과함

//		String을 기본형으로 변환 -> 스읍..
//		String -> 객체형 그 다음에 -> 기본형
		Integer ddd = Integer.parseInt(dd);
		int dddd = ddd.intValue();

		String e = "123.2342";
		double ee = Double.parseDouble(e); // 객체형<-> 기본형은 자동으로 가능하니 기본형 = 객체형; 으로 써도 됨

		Scanner k = new Scanner(System.in);
		System.out.print("숫자 입력(x,y,z...): ");

//		String xyz = k.next();
//		String[] xyzArray = xyz.split(",");
//		int x = Integer.parseInt(xyzArray[0]);
//		int y = Integer.parseInt(xyzArray[1]);
//		int z = Integer.parseInt(xyzArray[2]);
//		System.out.printf("평균: %.1f\n",((double)x+y+z)/3);
//		3개만 입력 받는 경우.. 강사님이 말한건 원하는만큼 입력+평균 구하기

		String f = k.next();

//		문제가 합계였으면 Tokenizer 사용 => 그냥 다 더하면 되니까! 근데 총 갯수 챙기기가 힘듦
//		평균이라 split 사용
//		사용자가 이상한거 입력하면 -> Exception Handling

		String[] fArray = f.split(",");
		int sum = 0;
		int numLength = 0;
		for (String s : fArray) {
			try {
				sum += Integer.parseInt(s);
			} catch (Exception e2) {
				numLength++;
			}
		}
		System.out.printf("평균: %.1f\n", (double) sum / (fArray.length - numLength));

//		내가 했다 실패한거 ↓↓
//		int x;
//		int xyz;
//		for (int i = 0; i < fArray.length; i++) {
//			 x = Integer.parseInt(fArray[i]);
//		} 

	}

}
