// 뭐가 비슷하다는건지
// 저걸로는 대회가서 털리겠다, 영 별로네...
// 반복문 써야지...

public class PPSMain2 {
	public static void main(String[] args) {
		int 거스름돈 = 73090;
		int 원 = 50000;
		int ㅋ = 5;
		int 몇개;
		while (true) {
			몇개 = 거스름돈 / 원;
			System.out.printf("%d원짜리 %d개\n", 원, 몇개);
			거스름돈 %= 원;
			if (원 == 10) {
				break;
			}
			원 /= ㅋ;
			ㅋ = (ㅋ == 5) ? 2 : 5;
		}

//		int[] 화폐단위 = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
//		int 몇개;
//		for (int 원 : 화폐단위) {
//			몇개 = 거스름돈 / 원;
//			System.out.printf("%d원짜리 %d개\n", 원, 몇개);
//			거스름돈 %= 원;
//		}
	}
}
