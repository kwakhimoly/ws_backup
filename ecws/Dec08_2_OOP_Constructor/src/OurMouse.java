
public class OurMouse {
	static final String MAKER = "logitech";
	String name;
	int price;
	
//	- constructor(생성자)
//    	: 객체가 만들어질때 뭐 하고 싶으면	
//		: 리턴 아예 없고, 클래스명과 이름이 같은 메소드 생성
	
	public OurMouse() {
		System.out.println("입고됨");
	}
	
	public void printAll() {
		System.out.println(MAKER);
		System.out.println(name);
		System.out.printf("%d원\n", price);
	}
	
	public static void printMaker() {
		System.out.println(MAKER);
	}
}
