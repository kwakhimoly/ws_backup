package com.kwak.dec162uc.main;

import java.util.ArrayList;
import java.util.Comparator;

//데이터들을 관리
//	들: []
//		객체지향언어에서 뭐하는..
//		만들 때 사이즈 고정, 변경 불가
//			사이즈 모르면 못 만들 거고...

//Collection
//	객체만 넣을 수 있음
//	데이터 섞어서 넣기도 가능 -> 딱히 장점이라고는..
//	가변사이즈
//		List 계열: 가변사이즈 배열(java 주력)
//					ArrayList => 동시에 여러 작업 가능(multiThread 문제가 생길 수도 ~ )
//					Vector => 동시에 안되는 대신(synchronized) multiThread 문제 없음
//		Set 계열	
//		Map 계열

//	<클래스명>: Generic
//		그 자료형만 넣게

//	정렬: java에서 정렬 어떻게 - x
//		[]+for 로 해내기
public class UCMain {
	public static void main(String[] args) {
		ArrayList al2 = new ArrayList();
		al2.add(10);
		al2.add("who");
		System.out.println(al2.get(0));
		System.out.println(al2.get(1));
		System.out.println("---");

		ArrayList<Integer> al = new ArrayList<>();
		al.add(10); // 10은 기본형이지만 java가 알아서 객체형으로 바꿔서 넣은 것
		al.add(12);
		al.add(25);
		al.add(1, 100); // 위치 지정해서 집어넣기도 가능
		al.set(0, 999); // 0번 자리의 데이터를 바꾸기(10->999)
		al.remove(2); // 2번 데이터(12) 지우기
//		al.add("hi"); => 자료형 지정했기 때문에 섞어 쓸 수 없음(지정 안 하면 가능한데 굳이 그럴 이유가..)

		
//		정렬시키고자 하는 list의 자료형에 맞춰서 comparator(interface임) 생성
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
//				o1.compareTo(o2): 오름차순
//				o2.compareTo(o1): 내림차순
			}
		};
		
		al.sort(c); // 정렬 완료! => 코딩테스트에선 직접 만들길 바라니까 또..
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		System.out.println("---");
		for (Integer a : al) { // 차례대로 출력
			System.out.println(a);
		}
	}
}
