package com.kwon.dec123oop.main;

import java.util.Scanner;

import com.kwon.dec123oop.coffee.Coffee;
import com.kwon.dec123oop.human.Human;

public class OMain {
	public static void main(String[] args) {
		// 이름, 나이, 춥나 자기자신
		// 출력
		
		System.out.println("-----");
		
		Coffee c = new Coffee("아아", 3000);
		// c.name = "라떼";
		c.setName("라떼");
		// System.out.println(c.price);
		System.out.println(c.getPrice());
		c.print();
		System.out.println("-----");
		
		Human h = new Human("홍길동", 30);
		h.print();
		System.out.println("----");
	
		Scanner k = new Scanner(System.in);
		System.out.print("수정할 나이 : ");
		int a = k.nextInt();
		// h.age = a;
		h.setAge(a);
		h.print();
	}
}




