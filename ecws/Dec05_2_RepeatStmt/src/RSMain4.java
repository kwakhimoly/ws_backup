import java.util.Random;
import java.util.Scanner;

public class RSMain4 {
	public static void main(String[] args) {
//		1~30까지 출력
		for (int i = 1; i < 31; i++) {
			if (i % 2 == 0) {
//				break;
				continue;
			}
			System.out.print(i);
		}
		System.out.println();
		System.out.println("-------------");

//		4 나올 때까지 랜덤한 숫자 출력
		Random r = new Random();

		int x;
		while (true) {
			x = r.nextInt(10);
			System.out.println(x);
			if (x == 4) {
				break;
			}
		}

//		-1 나올 때까지 계속 입력 받기
		Scanner k = new Scanner(System.in);

		int y;
		System.out.println("y 값을 입력하세요.");
		while (true) {
			y = k.nextInt();
			switch (y) {
			case -1:
				System.out.println("종료");
				break;
//				switch의 break이기 때문에 조건 충족되도 while문이 종료되지 않음
			default:
				System.out.printf("y는 %d\n", y);
				continue;
			}
			break;
//			while문의 break, switch 조건 충족되면 종료시킴
		}

		a: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 2) {
					break a;
//					중복되면 가까운 거 break
//					a라는 이름이 붙여진 상황에선 a break
				}
				System.out.println(i);
				System.out.println(j);
				System.out.println();
			}
		}
	}
}
