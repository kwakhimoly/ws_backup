package com.kwon.dec125oop.avengers;

import com.kwon.dec125oop.flyer.Flyer;
import com.kwon.dec125oop.human.Human;

// 다중상속 : Java는 안됨[Python은 되니까...]
// 		Ironman is a Avengers
// 		Ironman is a Human
//		Ironman is a Flyer
// interface로 제한적으로나마 다중상속 느낌


public class Ironman extends Avengers implements Human, Flyer {
	private String ai;
	
	public Ironman() {
		// TODO Auto-generated constructor stub
	}

	public Ironman(String name, int age, String ai) {
		super(name, age);
		this.ai = ai;
	}

	public String getAi() {
		return ai;
	}

	public void setAi(String ai) {
		this.ai = ai;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println(ai);
	}
	
	@Override
	public void attack() {
		// System.out.println(name); // private어쩌고 판정기준이 Avengers
		System.out.println(getName());
		System.out.println("빔 발사");
	}

	@Override
	public void eat() {
		System.out.println("냠");
	}

	@Override
	public void fly() {
		System.out.println("슝");
	}
}







