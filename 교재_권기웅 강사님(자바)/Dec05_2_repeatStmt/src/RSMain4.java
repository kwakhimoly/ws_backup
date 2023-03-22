import java.util.Random;
import java.util.Scanner;

// for, while, do-while(ㅎ)
// 반복문 제어
//		break : 반복문 종료
//		continue : 강제반복, 턴 종료
public class RSMain4 {
	public static void main(String[] args) {
		// 1 ~ 30까지 출력
		for (int i = 1; i < 31; i++) {
			if (i % 2 == 0) {
				// break;
				continue; // 12,13,14안하고 바로 8로
			}
			System.out.println(i);
		}
		System.out.println("-----");
		
		// 4나올때까지 랜덤한 숫자 출력
		Random r = new Random();
		int x;
		while (true) {
			x = r.nextInt(10);
			System.out.println(x);
			if (x == 4) {
				break;
			}
		}
		System.out.println("-----");
	
		a : for (int i = 0; i < 10; i++) {
			haha : for (int j = 0; j < 10; j++) {
				if (j == 2) {
					break a; // 중복되면 가까운거, 이름주면 그거
				}
				System.out.println(i);
				System.out.println(j);
				System.out.println();
			}
		}
		
		
		
	}
}




