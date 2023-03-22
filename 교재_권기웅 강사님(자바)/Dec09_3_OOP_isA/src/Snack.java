
public class Snack extends Product {
	String exp;
	
	public Snack() {
		// TODO Auto-generated constructor stub
	}

	// 아무것도 없거나
	// super();가 있으면 => 상위클래스 기본생성자 부르는데
	// super(name, price);가 있으면 => 상위클래스 그 생성자 부른거
	public Snack(String name, int price, String exp) {
		//super(); // 상위클래스 기본생성자 부른거
		super(name, price);
		this.exp = exp;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(exp);
	}
}
