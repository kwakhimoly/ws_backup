import java.util.Scanner;

public class exercise2_2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		
		System.out.print("구매한 금액 : ");
		int price = k.nextInt();
		
		System.out.print("지불한 금액 : ");
		int buy = k.nextInt();
		
		System.out.println("=================");
		
		int money = buy-price;
		System.out.printf("거스름돈: %d원\n", money);
		
		System.out.println("=================");
		
		System.out.printf("50000원권: %d장\n", money/50000);
		System.out.printf("10000원권: %d장\n", money%50000/10000);
		System.out.printf("5000원권: %d장\n", money/5000%2);
		System.out.printf("1000원권: %d장\n", money%5000/1000);
		System.out.printf("500원권: %d개\n", money/500%2);
		System.out.printf("100원권: %d개\n", money%500/100);
		System.out.printf("50원권: %d개\n", money/50%2);
		System.out.printf("10원권: %d개\n", money%50/10);
	}
}
