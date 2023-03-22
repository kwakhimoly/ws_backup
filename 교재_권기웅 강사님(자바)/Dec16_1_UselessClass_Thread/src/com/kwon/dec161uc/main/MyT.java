package com.kwon.dec161uc.main;

public class MyT implements Runnable{
	@Override
	public void run() {
		while (true) {
			System.out.println("ㅎ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
