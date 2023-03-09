
public class Highlighter extends Pen {
	String scent;

	public Highlighter() {
		// TODO Auto-generated constructor stub
	}
	
	public Highlighter(String name, int price, String color, String scent) {
		super(name, price, color);
		this.scent = scent;
	}



	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(scent);
	}
}
