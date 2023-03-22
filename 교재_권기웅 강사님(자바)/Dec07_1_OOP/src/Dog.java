// java : perfect한 객체지향언어
// python : hybrid한 객체지향언어

// 문화
// 		클래스명은 대문자로 시작
//		main이 포함되어있으면 ~~~Main

// 속성(attribute) : 존재들마다 갖고있는 특징적인 값
// 멤버변수로 표현
//		member variable, attribute, field
//
// action : 존재들이 행동/프로그램 상 필요한 기능
// 멤버함수(없는말)로 표현 => method

public class Dog {
	String name;
	int age; 

	public void bark() {
		System.out.println("멍");
	}

	public void printInfo() {
		// this.은 생략가능
		System.out.println(this.name);
		System.out.println(age);
	}
}
