package com.kwon.dec132oop.main;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kwon.dec132oop.hero.Spiderman;

// GUI프로그램(윈도우 프로그램)
//		1. 윈도우프로그램을 누가 java로...
//		2. 윈도우프로그램 -> 웹 베이스로...
//		3. 안드로이드 앱개발반이면 하겠는데
//				웹개발/BD/AI과는 1도 상관없어서...

public class OMain2 {
	public static void main(String[] args) {
		// 제목이 지구인 JFrame
		JFrame p = new JFrame("지구");
		
		// 텍스트가 홍길동인 JButton
		JButton h = new JButton("홍길동");
		// 텍스트가 홍길동인 JTextField
		// JTextField h = new JTextField("홍길동");
		// JFileChooser
		// JFileChooser h = new JFileChooser();
		
		// 지구에 입주
		p.add(h);
		
		// 자바의 영역--------------------------------
		// ActionListener 
		//		  actionPerformed 기능이 반드시 있어야하는
		//		  actionPerformed를 추.메로 하자
		//		  추.클 or 인터페이스
		//		  상속라인 막기는 싫으니 => 인터페이스
		// -------------------------------------------
		
		// 스파이더맨(ActionListener) - singleton말고
		Spiderman i = new Spiderman();
		
		// 찜
		h.addActionListener(i);
		
		// 도와주세요 : 클릭
		
		// 그게 사이즈가 500, 300
		p.setSize(500, 300);
		
		// 보이게
		p.setVisible(true);
	}
}