
public class exercise2_3 {
	public static void main(String[] args) {
		
		int 거스름돈 = 75740;
		
		int 돈 = 50000;
		
		int 몇개 = 거스름돈/돈;
		//75740/50000=1.5146 -> int기 때문에 1만 출력 -> 오만원권 1장
		
		System.out.printf("%d원짜리 %d개\n", 돈, 몇개);
		
		거스름돈 %= 돈; //35740
		돈/=5; //10000
		
		몇개 = 거스름돈/돈;
		
		System.out.printf("%d원짜리 %d개\n", 돈, 몇개);
		
		거스름돈 %= 돈; //5740
		돈 = 5000; //5000
		
		몇개 = 거스름돈 / 돈;
		System.out.printf("%d원짜리 %d개\n", 돈, 몇개);
	}	
}
