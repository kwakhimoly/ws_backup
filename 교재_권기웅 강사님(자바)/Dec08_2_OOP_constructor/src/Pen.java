// 생성자 관련 작업 전혀 안하면
//		자바가 컴파일때 기본생성자 만들어서 해줌
// 생성자 관련 작업 하면
//		기본생성자 안만들어주겠지 
//		-> 어차피 안쓸거니 -> 아쉽지는 않은...

// JSP/Spring/Android... : 
//		자동으로 객체 생성하는데 기본생성자를

// 메소드 순서가 중요? - x
public class Pen {
	// 멤버변수
	String color;
	int price;

	// 생성자
	// 기본 생성자(default constructor)
	public Pen() {
		// TODO Auto-generated constructor stub
	}
	// 오버로딩 된 생성자
	public Pen(String color, int price) {
		super();
		this.color = color;
		this.price = price;
	}

	// 기타 메소드
	public void print() {
		System.out.println(color);
		System.out.println(price);
	}
}
