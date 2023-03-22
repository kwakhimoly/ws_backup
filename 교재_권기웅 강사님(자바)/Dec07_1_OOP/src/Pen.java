// 펜 데이터를 임시로 저장하기 위한 클래스
// 펜 데이터를 전송할때 사용하면 편할
//		DTO(Data Temp/Transfer Object)
// 데이터 값 표현하려고 쓰는
//		VO(Value Object)
// Java : Perfect한 OOL -> Java의 기본단위
//		JavaBean
public class Pen {
	String name;
	String maker;
	String color;
	int price;
	
	public void showInfoooo() {
		System.out.println(this.name);
		System.out.println(maker);
		System.out.println(color);
		System.out.println(price);
	}
}
