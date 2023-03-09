//HasA
//		개발은 당연하고 문서작업도 잘 할 줄 알아야함 (엑셀 같은거)
//
//
//Dec09_1_ThisisJava: 신입 
//			Dog.java: 신입이 작업한거
//				+ 설명서까지 줘야지!
//Dec09_2_OOP_HasA: 사수
//			신입이 어떻게 해놨을지 아나... 그니깐요
//			이클립스가 엄청 도와주니까 크게 문제는 아닌데...
//			개발자 보편적 문화가 있어서 크게 문제는 아닌데..

public class OMain {
	public static void main(String[] args) {
		Dog d = new Dog("후추", 2);
		d.printInfo();

		System.out.println("=================");

		Person p = new Person("홍길동", 30);
		p.printInfo();
		System.out.println("=================");

		Person p2 = new Person("김길동", 20, d);
		p2.printInfo();
		
		System.out.println("=================");		
		City c = new City("수원", 2000000, p2);
		c.printCity();
		/*
		 * 후추, 2살짜리 개 
		 * 의 주인 김길동, 20살이라는 사람
		 * 이 사는 수원, 200만인 도시
		 * 
		 * 정보 출력
		 */
		System.out.println("=================");
//		c의 이름
		System.out.println(c.name);
//		c에 사는 사람의 이름
		System.out.println(c.livein.name);
//		c에 사는 사람의 전체정보
		c.livein.printInfo();
//		c에 사는 사람의 강아지의 이름
		System.out.println(c.livein.pet.name);
//		c에 사는 사람의 강아지의 전체 정보
		c.livein.pet.printInfo();
		
//		내 생각으로 정리해보자면! 다른 객체 속 무언가를 소환하고 싶으면 이.렇.게.하나();봄
	}
}
