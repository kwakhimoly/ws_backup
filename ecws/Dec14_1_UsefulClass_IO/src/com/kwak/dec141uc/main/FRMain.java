package com.kwak.dec141uc.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FRMain {
	public static void main(String[] args) {
//		파이썬
//			파일 전체를 다 읽어내서 변수에 저장
//				=> 전체 몇 줄인지 파악 가능
		
//		분석할 파일 : 1tb 면? ram에 이걸 다 담을 수 있는가?
		
//		파일 처리하기 편하라고 -> InputStreamReader 개조
		FileReader fr = null;
		try {
			fr = new FileReader("C:/kwak/1214.txt");
			BufferedReader br = new BufferedReader(fr); //줄단위 처리
			
			String line;
			while ((line = br.readLine())!= null) {
			
				System.out.println(line);
			}
			
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine()); //없으면 null
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fr.close(); // 꼭 닫아주기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
