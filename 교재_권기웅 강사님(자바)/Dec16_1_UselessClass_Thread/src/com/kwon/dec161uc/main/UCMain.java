package com.kwon.dec161uc.main;

// ...
// JVM이 thread라는 걸 만들어서 UCMain.main(...)으로 보냄

// multiThread
//		JVM이 만들어준 redThread : mainThread
//		개발자가 만들어서 쓰는 blueThread : subThread
public class UCMain {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start(); // 새 thread만들어서 run실행
		
		Thread t = new Thread(new MyThread2());
		t.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("ㅋ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
