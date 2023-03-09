package com.kwak.dec161uc.main;


//JVM이 만든거: main Thread
//개발자가 만든거: sub Thread

//main: 0.3초마다 hi 출력 x 5번 -> 종료
//sub: 0.3초마다 bye 출력 x 무한
//
//main 끝날 때 sub의 운명??
//	=> main 종료된다고 subThread가 자동으로 종료되는게 아님. 안 끝남
public class UCMain2 {
	public static void main(String[] args) {
		Thread t = new Thread(new MyT());
		t.start();
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("hi");
				Thread.sleep(300);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
