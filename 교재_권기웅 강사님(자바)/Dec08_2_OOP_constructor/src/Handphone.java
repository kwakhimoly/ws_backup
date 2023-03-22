// 멤버변수명, 지역변수/파라메터명 같아도 됨
// 가까이 있는거
// 멤버변수를 써야겠다 : this.xxx
	
// 메소드 오버로딩 : 파라메터 다르면, 메소드명 같게

// 핸드폰 만들어질때 값 넣자

public class Handphone {
	String name;
	int price;
	String tongsinsa;
	
	// 결과값 자료형
	public Handphone() {
		System.out.println("핸드폰ㅋ");
	}
	
	// 오버로딩된 생성자
	public Handphone(String name, int price, String tongsinsa) {
		super();
		this.name = name;
		this.price = price;
		this.tongsinsa = tongsinsa;
	}

	public void print() {
		System.out.println(name);
		System.out.println(price);
		System.out.println(tongsinsa);
	}
}
