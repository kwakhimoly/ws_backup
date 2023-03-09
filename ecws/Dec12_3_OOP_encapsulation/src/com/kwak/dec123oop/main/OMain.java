package com.kwak.dec123oop.main;

import java.util.Scanner;

import com.kwak.dec123oop.information.Coffee;
import com.kwak.dec123oop.information.Me;
import com.kwak.dec123oop.information.Person;

public class OMain {

	public static void main(String[] args) {
		Person p = new Person("홍길동", 30);
		p.printInfo();

		System.out.println("-------------");

		Scanner k = new Scanner(System.in);
		System.out.print("수정할 나이: ");
		int a = k.nextInt();

		System.out.println("-------------");

		p.setAge(a);
		p.printInfo();

		System.out.println("=============");

		Coffee c = new Coffee("아이스 아메리카노", 1500);
		c.printInfo();

		c.setName("카페라떼");
		c.setPrice(2000);
		c.printInfo();

		System.out.println("==============");
		Me m = new Me("곽하영", 25, true);
		m.printInfo();

		System.out.println("==============");
		m.setCold(false);
		m.printInfo();
	}

}
