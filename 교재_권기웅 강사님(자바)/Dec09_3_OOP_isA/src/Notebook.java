
public class Notebook extends Computer{
	double weight;
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(weight);
	}
}
