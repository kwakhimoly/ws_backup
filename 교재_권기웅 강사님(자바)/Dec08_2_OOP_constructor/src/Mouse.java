// constructor : 생성자
//		객체가 만들어질때 뭐 하고싶으면
// 		리턴아예없고, 클래스명과 이름 같은 메소드
public class Mouse {
	String name;
	int price;
	static final String MAKER = "삼성";
	
	public Mouse() {
		System.out.println("입고됨");
	}

	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
		System.out.println(MAKER);
	}
	
	public static void printMaker() {
		System.out.println(MAKER);
	}
}
