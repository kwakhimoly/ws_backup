package com.kwon.dec162uc.main;

import java.util.ArrayList;
import java.util.HashSet;

import com.kwon.dec162uc.student.Student;

// []
// List계열 : 가변사이즈 배열
// Set계열 : 중복x - 기본형급에서나..., 순서?
// Map계열
public class UCMain4 {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("ㅋ");
		hs.add("ㅎ");		hs.add("ㅎ");		hs.add("ㅎ");
		hs.add("ㅇㅇ");
		hs.add("ㄱㄱ");
		hs.add("ㄴㄴ");
		System.out.println(hs.size());
		// Set -> List
		ArrayList<String> al = new ArrayList<>(hs);
		for (String string : al) {
			System.out.println(string);
		}
		System.out.println("-----");
		
		HashSet<Student> students = new HashSet<>();
		Student s = new Student("박길동", 0, 0, 0);
		students.add(s);
		students.add(s);
		students.add(new Student("홍길동", 100, 100, 100));
		students.add(new Student("김길동", 10, 10, 10));
		students.add(new Student("김길동", 10, 10, 10));
		System.out.println(students.size());
		System.out.println("-----");
		
		ArrayList<Integer> al2 = new ArrayList<>();
		al2.add(10);
		al2.add(20);	al2.add(20);	al2.add(20);
		al2.add(2133);
		al2.add(456);	al2.add(456);	al2.add(456);
		al2.add(4564);
		
		HashSet<Integer> hs2 = new HashSet<>(al2);
		al2 = new ArrayList<>(hs2);
		for (Integer integer : hs2) {
			System.out.println(integer);
		}
	}
}





