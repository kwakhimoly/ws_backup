
public class RSMain2 {
	public static void main(String[] args) {
		for (int a = 2; a <= 3; a++) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d x %d = %d\n", a, i, a * i);
			}
			System.out.println("--------");
		}

		System.out.println("=====================");

		for (int i = 1; i <= 9; i++) {
			for (int a = 2; a <= 9; a++) {
				System.out.printf("%d x %d = %d\t", a, i, a * i);
			}
			System.out.println();
		}

		System.out.println("=====================");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}

		System.out.println("=====================");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (5 - i); j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}

		System.out.println("=====================");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((i == j) ? "ㅋ" : "  ");
			}
			System.out.println();
		}

		System.out.println("=====================");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			System.out.println("ㅋ");
		}

		System.out.println("=====================");

		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j <= i * 2; j++) {
					System.out.print("ㅋ");
				}
				System.out.println();
			}
			if (i % 2 == 1) {
				for (int k = 0; k <= i * 2; k++) {
					System.out.print("ㅎ");
				}
				System.out.println();
			}
		}

		System.out.println("=====================");
		
		
		String a;
		int i;
		int j;
		for (i = 0; i < 5; i++) {
			a = i % 2 == 0 ? "ㅋ" : "ㅎ";
			for (j = 0; j <= i * 2; j++) {
				System.out.print(a);
			}
			System.out.println();
		}
		
		System.out.println("=====================");
		
		for(i = 0; i<5; i++) {
			for(j=0; j<=5-i; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println();
		}
	}
}
