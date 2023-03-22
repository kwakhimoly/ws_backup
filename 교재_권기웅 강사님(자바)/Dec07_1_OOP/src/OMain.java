// PP(Procedural Programming) : 절차지향프로그래밍
//		조건문/반복문/...을 적재적소에 순서대로 배치해서
//		결과 잘 나오게 하자
// 근데 컴퓨터도 좋아지고, 사람들도 똑똑해지고, ...

// OOP(Object Oriented Programming) : 객체지향프로그래밍
//		유지보수에 용이하게 하자
//		-> 소스가 알아보기 편해야
//		-> 프로그래밍언어가 인간의 언어에 가깝게 써진다면...
//		-> PL 1도 모르는 사람이 소스 봤을때 알수있게
//		-> real world를 묘사하자
//	
//		객체 : 실생활에 존재하는 뭐

public class OMain {
	
	public static void main(String[] args) {
		// 우리가 살고있는 real world에 String/int은 없음
		// String이 뭐냐
		String name = "후추";
		System.out.println(name);
		// int?
		int age = 3;
		System.out.println(age);
		System.out.println("-----");
		
		// 우리 세상에는 이름이 후추고 나이가 3살인 개
		// 개 객체를 만들자 => 개 클래스
		Dog d = new Dog();
		d.name = "후추";
		d.age = 3;
		d.bark();
		d.printInfo();
		System.out.println("-----");
		
		Pen p = new Pen();
		p.name = "모나미153";
		p.maker = "모나미";
		p.color = "빨강";
		p.price = 500;
		p.showInfoooo();
		System.out.println("-----");

		Calculator c = new Calculator();
		c.printHab(10, 20);
	}
}




