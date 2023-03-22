package com.kwon.dec141uc.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FRMain {
	public static void main(String[] args) {
		// 파일처리하기 편하라고 InputStreamReader개조
		FileReader fr = null;
		try {
			fr = new FileReader("C:\\Kwon\\1214.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
