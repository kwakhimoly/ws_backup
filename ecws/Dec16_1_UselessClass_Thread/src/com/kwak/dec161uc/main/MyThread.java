package com.kwak.dec161uc.main;

public class MyThread extends Thread {
	@Override
	public void run() {
		// 여기 하고 싶은 작업 쓰기
		super.run();
		for (int i = 0; i < 5; i++) {
			System.out.println("bye");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
