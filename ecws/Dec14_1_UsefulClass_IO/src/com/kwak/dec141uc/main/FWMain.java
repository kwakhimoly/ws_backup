package com.kwak.dec141uc.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FWMain {

	public static void main(String[] args) {
//		CPU: 연산
//		RAM: 변수형태로 임시저장공간(재부팅하면 삭제)
//		SSD / HDD: 파일형태로 영구저장공간
		
		Scanner k = new Scanner(System.in);
		System.out.print("뭐: ");
		String txt = k.next();
		
//		Linux 구별 식자: / => 이거 써도 됨
//		윈도우 구별 식자: \
		
//		파일에 쓰기 편하게 OutputStreamWriter 개조
//		파일 없으면 만들어 줌, 폴더는 안 만들어줌
		BufferedWriter bw = null;
//		뭐라도 값을 넣어놔야 에러가 안남
		try {
			FileWriter fw = new FileWriter("C:/kwak\\1214.txt", true); //boolean append true: 추가 \ false: 교체
			//용량이 작아서 답답 ↓↓ bw 로 확장w
			bw = new BufferedWriter(fw);
			int a = 10/0; // => 이런 식으로 오류 생기면 bw.close()가 try에 있을 경우 바로 catch로 넘어가서 안 닫힘
			bw.write(txt + "\r\n");
			bw.flush(); //빨대용량(bw.write) 다 안차도 강제 전송
		} catch (IOException e) {
			e.printStackTrace();
		}
			try {
				bw.close();
				//다른 프로그램에서도 쓸 수 있게 종료
			} catch (IOException e) {
				e.printStackTrace();
			} 
		
//		java로 1214.txt 저장하는 프로그램
//		python으로 1214.txt 불러다 분석하는 프로그램
//			-> 이런 식으로 다른 프로그램에서 사용하려면 Stream 시리즈를 다 썼을 때 빨리 치워야 함
//		연관된 것들은 그것들 중에 하나만 치워야 함
//			fw랑 bw 연관되어 있음 -> 이 중 하나만 닫아야됨
	}
}
