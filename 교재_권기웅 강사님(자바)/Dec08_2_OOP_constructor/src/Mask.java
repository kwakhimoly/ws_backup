// 생성자 관련 작업 전혀 안하면
//		자바가 컴파일때 생성자 만들어서 해줌
//	 .java -번역(compile)-> .class
public class Mask {
	int price;
	String grade;

	// ctrl + space
	public Mask() {
		System.out.println("마스크 입고");
	}
	
	public void showInfo() {
		System.out.println(price);
		System.out.println(grade);
	}
}
