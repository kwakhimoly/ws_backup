
public class FMain5 {
	// 정수 2개 넣으면 그 합을 출력하는 함수
	public static void printHab(int a, int b) {
		System.out.println(a + b);
	}

	// 정수 3개짜리도 되게 해줘
	public static void printHab(int a, int b, int c) {
		System.out.println(a + b + c);
	}
	
	// 정수 몇개를 넣든지 그 곱 출력하는 함수
	public static void printGob(int... no) {
		// no는 배열취급
		// System.out.println(no[0]);
		int a = 1;
		for (int n : no) {
			a *= n;
		}
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		printGob(10);
		printGob(20, 30);
		printGob(1, 3, 2);
		
		printHab(30, 2);
		printHab(30, 2, 21);
	}
}


