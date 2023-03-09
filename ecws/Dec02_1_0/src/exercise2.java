import java.util.Scanner;

public class exercise2 {
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
		
		int mon5 = money/50000;
		System.out.printf("50000원권: %d장\n", mon5);
		
		int mon1 = money/10000;
		System.out.printf("10000원권: %d장\n", mon1 - mon5*5);
	
/*		실패!
		int mo5 = (money-(mon1*10000+mon5*50000))/5000;
		System.out.printf("5000원권: %d장\n", mo5);*/
		
		int mo5 = money/5000;
		System.out.printf("5000원권: %d장\n", mo5-mon1*2);
		
		int mo1 = money/1000;
		System.out.printf("1000원권: %d장\n", mo1-mo5*5);
		
		int m5 = money/500;
		System.out.printf("500원권: %d개\n", m5 - mo1*2);
		
		int m1 = money/100;
		System.out.printf("100원권: %d개\n", m1 - m5*5);
		
		int co50 = money/50;
		System.out.printf("50원권: %d개\n", co50-m1*2);
		
		int co10 = money/10;
		System.out.printf("10원권: %d개", co10-co50*5);
		
	}
}
