package com.kwak.dec161uc.main;

public class MyT implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println("bye");
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
