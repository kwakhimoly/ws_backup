
public class RedPen {

	String color;
	int price;
	
	public RedPen() {
//		기본 생성자(default constructor)
//		생성자 관련 작업 전혀 안 하면
//			.java -번역(compile)-> .class
//			  		번역 과정에서 자바가 기본 생성자 만들어줌
//					(생성자 관련 작업이 없었을 경우)
//		생성자 관련 작업 하면
//					기본 생성자 안 만들어줌
//		파라메터가 아니라 변수를 일일히 지정하고 싶으면 이렇게 따로 만들어줘야함
//		ex) OMain의 다홍펜 예시처럼 하고싶은 경우!
//			=> 근데 굳이 이럴 필욘 없음..
//		근데? 혹시 모르니까 만드는 버릇 들여놓기 -> 필요한 경우가 나중에 생김
	}
	
	public RedPen(String color, int price) {
//		오버로딩 생성자
		super();
		this.color = color;
		this.price = price;
	}
	
	public void printPen() {
		System.out.println(color);
		System.out.println(price);
	}
}

/*
 * 클래스 생성 순서
 * 1. 멤버변수
 * 2. 생성자
 * 		2-1. 기본 생성자
 * 		2-2. 오버로딩된 생성자
 * 3. 기타 메소드
 */
