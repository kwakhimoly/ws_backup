// 함수(function) : 
//		관련있는 기능들을 묶어놓고
//		필요할때마다 갖다쓰는
//		소스 정리 차원에서

// 함수명 짓는조건 == 변수명 짓는조건

// 함수 overloading
// 		기본적으로 함수명 같으면 안됨
//		파라메터(갯수, 자료형)가 다르면 같아도 됨
//		일부터 같게 짓는 테크닉
//		Java는 지원됨

// ctrl + shift + *(numpad)
// ctrl + shift + /(numpad)	

public class FMain {
// 1) 함수 정의(관련있는 기능들을 묶어놓고)
//								parameter
//								함수 수행하는데 필요한 재료
//				  return type
//				  결과로 뭐 나오나
//	public static 자료형 함수명(자료형 변수명, 자료형 변수명, ...) {
//		...
//		return 값;
//	}

	// 단순 담배 심부름
	public static void yaDambae() {
		System.out.println("야 10000원 받아서");
		System.out.println("이마트 가서");
		System.out.println("한라산 한 갑 달라고 해라");
		System.out.println("남는돈 과자 하나 사먹고");
		System.out.println("한라산 가져와");
	}

	// 정수 2개 넣으면 그 합을 출력하는 함수
	public static void printSum(int a, int b) {
		System.out.println(a + b);
	}

	// 정수 2개 넣으면 더 큰 숫자 출력하는 함수
	public static void printBigger(int a, int b) {
		System.out.println((a > b) ? a : b);
	}

	// 정수 2개 넣으면 그 곱을 출력하는 함수
	public static void printGob(int a, int b) {
		System.out.println("2개짜리");
		System.out.println(a * b);
	}
	
	// 정수 3개 넣으면 그 곱을 출력하는 함수
	public static void printGob(int a, int b, int c) {
		System.out.println("3개짜리");
		System.out.println(a * b * c);
	}
	
	// 초 -> 1000분의 1초(밀리초) 단위로 바꿔주는 함수
	public static int convertMilliSec(int second) {
		int milliSec = second * 1000;
		return milliSec;
	}
	
	// 정수 하나 넣으면, 홀/짝 구해주는 함수
	public static String getOddEven(int n) {
		return (n % 2 == 1) ? "홀" : "짝";
	}
	
	public static void main(String[] args) throws InterruptedException {
		// 2) 함수 호출(필요할때마다 갖다쓰는)
		// 함수명(값, 값, ...);
		
		int ms = convertMilliSec(3);
		Thread.sleep(ms);
		
		String result = getOddEven(ms);
		System.out.println(result);
		
		System.out.println("-----");
		
		printGob(10, 20);
		printGob(3, 3, 2);
		System.out.println("-----");
		
		printBigger(50, 20);
		printBigger(100, 3333);
		System.out.println("-----");
		
		printSum(20, 30);
		printSum(50, 2);
		System.out.println("-----");
		
		yaDambae();
	}
}