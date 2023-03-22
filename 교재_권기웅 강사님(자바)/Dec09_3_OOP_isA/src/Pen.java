// Product : 상위클래스(super class)/부모클래스(parent c)
// Pen : 하위클래스(sub class)/자식클래스(?)

// Pen is a Product
public class Pen extends Product {
	String color;
	
	public Pen() {
		// TODO Auto-generated constructor stub
	}

	public Pen(String name, int price, String color) {
		super(name, price);
		this.color = color;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(color);
	}
}
