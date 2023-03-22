package com.kwon.dec141uc.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 1. windows는 경로 대소문자 구별안함
//	  linux는 대소문자 구별함

// 2. 확장자
//	(MS진영에서만 사용하는 허상
//	사용자 입장에서 보기 편함)
//		.txt 
//			수많은 프로그램이 있는데
//			그 중에 메모장에서 열면 최적인 파일
//			이라는거를 사용자가 짐작하기 좋은
//			메모장 전용 파일x
// 		.csv
//			comma separated value
//			값,값,값
//			으로 생겼겠구나를 사용자가 짐작하기 좋은
//			엑셀에서 열면 이쁘게 보임
//			메모장에서 열면 ,로 보임


//이름 : 
//생년월일(YYYYMMDD) : 
//국어 : 
//영어 : 
//수학 :
//
//student.csv에 저장

// 전기의 흐름
// 		encoding : 데이터 -> 전기의 흐름
//		decoding : 전기의 흐름 -> 데이터

// 전 세계적으로 utf-8방식이 주력
// euc-kr쓰는곳이 없지 않음

// ㅋ -인코딩-> 1010 -디코딩-> ㅋ
// ㅋ ----A---> 0111 ---A----> ㅋ       
// ㅋ ----B---> 1001 ---B----> ㅋ
// ㅋ ----A---> 0111 ---B----> 깨짐
public class FWMain2 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.print("이름 : ");		String n = key.next();
		System.out.print("생일 : ");		String b = key.next();
		System.out.print("국어 : ");		int k = key.nextInt();
		System.out.print("영어 : ");		int e = key.nextInt();
		System.out.print("수학 : ");		int m = key.nextInt();
		
		// OutputStreamWriter개조형 : 2bytes(글자라는걸 인식하는 상태)
		// FileWriter fw;
		
		// OutputStream개조형 : 1byte(글자가 뭐지?)
		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Kwon\\student.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			String data = String.format("%s,%s,%d,%d,%d\r\n", n,b,k,e,m);
			bw.write(data);
			bw.flush();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		key.close();
	}
}




