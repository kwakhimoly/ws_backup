import java.util.Iterator;

public class RSMain2 {
	public static void main(String[] args) {
		for (int dan = 2; dan <= 9; dan++) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d x %d = %d\n", dan, i, dan * i);
			}
		}
		System.out.println("----");

		for (int i = 1; i <= 9; i++) {
			for (int dan = 2; dan <= 9; dan++) {
				System.out.printf("%d x %d = %d\t", dan, i, dan * i);
			}
			System.out.println();
		}
		System.out.println("-----");
		// ㅋㅋㅋㅋㅋ
		// ㅋㅋㅋㅋㅋ
		// ㅋㅋㅋㅋㅋ
		// ㅋㅋㅋㅋㅋ
		// ㅋㅋㅋㅋㅋ
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}
		System.out.println("-----");
		// ㅋ
		// ㅋㅋ
		// ㅋㅋㅋ
		// ㅋㅋㅋㅋ
		// ㅋㅋㅋㅋㅋ
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}
		System.out.println("-----");
		// ㅋㅋㅋㅋㅋ
		// ㅋㅋㅋㅋ
		// ㅋㅋㅋ
		// ㅋㅋ
		// ㅋ
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (5 - i); j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}
		System.out.println("-----");
		// ㅋ
		//   ㅋ
		//     ㅋ
		//       ㅋ
		//         ㅋ
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			System.out.println("ㅋ");
		}
		System.out.println("-----");
		// ㅋ
		// ㅎㅎㅎ
		// ㅋㅋㅋㅋㅋ
		// ㅎㅎㅎㅎㅎㅎㅎ
		// ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
		String c;
		for (int i = 0; i < 5; i++) {
			c = (i % 2 == 1) ? "ㅎ" : "ㅋ";
			for (int j = 0; j <= (i * 2); j++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}





