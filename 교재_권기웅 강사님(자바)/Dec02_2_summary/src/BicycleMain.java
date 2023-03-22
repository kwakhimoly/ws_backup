import java.util.Scanner;

public class BicycleMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		
		System.out.print("바퀴둘레 : ");
		double 바퀴둘레 = k.nextDouble();
		
		System.out.print("앞 기어 톱니 수 : ");
		int 앞톱니 = k.nextInt();
		
		System.out.print("뒷 기어 톱니 수 : ");
		int 뒤톱니 = k.nextInt();
		
		System.out.print("발 구른 횟수 : ");
		double 발구른횟수 = k.nextDouble();
		System.out.println("-----");
		
		double 이동거리 = 바퀴둘레 * (발구른횟수 * (앞톱니 / (double)뒤톱니));
		System.out.println(이동거리);
	}
}



