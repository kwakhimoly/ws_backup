/*
핸드폰 만들어질 때 값 넣자
*/
public class Phone {
	static String maker = "Apple";
	String name;
	int price;
	String telecom;
	
//	public Phone(String name, int price, String telecom) {
//		생성자 오버로딩
//		this.name = name;
//		this.price = price;
//		this.telecom = telecom;
//		telecom = "SKT";
//		}
	
	public Phone(String name, int price, String telecom) {
	super();
	this.name = name;
	this.price = price;
	this.telecom = telecom;
}

	public void printInfo() {
		System.out.println(maker);
		System.out.println(name);
		System.out.println(price);
		System.out.println(telecom);
	}
}

/*
String name;
.
.
.
public void test(String name){
	String name = "asd";
	System.out.println(this.name);
}

멤버 변수 명이랑 지역 변수, 파라메터 이름이 같아도 됨
늘 가까이 있는 거 선택함
*/