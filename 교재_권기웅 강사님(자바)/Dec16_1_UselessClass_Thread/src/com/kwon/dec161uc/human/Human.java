package com.kwon.dec161uc.human;

// multiThread
//		데이터분석 : 2015, 2016동시에 하고싶은데
//				커리큘럼/대한민국이 분석을 python으로 하라니까
//				제대로 한다면 Hadoop/Elasticsearch를 쓸거고...
//		웹개발 : 웹사이트라는건 여러명이 동시에 쓰는건데
//				jsp.jar/spring.jar 알아서 함

// thread 2개가 brain을 공유하니까
// critical section설정(임계영역)
public class Human {
	private String brain;
	
	// synchronized는 하나만(동시 실행이 안되는 메소드)
	private synchronized void sayName() {
		for (int i = 0; i < 10; i++) {
			brain = "홍길동";
			try {
				Thread.sleep(100);
				System.out.printf("이름 : %s\n", brain);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private synchronized void sayHobby() {
		for (int i = 0; i < 10; i++) {
			brain = "독서";
			try {
				Thread.sleep(300);
				System.out.printf("취미 : %s\n", brain);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void introduce() {
		Thread t = new Thread() {
			@Override
			public void run() {
				super.run();
				sayName();
			}
		};
		t.start();
		sayHobby();
	}
}



