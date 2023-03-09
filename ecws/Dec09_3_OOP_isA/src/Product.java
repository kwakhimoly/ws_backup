//		Object -> Product -> Computer -> LapTop
//		Product is a Object

public class Product /* extends Object => 기본값 */ {
	String name;
	int price;

	public Product() {
		System.out.println("hi");
//		System.out.println("what's in our shop"); // 하위클래스에 자동으로 불려감
	}
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	} // 얘는 하위클래스로 안 넘어감

//	1. 생성자는 상속 안 됨 => 생성자는 각자 만들어야 함
//	2. 하위클래스 객체(Pen) 만들면 상위클래스(Product) 기본 생성자를 자동으로 부름 -> 기본 생성자가 없으면 에러
	
	
	public void print() {
		System.out.println(name);
		System.out.println(price);
	}
}
