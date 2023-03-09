
public class FMain_Arr {
	public static void printHab(int a, int b) {
		System.out.println(a + b);
	}

	public static void printHab(int a, int b, int c) {
		System.out.println(a + b + c);
	}
//	 갯수가 다르면 함수명이 같아도 상관 없으니 오버로딩 ㄱㄱ

//	 정수 몇 개를 넣든지 그 곱 출력하는 함수
	public static void printGob(int... num) {
//		System.out.println(num[0]);
		int a = 1;
		for (int n : num) {
			a *= n;
		}
		System.out.println(a);
	}

	public static void main(String[] args) {
		printHab(2, 7);
		printHab(3, 6, 9);
		printGob(2, 3, 4);
	}

}
