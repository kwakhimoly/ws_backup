// 이 상황 자체가 희귀
// Product에 있는 생성자 그대로 쓰면 되는데
// Java는 생성자 상속 안시켜줌
public class Shoes extends Product {

	public Shoes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shoes(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	
}
