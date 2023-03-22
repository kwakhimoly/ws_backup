import java.util.Random;
import java.util.Scanner;

public class RSMain3 {
	public static void main(String[] args) {
		// 1 + 2 + ... + 30 = ?
		// 30번 돌면 됨
		int a = 0;
		for (int i = 1; i < 31; i++) {
			a += i;
		}
		System.out.println(a);
		System.out.println("-----");
		// 1 + 2 + ... + ? >= 200
		// 횟수 모르겠다 : 몇 번 돌아야...??
		// 조건이 명확 : 더하다가 200넘으면 그만
		int b = 0;
		int i = 0;
		while (b < 200) {
			i++;
			b += i;
		}
		System.out.println(b);
		System.out.println(i);
		System.out.println("----");
		
		// 랜덤한 숫자 출력 4나오면 그만
		Random r = new Random();
		int x = r.nextInt(10); // 0 ~ (10-1)까지 랜덤
		System.out.println(x);
		while (x != 4) {
			x = r.nextInt(10);
			System.out.println(x);
		}
		
		// 입력받기, -1쓰면 그만
		Scanner k = new Scanner(System.in);
		System.out.print("뭐 : ");
		int z = k.nextInt();
		System.out.println(z);

//		실행부터 : 무슨일이 있어도 한번은 보장
		do {
			System.out.print("뭐 : ");
			z = k.nextInt();
			System.out.println(z);
		} while (z != -1);
		
//		검사부터 : 한번도 실행 안될수도
//		while (z != -1) {
//			System.out.print("뭐 : ");
//			z = k.nextInt();
//			System.out.println(z);
//		}
		
	}
}




