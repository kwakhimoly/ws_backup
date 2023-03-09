package com.kwak.dec131oop.main;

import com.kwak.dec131oop.menu.Alchol;
import com.kwak.dec131oop.random.KwakRandom;
//import com.kwak.dec131oop.tea.BlackTea;

public class OMain {
	public static void main(String[] args) {
//		정수 입력 받는 데 짝수만
		
		
		
		
		System.out.println("--------------");
//		랜덤한 정수 나오는 기능. 근데 짝수만
		KwakRandom kr = new KwakRandom();
		int x = kr.nextInt(10);
		System.out.println(x);
		
		
		System.out.println("----------------");
//		BlackTea b = new BlackTea("3pm", "3pm", 4000, true);
//		
//		b.printInfo();
//		b.taste();
		
		Alchol a = new Alchol("맥주", 3900, 10);
		a.print();
		
	}

}
