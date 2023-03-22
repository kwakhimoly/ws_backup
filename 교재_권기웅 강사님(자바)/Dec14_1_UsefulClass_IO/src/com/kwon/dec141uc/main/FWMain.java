package com.kwon.dec141uc.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// CPU : 연산
// RAM : 변수형태로 임시저장공간(재부팅하면 삭제) 
// SSD/HDD : 파일형태로 영구저장공간

public class FWMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("뭐 : ");
		String txt = k.next();

		// Stream시리즈는 다 썼으면 빨리 치워야
		// 연관된것들은 그것들중에 하나만 치워야
		// bw나 fw나 둘중에 하나만 닫아야
				
		// 파일에 쓰기 편하게 OutputStreamWriter개조
		BufferedWriter bw = null;
		try {
			FileWriter fw = new FileWriter("C:/Kwon\\1214.txt", true);
			bw = new BufferedWriter(fw);
			bw.write(txt + "\r\n");
			bw.flush(); // 빨대용량 다 안차도 강제 전송
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



