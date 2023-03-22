package com.kwon.sddevice.main;

import java.util.ArrayList;

// C : PL급 back-end개발자
public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		DeviceDAO dd = new DeviceDAO();
		int menu = 0;
		int page = 0;
		Device d = null;
		String result = null;
		ArrayList<Device> result2 = null;
		try {
			while (true) {
				menu = cs.showMainMenu();
				if (menu == 10) {
					break;
				} else if (menu == 2) {
					page = dd.getPageCount();
					page = cs.showSelectPageMenu(page);
					result2 = dd.getDevice(page);
					cs.showResult(result2);
				} else if (menu == 1) {
					d = cs.showRegDeviceMenu();
					result = dd.regDevice(d);
					cs.showResult(result);
				}
			}
		} catch (Exception e) {
			System.out.println("저기요...");
		}
		cs.bye();
	}
}
