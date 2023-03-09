
//Product: 상위 클래스(super class) / 부모 클래스(parent class)
//Pen: 하위 클래스(sub class) / 자식 클래스(children class?)
//Pen is a Product

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
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(color);
	}

}
