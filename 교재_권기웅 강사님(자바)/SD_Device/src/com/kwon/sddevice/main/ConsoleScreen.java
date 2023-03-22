package com.kwon.sddevice.main;

import java.util.ArrayList;
import java.util.Scanner;

// V : 디자이너
public class ConsoleScreen {
	private Scanner inputSystem;

	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}

	public int showMainMenu() throws Exception {
		System.out.println("장비관리---");
		System.out.println("1. 장비등록");
		System.out.println("2. 장비조회");
		System.out.println("...");
		System.out.println("10. 종료");
		System.out.println("-----");
		System.out.print("뭐 : ");
		return inputSystem.nextInt();
	}

	public int showSelectPageMenu(int page) {
		System.out.printf("몇 페이지[1 ~ %d] : ", page);
		return inputSystem.nextInt();
	}
	
	public Device showRegDeviceMenu() throws Exception {
		System.out.print("장비명 : ");
		String n = inputSystem.next();
		System.out.print("분류 : ");
		String c = inputSystem.next();
		System.out.print("가격 : ");
		int p = inputSystem.nextInt();
		System.out.print("어디에 : ");
		String w = inputSystem.next();
		return new Device(0, n, c, p, w);
	}

	public void showResult(String result) {
		System.out.println(result);
	}
	
	public void showResult(ArrayList<Device> result) {
		for (Device device : result) {
			System.out.println(device.getName());
			System.out.println(device.getCate());
			System.out.println(device.getPrice());
			System.out.println(device.getWhere());
			System.out.println("-----");
		}
	}
	
	
	
	
	public void bye() {
		inputSystem.close();
	}
}


