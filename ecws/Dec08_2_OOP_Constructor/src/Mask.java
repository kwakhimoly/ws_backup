
//생성자 관련 작업 전혀 안 하면
//	.java -번역(compile)-> .class
//		  번역 과정에서 자바가 생성자 만들어줌(생성자 관련 작업이 없었을 경우)

public class Mask {
	int price;
	String grade;
	public Mask() {
		// TODO Auto-generated constructor stub
//		class에서 아무것도 입력 안하고 ctrl+space 하면 constructor 자동완성
	}
	public void showInfo() {
		System.out.printf("%d원\n",price);
		System.out.println(grade);
	}
}
