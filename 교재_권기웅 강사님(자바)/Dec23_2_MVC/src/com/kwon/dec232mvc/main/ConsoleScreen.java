package com.kwon.dec232mvc.main;

import java.util.Scanner;

// System.in : 콘솔창에 붙어있는 콘 -> 프 빨대
// Scanner : 빨대보조기구
public class ConsoleScreen {
	private Scanner strawSystem;
	
	public ConsoleScreen() {
		strawSystem = new Scanner(System.in);
	}
	
	public int getX() {
		System.out.print("x : ");
		return strawSystem.nextInt();
	}
	
	public int getY() {
		System.out.print("y : ");
		return strawSystem.nextInt();
	}
	
	public void printResult(CalcResult cr) {
		System.out.println(cr.getHab());
		System.out.println(cr.getCha());
		System.out.println(cr.getGob());
		System.out.println(cr.getMoks());
	}
	
	public void cut() {
		strawSystem.close();
	}
}



