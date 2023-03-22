// 반복문
// 		횟수(for) : 239847번 출력
//		조건(while, do-while) : 내일 아침 해 뜰때까지 출력
public class RSMain {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println("ㅋ");
		}
		System.out.println("-----");

		for (int i = 3; i < 6; i++) {
			System.out.println(i);
		}
		System.out.println("-----");
		// 1 ~ 5
		for (int i = 1; i < 6; i++) {
			System.out.println(i);
		}
		System.out.println("-----");
		// 1 3 5 7 9
		for (int i = 1; i < 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("-----");
		// 10 ~ 1
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
		}
		System.out.println("-----");
		// 1 + 2 + 3 + ... + 10
		// Java는 변수 만들고 값 안넣으면 못써
		int a = 0;
		for (int i = 1; i < 11; i++) {
			a += i;
		}
		System.out.println(a);
		System.out.println("-----");

		// 1 + 3 + 5 + ... + 21
		int b = 0;
		for (int i = 1; i < 22; i += 2) {
			b += i;
		}
		System.out.println(b);
		System.out.println("-----");
		// 1 - 2 + 3 - 4 + ... - 10
		int c = 0;
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 1) {
				c += i;
			} else {
				c -= i;
			}
		}
		System.out.println(c);
		System.out.println("-----");
		
		int d = 0;
		for (int i = 1; i < 11; i++) {
			d += (i % 2 == 1) ? i : -i;
		}
		System.out.println(d);
		System.out.println("-----");
		
		int e = 0;
		int ee = -1;
		for (int i = 1; i < 11; i++) {
			ee *= -1;
			e += (i * ee);
		}
		System.out.println(e);
		System.out.println("-----");
		
		// 5!
		int f = 1;
		for (int i = 1; i < 6; i++) {
			f *= i;
		}
		System.out.println(f);
	}
}





