
public class City {
	String name;
	int ingu;
	Human ipjuja;
	
	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(String name, int ingu, Human ipjuja) {
		super();
		this.name = name;
		this.ingu = ingu;
		this.ipjuja = ipjuja;
	}
	
	public void showInfo() {
		System.out.println(name);
		System.out.println(ingu);
		ipjuja.print();
	}	
}
