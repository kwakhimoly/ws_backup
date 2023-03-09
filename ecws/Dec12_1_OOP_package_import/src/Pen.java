
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
	public void PrintInfo() {
		// TODO Auto-generated method stub
		super.PrintInfo();
		System.out.println(color);
	}
}
