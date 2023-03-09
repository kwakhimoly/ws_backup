package com.kwak.dec125oop.avengers;

import com.kwak.dec125oop.flyer.Flyer;
import com.kwak.dec125oop.humen.Human;

public class Ironman extends Avengers implements Human, Flyer {
//												, 사용하면 인터페이스 여러 개 사용 가능

	private String ai;

	public Ironman() {
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
	public void printInfo() {
		super.printInfo();
		System.out.println(ai);
	}
	
	@Override
	public void attack() {
//		System.out.println(name); => 에러남
//		: name은 Avengers 소속, Avengers 외부의 IronMan이라 private String name을 사용할 수 없음(private 판정기준)
		System.out.println(getName());
		System.out.println("빔 발사");
	}

	@Override
	public void eat() {
		System.out.println("냠");
	}

	@Override
	public void fly() {
		System.out.print(getName()+" ");
		System.out.println("슝");
	}
	
}
