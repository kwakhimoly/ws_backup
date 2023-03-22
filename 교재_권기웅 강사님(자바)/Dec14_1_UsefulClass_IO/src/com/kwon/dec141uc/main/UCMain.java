package com.kwon.dec141uc.main;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

// 기본형
	// InputStream : 장치 -> 프로그램 입력용 빨대(1byte)
	// InputStreamReader : 2bytes
	// BufferedReader : 줄 단위로 처리해서 1String
	// OutputStream : 프로그램 -> 장치 출력용 빨대(1byte)
	// OutputStreamWriter : 2bytes
	// BufferedWriter : 줄 단위로 처리해서 1String
// 개조형
	// FileReader : InputStreamReader를 파일처리하기 편하게 개조
	// PrintStream : OutputStream에 이런저런 메소드 추가
	// ...
public class UCMain {
	public static void main(String[] args) {
		
		// 콘솔창에 붙어있던 [프로그램 -> 콘솔창] 빨대
		PrintStream ps = System.out; 
		ps.println("ㅋ");
		
		// 콘솔창에 붙어있던 [콘솔창 -> 프로그램] 빨대
		InputStream is = System.in;
		Scanner k = new Scanner(is); // InputStream 서포터
	}
}





