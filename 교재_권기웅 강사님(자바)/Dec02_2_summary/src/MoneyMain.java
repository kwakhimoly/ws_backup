import java.util.Scanner;

public class MoneyMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		
		System.out.print("얼마 : ");
		int 얼마 = k.nextInt();
		
		System.out.print("낸 돈 : ");
		int 낸돈 = k.nextInt();
		
		System.out.println("-----");
		int 거스름돈 = 낸돈 - 얼마;
		
		int 돈 = 50000;
		int 몇개 = 거스름돈 / 돈;
		System.out.printf("%d원짜리 %d개\n", 돈, 몇개);
		
		거스름돈 %= 돈; // 35740
		돈 = 10000;
		몇개 = 거스름돈 / 돈;
		System.out.printf("%d원짜리 %d개\n", 돈, 몇개);

		거스름돈 %= 돈; // 5740
		돈 = 5000;
		몇개 = 거스름돈 / 돈;
		System.out.printf("%d원짜리 %d개\n", 돈, 몇개);
		
		// ...
		
		
	}
}




