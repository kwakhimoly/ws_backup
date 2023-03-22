package com.kwon.dec161uc.main;
// JVM이 만들어준거 : mainThread
// 사람이 만든거 : subThread

// main : 0.3초마다 ㅋ출력 x 10번 -> 종료
// sub : 0.3초마다 ㅎ출력 x 무한

// mainThread끝난다고 subThread종료 되는거 아님
public class UCMain2 {
	public static void main(String[] args) {
		Thread t = new Thread(new MyT());
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
