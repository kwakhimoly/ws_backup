
public class CoffeMachine {
	String name;
	int price;
	
	public CoffeMachine() {
		// TODO Auto-generated constructor stub
	}

	public CoffeMachine(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void takeShot() {
		System.out.println("드르륵");
	}
	
}
