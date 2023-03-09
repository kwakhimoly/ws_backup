//이 상황 자체가 희귀
//추가하는 거 없이 Product에 있는 생성자 그대로 쓰고 싶음
//java는 생성자 상속 안 시켜줌 => 이클립스는 해줍니다


public class Shoes extends Product {
	public Shoes() {
		// TODO Auto-generated constructor stub
	}

	public Shoes(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}

}
