import java.util.Random;
import java.util.Scanner;

public class RSMain3 {
	public static void main(String[] args) {
//		1+2+3+..+30=?
		
		int i = 0;
		for(int a= 1; a<31; a++) {
			i += a;
		}
		
		System.out.println(i);
		System.out.println("=========");
		
//		합이 200 되기 전까지만 더하고, 200을 넘는 순간의 숫자 구하기
		int b = 0;
		int ii = 0;
		while (b<200) {
			ii++;
			b += ii;
		}
		System.out.println(b);
		System.out.println(ii);
		
		System.out.println("---------");
		
//		랜덤
		Random r = new Random();
		int x = r.nextInt(10); // 0~(10-1) 사이의 랜덤
		System.out.println(x);
		
//		랜덤한 숫자 출력 4 나오면 그만
		while (x != 4) {
			x=r.nextInt(10);
			System.out.println(x);
		}
		
//		입력 받기, -1 쓰면 그만
		Scanner k = new Scanner(System.in);
		
		System.out.print("뭐: ");
		int z = k.nextInt();
		
		while(z!=-1) {
			System.out.print("뭐: ");
			z = k.nextInt();
			System.out.println(z);
		}
		
		do {
			System.out.println("뭐: ");
			z = k.nextInt();
			System.out.println(z);
		} while (z!=-1);
	}
}
