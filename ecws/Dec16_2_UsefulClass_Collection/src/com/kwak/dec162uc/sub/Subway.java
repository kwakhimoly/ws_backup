package com.kwak.dec162uc.sub;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subway {
	BufferedReader br = null;
	private String dateSub = null;
	private String lineNum = null;
	private String lineName = null;
	private double enter = 0;
	private double out = 0;
	private double people = 0;
	{
		try {
			FileInputStream fis = new FileInputStream("C:\\kwak\\httpex\\subInfo/subY.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String[] ar = br.readLine().split(",");
			dateSub = ar[0]+","+ar[1]+","+ar[2];
			lineNum = ar[3];
			lineName = ar[4];
			enter = Double.parseDouble(ar[5]);
			out = Double.parseDouble(ar[6]);
			
			people = enter+out;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void print() {
		System.out.println(dateSub);
		System.out.println(lineNum);
		System.out.println(lineName);
		System.out.println(people);
	}
	
}
