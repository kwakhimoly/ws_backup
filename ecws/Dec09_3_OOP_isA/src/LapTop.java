public class LapTop extends Computer {
	
//	다단 상속 -> Product 로부터 받은 Computer 로부터 받은 LapTop
	
int weight;

public LapTop() {
	// TODO Auto-generated constructor stub
}

public LapTop(String name, int price, String cpu, int ram, int hdd, int weight) {
	super(name, price, cpu, ram, hdd);
	this.weight = weight;
}



@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(weight);
	}
}
