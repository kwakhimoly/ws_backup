// 객체 만들기
// 클래스명 변수명 = new 생성자();

public class OMain {
	public static void main(String[] args) {
		Book b = new Book("자바", "홍길동", 30000);
		b.print();
		System.out.println("-----");
		
		Pen p = new Pen("빨강", 500);
		p.print();
		System.out.println("-----");
		
		Handphone h2 = new Handphone("폴드3", 0, "KT");
		h2.print();
		System.out.println("-----");
		
		Handphone h = new Handphone();
		h.name = "플립3";
		h.price = 0;
		h.tongsinsa = "SK";
		h.print();
		System.out.println("-----");

		Computer c = new Computer();
		c.cpu = "i7-1234";
		c.ram = 8;
		c.printHahaha();
		System.out.println("-----");
		
		Mask mm = new Mask();
		mm.price = 1000;
		mm.grade = "KF94";
		mm.showInfo();
		System.out.println("-----");
		
		Mouse m = new Mouse();
		m.name = "asd123";
		m.price = 10000;
		m.printInfo();
		System.out.println("----");
		Mouse.printMaker();
	}
}
