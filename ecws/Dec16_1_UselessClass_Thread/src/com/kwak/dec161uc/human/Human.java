package com.kwak.dec161uc.human;

public class Human {

//	multiThread
//			데이터 분석: 2015년도, 2016년도 동시에 하고 싶을 때
//						근데 어차피 한국은 분석을 python으로 하라니까 쓸데가 없는..
//						java로 한다 해도 제대로 하려면 Hadoop(컴퓨터 여러대로 병렬 처리하는 기술) / Elasticsearch .. -> 이런 기술 사용
//			웹 개발: 웹 사이트를 여러명이 동시에 쓰니까 -> 기본으로 사용
//						jsp.jar / spring.jar -> 알아서 함

//	ktx 예매 -> 여러명이 같이 씀

//	synchronized : 한 순간에 하나만(동시 실행이 안 되는 메소드)
//	자동완성할 때 시계 붙어 있는거 -> synchronized
	
	private String brain;

	private synchronized void sayName() {
		for (int i = 0; i < 5; i++) {
			brain = "모니카 겔러";
			try {
				Thread.sleep(100);
				System.out.printf("이름: %s\n", brain);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void sayHobby() {
		for (int i = 0; i < 5; i++) {
			brain = "청소";
			try {
				Thread.sleep(400);
				System.out.printf("취미: %s\n", brain);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
//	이름,취미 Thread가 brain이라는 변수를 공유
//	취미가 변수 지정하고 출력까지 0.3초 기다리는 동안 이름이 실행되며 변수를 다시 지정하기 때문에 취미가 이름으로 출력되는 것
//	=> critical section 설정(임계영역)
	

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
