package com.kwak.dec141uc.main;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

//	Stream급
//	Reader / Writer급
	

//									한 글자 : 2 byte
//	InputStream : 장치 -> 프로그램 입력용 빨대(1 byte)
//	InputStreamReader : 2 byte
//	BufferedReader : 줄 단위로 처리해서 1 String

//	OutputStream : 프로그램 -> 장치 출력용 빨대(1 byte)
//	OutputStreamWriter : 2 byte
//	BufferedWriter : 줄 단위로 처리 1 String

//	개조형
//		PrintStream : OutputStream 에 이런저런 메소드 추가
//				=> System.out.println();
//		FileReader : InputStreamReader 를 파일 처리하기 편하게 개조
					

public class UCMain {

	public static void main(String[] args) {
//		콘솔창에 붙어있던 [ 프로그램 -> 콘솔창 ] 빨대
		PrintStream ps = System.out;
		ps.println("hi");
	
//		콘솔창에 붙어있던 [ 콘솔창 -> 프로그램 ] 빨대
		InputStream is = System.in;
		Scanner k = new Scanner(is); // InputStream Supporter
	}
			
}
