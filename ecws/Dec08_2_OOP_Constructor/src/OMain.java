
public class OMain {

	public static void main(String[] args) {
//	쇼핑몰: 로지텍만 판다	
//		마우스
//			모델명이 pebble
//			가격이 20000
//			메이커 logitech

//		메이커만 출력
//		System.out.println(OurMouse.MAKER);	
		OurMouse.printMaker();
//		static 써서 객체가 안 만들어진 상황에서도 출력 가능
		System.out.println("==========");

//		마우스가 매진됐고 
//		찜해놓기 기능 (입고되면 알림 와라 -> 출력)
//		=> constructor(생성자) 기능 사용

//		정보 다 출력
		OurMouse m = new OurMouse();
//		-> 객체 생성과 동시에 생성자 소환( new "OurMouse()" )
//		객체 만드는 형식
//		: 클래스명 변수명 = new 생성자;
		m.name = "pebble";
		m.price = 20000;
		m.printAll();

		System.out.println("---------------");

		Mask mm = new Mask();
		mm.price = 1000;
		mm.grade = "KF-94";
		mm.showInfo();

		System.out.println("---------------");

//		Computer com = new Computer();
//		com.cpu = "i7-5150";
//		com.ram = 8;
//		com.hdd = 256;
//		
//		com.printCom();
//		
		Computer com2 = new Computer();
		com2.cpu = "i7";
		com2.ram = 8;

		com2.printCom();

		System.out.println("---------------");

		Phone p = new Phone("IPhone13", 1200000, "SKT");

		p.printInfo();

		System.out.println("---------------");

		RedPen r = new RedPen("Red", 500);
		r.printPen();

		RedPen r2 = new RedPen();
		r2.color = "다홍";
		r2.price = 600;
		r2.printPen();

		System.out.println("---------------");

		Book b = new Book("지구 끝의 온실", "김초엽", 13500);
		b.printBook();
	}

}
