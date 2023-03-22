// z : local variable(지역변수)
//		메소드 속에서 만들어져서, 
//		그 메소드 속에서만 사용가능
//		=> 그 메소드 작업하는 동안만 임시로 쓰고 버릴거
//		Java는 기본값 없음 -> 만들고 꼭 값 넣고 써야

// x, y : parameter(인자)
//		어디서 받아오는데,
//		그 메소드 속에서만 사용가능
//		=> 그 메소드 작업하는데 필요한 재료
//		Java는 기본값 없음 -> 메소드를 호출할때 넣을테니...

// price : member variable(멤버변수)
//		=> 그 객체의 속성(그 객체를 소개할때 얘기할만한거)
//		Java는 기본값 있음
//			숫자계열 : 0
//			참조형 : null

public class Calculator {
	int price;
	
	public void printHab(int x, int y) {
		int z = x + y;
		System.out.println(z);
	}
	
}

