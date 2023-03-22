// 기본형
//		int
// 참조형
//		배열

// Call by Reference, Call by Value

public class FMain6 {
	public static void test(int a, int[] b, int[] c) {
		System.out.println(a);
		System.out.println(b[0]);
		System.out.println(c[0]);
		a = 100;
		b[0] = 100;
		c = new int[] { 100, 200 };
		System.out.println(a);
		System.out.println(b[0]);
		System.out.println(c[0]);
	}

	public static void main(String[] args) {
		int a = 10;
		int[] b = { 10, 20 };
		int[] c = { 10, 20 };
		test(a, b, c);
		System.out.println(a);
		System.out.println(b[0]);
		System.out.println(c[0]);
	}
}
