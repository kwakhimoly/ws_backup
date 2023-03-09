
public class PPSMain2 {

	public static void main(String[] args) {
		int 거스름돈 = 73090;

		int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

		for (int i = 0; i <= money.length - 1; i++) {
			int 돈 = money[i];
			if (돈 == money[i]) {
				int 몇개 = 거스름돈 / 돈;
				System.out.printf("%d원짜리 %d개\n", 돈, 몇개);
				거스름돈 %= 돈;
			}
		}

		System.out.println("============");

		int 거스름돈2 = 73090;
		int 몇개;
		for (int 원 : money) {
			몇개 = 거스름돈2 / 원;
			System.out.printf("%d원짜리 %d개\n", 원, 몇개);
			거스름돈2 %= 원;
		}

		System.out.println("============");

		int 거스름돈3 = 73090;
		int 원3 = 50000;
		int 오 = 5;
		while (true) {
			몇개 = 거스름돈3 / 원3;
			System.out.printf("%d원짜리 %d개\n", 원3, 몇개);
			거스름돈3 %= 원3;
			if (거스름돈3 < 10) {
				break;
			}
			원3 /= 오;
			오 = (오 == 5) ? 2 : 5;
		}

	}
}
