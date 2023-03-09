package com.kwak.dec162uc.main;

import java.util.ArrayList;
import java.util.Comparator;

import com.kwak.dec162uc.student.Student;

public class UCMain2 {
	public static void main(String[] args) {
		Student s = new Student("홍길동", 90, 80, 50);
		s.print();
		System.out.println("-------");
		ArrayList<Student> students = new ArrayList<>();
		students.add(s);
		students.add(new Student("김길동", 70, 75, 70));
		students.add(new Student("이길동", 50, 85, 76));
		students.add(new Student("박길동", 100, 88, 90));

//		2번째 학생 수학점수: 알아보기 편하게
		System.out.println(students.get(1).getMat());

		System.out.println("--------");

//		3번째 학생 정보: 메소드 활용
		students.get(2).print();

		System.out.println("-------");

//		전부 다
//		for (int i = 0; i < students.size(); i++) {
//			students.get(i).print();
//			System.out.println("====");
//		}

		for (Student student : students) {
			student.print();
			System.out.println("====");
		}

//		1등 학생 이름
//		ArrayList<Integer> average = new ArrayList<>();
//		
//		
//		int avg = 0;
//		for (int i = 0; i < students.size(); i++) {
//			avg = (students.get(i).getEng()+students.get(i).getKor()+students.get(i).getMat())/3;
//			System.out.printf("%s 평균: %d\r\n", students.get(i).getName() ,avg);			
//			average.add(avg);
//		}
//		
//		System.out.println("---------");
//		
//		
//		Comparator<Integer> c = new Comparator<Integer>() {
//			
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2.compareTo(o1);
//			}
//			
//		};
//		
//		average.sort(c);
//		
//		System.out.println(average.get(0));

//		총점 내림차순
		students.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				Integer o1Score = o1.getEng() + o1.getKor() + o1.getMat();
				Integer o2Score = o2.getEng() + o2.getKor() + o2.getMat();
				return o2Score.compareTo(o1Score);
			}

		});
		System.out.println(students.get(0).getName());
//		-> 이해하고 싶으면 반복문 돌려서 오름차순 정렬하는 거 해봐

		
		System.out.println("--------");
		
//		이름 가나다순
		Comparator<Student> com = new Comparator<Student>() {
//			-> 학생들(students) => AL:참조형(주소), 학생(student.get(0)) => Student(객체): 참조형(주소), 학생의 이름(students.get(0).getName()) => String 구분 명확히
			@Override
			public int compare(Student o1, Student o2) {
				String o1Name = o1.getName();
				String o2Name = o2.getName();
				return o1Name.compareTo(o2Name); // 이름은 자동으로 가나다순으로 정렬되나바
			}
		};
		
		students.sort(com);

		for (Student student : students) {
			System.out.println(student.getName());
		}
	}
}
