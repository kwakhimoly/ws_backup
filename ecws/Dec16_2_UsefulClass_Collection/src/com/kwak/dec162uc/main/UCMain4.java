package com.kwak.dec162uc.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

import com.kwak.dec162uc.student.Student;

//List 계열: 가변 사이즈 배열
//Set 계열 : 중복x -> 넣으면 안되는건 아닌데 넣어도 알아서 없앰 -> 기본형급은 가능한데...(모든 기본형도 아님..)
//Map 계열

public class UCMain4 {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();

		hs.add("에휴");
		hs.add("에구");
		hs.add("에그");
		hs.add("에그"); // 중복 처리 돼서 사라짐
		hs.add("에그");
		hs.add("?");
		hs.add("!");

		System.out.println(hs.size());

//		Set을 쓰려면 List 로 바꿔서 써야 함
//			=> 그냥 생성자에 넣으면 됨
		ArrayList<String> al = new ArrayList<>(hs);
		for (String string : al) {
			System.out.println(string);
		}
		System.out.println("--------");

		HashSet<Student> students = new HashSet<>();
		Student s = new Student("멍길동", 0, 0, 0);
		students.add(s);
		students.add(s); // 이러면 중복 처리 됨 -> 같은 객체기 때문
		System.out.println(students.size());

		students.add(new Student("함길동", 78, 45, 60));
		students.add(new Student("진길동", 100, 85, 100));
		students.add(new Student("진길동", 100, 85, 100));
		// 진길동 중복 처리 안 됨 -> 다른 객체기 때문(서로 다른 학생인데 어쩌다보니 이름, 점수가 같은 거)
		System.out.println(students.size());
		System.out.println("-----------");

		ArrayList<Integer> al2 = new ArrayList<>();
		al2.add(3);
		al2.add(14);		al2.add(14);		al2.add(14);
		al2.add(530);
		al2.add(33);		al2.add(33);		al2.add(33);
		al2.add(98);
//		기본형급 List에 중복 있을 때 set에 넣었다가 빼기 
		HashSet<Integer> hs2 = new HashSet<>(al2);
		al2 = new ArrayList<>();
		for (Integer integer : hs2) {
			System.out.println(integer);
//			중복 빠짐
		}
		
		System.out.println("===========");
		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		};
		
//		정렬하려면 al2->hs2->al3 변환 과정 거쳐야됨!
		
		ArrayList<Integer> al3 = new ArrayList<>(hs2);
		al3.sort(c);
		for (Integer integer : al3) {
			System.out.println(integer);
		}
		
		
	}
}
