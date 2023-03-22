
public class Product {
	String name;
	int price;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public void show() {
		System.out.println(name);
		System.out.println(price);
	}

}
