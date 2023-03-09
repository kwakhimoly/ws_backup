
public class Computer extends Product {
	int moniter;

	public Computer() {
		// TODO Auto-generated constructor stub
	}

	public Computer(String name, int price, int moniter) {
		super(name, price);
		this.moniter = moniter;
	}

	@Override
	public void PrintInfo() {
		// TODO Auto-generated method stub
		super.PrintInfo();
		System.out.println(moniter);
	}
}
