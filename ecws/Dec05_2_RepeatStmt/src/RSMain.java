
public class RSMain {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			System.out.println("집 가고 싶다");
		}

		System.out.println("--------");

		for (int j = 3; j < 6; j++) {
			System.out.println(j);
		}

		System.out.println("--------");

		for (int i = 1; i <= 5; i++) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println("");
		System.out.println("--------");

		for (int i = 1; i < 10; i++) {
			if (i % 2 == 1) {
				System.out.print(i);
				System.out.print(" ");
			}
		}
		System.out.println("");
		System.out.println("--------");

//		for (int i = 10; i>0&&i<=10; i--) {
//		i는 10에서 시작하기 때문에 10보다 작다는 조건을 굳이 넣을 필요가 없음
		for (int i = 10; i > 0; i--) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println("");
		System.out.println("--------");

		for (int i = 1; i < 11; i++) {
			System.out.print(i);
			System.out.print(" ");
		}

		System.out.println("");
		System.out.println("--------");

		int a = 0;
//		자바는 변수 만들고 값 안 넣으면 못 씀
		for (int i = 1; i < 11; i++) {
			a += i;
		}
		System.out.println(a);

		System.out.println("--------");

		int b = 0;
		for (int i = 1; i < 22; i += 2) {
			b += i;
		}
		System.out.println(b);

		int c = 0;
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 1) {
				c += i;
			} else {
				c -= i;
			}
		}
		System.out.println(c);

		int d = 1;
		for (int i = 1; i <= 5; i++) {
			d *= i;
		}
		System.out.println(d);
	}
}
