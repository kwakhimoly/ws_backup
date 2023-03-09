package com.kwak.dec161uc.main;



//주제: 동시에 작업하기
//		=> MultiTread Programming
//
//JVM이 Thread라는 걸 만들어서
//	UCmain.main(...)으로 보냄 => Thread가 닿으면 실행.. ->Thread.sleep: Thread 잠깐 쉬어라
//		=>이 때 사용하는 Thread: mainThread
//	개발자가 만들어서 사용하는 subThread
public class UCMain {
	public static void main(String[] args) {
		try {
			MyThread mt = new MyThread();
			mt.start(); // 새 thread 만들어서 run 실행
			
			Thread t = new Thread(new MyThread2());
			t.start();
			
			for (int i = 0; i < 5; i++) {
				System.out.print("hi");
				Thread.sleep(300);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
