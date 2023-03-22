
public class Monitor extends Product{
	double size;
	
	public Monitor() {
		// TODO Auto-generated constructor stub
	}

	public Monitor(String name, int price, double size) {
		super(name, price);
		this.size = size;
	}
	
	@Override
	public void show() {
		super.show();
		System.out.println(size);
	}
}
