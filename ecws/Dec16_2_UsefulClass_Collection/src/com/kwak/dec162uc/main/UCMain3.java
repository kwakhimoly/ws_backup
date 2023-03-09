package com.kwak.dec162uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

import com.kwak.dec162uc.sub.StationInfo;



//가장 이용객수(탄+내린)가 많았던
//(언제 몇호선 무슨역)지하철

//2015/01/01(수)
//1호선
//서울역
//30000
//20000


//1. 파일 읽어오기
//2. 클래스 객체 만들기
//	2-1. 클래스 객체 안에서 split
public class UCMain3 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\kwak\\httpex\\subInfo/subY.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String line = null;
			ArrayList<StationInfo> al = new ArrayList<>();
			while ((line=br.readLine())!=null) {
				StationInfo s = new StationInfo(line);
				
				al.add(s);
			}
			
			Comparator<StationInfo> c = new Comparator<StationInfo>() {

				@Override
				public int compare(StationInfo o1, StationInfo o2) {
					Double o1Sum = o1.getEnter() + o1.getOut();
					Double o2Sum = o2.getEnter() + o2.getOut();
					return o2Sum.compareTo(o1Sum);
				}

				
			};
			
			al.sort(c);
			
			al.get(0).print();
			System.out.println("---");
			al.get(1).print();
			System.out.println("---");
			al.get(2).print();
			
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
