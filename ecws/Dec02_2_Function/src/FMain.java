
public class FMain {
	public static void talk() {
		// void -> 딱히 뭐 필요 없는데 문법적으로 자료형을 써야 할 때 사용(비어있음)
		// 함수명 짓는 조건은 변수명 짓는 조건과 유사 but 함수명은 동사형으로 짓게 되고 변수명은 명사형으로 짓게 됨

		System.out.println("하영이 밥무거");
		System.out.println("먹엇지");
		System.out.println("자기 없이 먹으니까 입맛이 없더라");
		System.out.println("왐마야~~");
		System.out.println("추워서그런거아니야?");

	}

	public static void printSum(int a, int b) {
		System.out.println(a + b);
	}

	public static void printBigger(int c, int d) {
		System.out.println(c > d ? c : d);
	}

	public static void printBigger2(int c, int d) {
//		앞의 함수의 변수명과 같은 이름을 써도 
//		함수가 다르면 다른 공간으로 인식되며 각자 해당 함수 안에서만 
//		사용가능하기 때문에 오류가 나지 않음
		System.out.println(c > d ? c : d);
	}

	/*
	 * public static void printX(int a, int b, int c) { System.out.println(a * b);
	 * System.out.println(c * b); System.out.println(c * a); System.out.println(a *
	 * b * c); System.out.println("---------------"); }
	 */

	public static void printGob(int a, int b) {
		System.out.println("2개짜리");
		System.out.println(a * b);
	}

	public static void printGob(int a, int b, int c) {
		System.out.println("3개짜리");
		System.out.println(a * b * c);
	}

	public static int convertMilli(int second) {
//		초 -> 1000분의 1초(밀리초) 단위로 바꿔주는 함수
		int milliSec = second * 1000;
		return milliSec; 
		// 함수가 무조건 여기서 끝남. 이 뒤에 쓴 코드는 실행이 안됨
		// 함수의 값을 main에 보낼 수 있음
	}
	
	//정수 하나 넣으면 홀/짝 구해주는 함수
	public static String getOddEven(int num) {
		return (num % 2 == 0 ? "짝수" : "홀수");
	}
	
	public static void main(String[] args) throws InterruptedException {
		// 여기(main)에 넣으면 자동으로 실행되지만 위처럼 새로 만든 함수는 자동 실행 안됨.
		// 필요할 때마다 여기로 갖다 써야함 -> 함수 호출
		talk();
		System.out.println("---------------");
		printSum(8, 4);
		printSum(14, 17);
		System.out.println("---------------");
		printBigger(4, 18);
		printBigger2(102, 3);
		System.out.println("---------------");
		printGob(3, 2);
		printGob(5, 2, 4);
		System.out.println("---------------");
		int ms = convertMilli(3); 
		//convertMilli 라는 함수에 3이라는 값을 넣어줌
		// 함수의 값을 return 통해 받아서 ms에 대입해줌
		Thread.sleep(ms);
		// 3초 뒤에 결과값이 나오게
		System.out.println("---------------");
		String result = getOddEven(ms);
		System.out.println(result);
	
	}
}
