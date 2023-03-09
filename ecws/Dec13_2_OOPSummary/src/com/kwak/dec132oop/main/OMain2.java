package com.kwak.dec132oop.main;

import javax.swing.JButton;
//import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.kwak.dec132oop.human.Spiderman;
//import javax.swing.JTextField;

//JFrame은 클래스가 이미 있음!
public class OMain2 {
	public static void main(String[] args) {
//		제목이 지구인 JFrame
//		그게 사이즈가 500, 300
//		보이게
		
		JFrame jframe = new JFrame("지구");
		JButton jbutton = new JButton("홍길동"); //String text
//		JTextField tf = new JTextField("홍길동"); //String text
//		JFileChooser fc = new JFileChooser(); //기본생성
		
		jframe.setSize(500, 300);
		jframe.setVisible(true);
		jframe.add(jbutton);
//		jframe.add(tf); => 입력 박스
//		jframe.add(fc);
		
//		ActionListner: actionPerformed 기능이 반드시 있어야 하는데
//					actionPerformed를 추상 메소드로 하자	
//					상속 라인을 막기는 싫으니 인터페이스로 만들자 
		Spiderman spidy = new Spiderman();
		jbutton.addActionListener(spidy); //전담 영웅으로 찜하기
	}
}
