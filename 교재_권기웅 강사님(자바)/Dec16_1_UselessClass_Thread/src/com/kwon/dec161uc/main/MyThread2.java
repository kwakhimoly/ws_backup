package com.kwon.dec161uc.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyThread2 implements Runnable {
	@Override
	public void run() {
		JFrame j = new JFrame();
		JTextArea jta = new JTextArea();
		j.add(jta);
		j.setSize(300, 300);
		j.setVisible(true);
		
		for (int i = 0; i < 10; i++) {
			jta.append("ㅇ\r\n");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
