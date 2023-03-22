// Object -> Product -> Com -> Notebook

// Product is a Object

// 1. 생성자는 상속 안됨 => 생성자는 각자 만들어야
// 2. 하위클래스 객체 만들면(Pen)
//		상위클래스 기본생성자를 자동으로 부름(Product)
//		super();도 부르는거
public class Product /* extends Object */ {
	String name;
	int price;

	public Product() {
		System.out.println("ㅋ");
	}
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public void showInfo() {
		System.out.println(name);
		System.out.println(price);
	}
}
