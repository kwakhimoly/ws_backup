// static 멤버변수
//		객체들의 공통속성
//		static영역에 하나만 만들어지고, 공유함 -> 메모리 절약
//		객체 없이도 쓸수있는
//			클래스명.xxx

// static final 멤버변수
//		상수화
//		변수명을 다 대문자로...

// 메소드 : 객체의 행동, 기능

// static 메소드
//		메모리 절약 - 그...
//		객체 없이도 쓸수있는
//		static메소드에서 static이 아닌거 사용불가

public class Gejang {
	String name;
	double weight;
	int price;
	// static final String PRODUCER = "김수미";
	static String producer = "김수미";
	
	public void showInfo() {
		System.out.println(name);
		System.out.println(weight);
		System.out.println(price);
		System.out.println(producer);
	}
	
	// 객체 없이도 쓰는
	public static void test() {
		// System.out.println(name);
		System.out.println(producer);
		System.out.println("테스트");
	}
}










