// 패키지 : 클래스명 중복됐을 때 구분할 수단
//		=> 모든 클래스는 패키지 속에
//			무소속 : JSP/Spring에서 인식 못함
//		=> 패키지명이 중복되면? -> 끝
//			=> 패키지명이 전세계적으로 유니크해야
//				=> com.회사명.프로그램명.카테고리
//		정리효과는 덤

// 객체 만드는 문법
// 		패키지명.클래스명 변수명 = new 패키지명.생성자(...);

public class OMain2 {
	public static void main(String[] args) {
		java.util.Scanner k = new java.util.Scanner(System.in);
		
		Scanner s = new Scanner("캐논123", 500000);
	}
}










