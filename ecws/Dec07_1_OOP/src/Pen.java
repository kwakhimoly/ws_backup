
public class Pen {
//	펜이라는 존재를 표현하기 위한 클래스
//	펜 데이터를 임시로 저장하기 위한 클래스
//	펜 데이터를 전송할 때 사용하면 편할
//						DTO(Data Temp/Transfer Object)
//	데이터 표현하려고 쓰는
//						VO(Value Object)
//	Java: perfect한 OOL(객체지향언어) -> 자바의 기본 단위
//						JavaBean(=VO =DTO)

	String name;
	String maker;
	String color;
	int price;

	public void printInfo() {
		System.out.println(this.name);
		System.out.println(maker);
		System.out.println(color);
		System.out.printf("%d원\n", price);
	}

}
