package com.kwon.dec141uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

//홍길동
//1999/01/01[30살]
//국어 : 100
//영어 : 90
//수학 : 80
//평균 : 90
//------------------
//김길동
//2000/03/03[29살]
//...
public class FRMain2 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:/Kwon/student.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String cy = sdf.format(new Date());
			int cy2 = Integer.parseInt(cy);
			
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] line2 = line.split(",");
				System.out.println(line2[0]);
				System.out.println(line2[1]);
				
				
				String by = line2[1].substring(0, 4);
				int by2 = Integer.parseInt(by);
				System.out.println(cy2 - by2 + 1);
				
				System.out.println(line2[2]);
				System.out.println(line2[3]);
				System.out.println(line2[4]);
				int sum = 
					Integer.parseInt(line2[2]) + 
					Integer.parseInt(line2[3]) +
					Integer.parseInt(line2[4]);
				
				System.out.println(sum / 3.0);
				
				System.out.println("-----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
