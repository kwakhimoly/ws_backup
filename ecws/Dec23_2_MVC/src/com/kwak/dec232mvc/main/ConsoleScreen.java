package com.kwak.dec232mvc.main;

import java.util.Scanner;

public class ConsoleScreen {
	private Scanner strawSystem;
//	System.in : 콘솔창에 붙어 있는 빨대 (콘솔창 → 프로그램)
//	Scanner : 빨대 보조 기구

	public ConsoleScreen() {
		strawSystem = new Scanner(System.in);
	}

	public int getX() {
//		Scanner는 닫으면 다시는 못 씀 -> 근데 닫아야 함
//			=> (여기에) 지역변수로 넣으면 안 됨
		System.out.print("x: ");
		return strawSystem.nextInt();
	}

	public int getY() {
		System.out.print("y: ");
		return strawSystem.nextInt();
	}

	public void cut() {
		strawSystem.close();
	}

	public void printResult(CalcResult cr) {
		System.out.println(cr.getPlus());
		System.out.println(cr.getMinus());
		System.out.println(cr.getMultiple());
		System.out.println(cr.getDivision());
	}

}
