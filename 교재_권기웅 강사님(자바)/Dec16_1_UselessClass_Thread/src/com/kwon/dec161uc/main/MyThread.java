package com.kwon.dec161uc.main;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("ㅎ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
