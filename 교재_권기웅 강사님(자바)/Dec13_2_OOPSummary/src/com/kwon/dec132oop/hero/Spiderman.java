package com.kwon.dec132oop.hero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spiderman implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("거미줄 발사");
	}
}
