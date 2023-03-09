
public class CSMain3 {
	public static void main(String[] args) {
//	다중선택 문제
//		주차장 1 << 0 = 1
//		와이파이 1 << 1 = 2
//		흡연실 1 << 2 = 4
//		24시간 1 << 3 = 8

		int[] option = { 1 << 3, 1 << 2, 1 << 1, 1 << 0 };

		int choose = 14;
		int sum = option[0] + option[1] + option[2] + option[3];

		if (choose >= option[0]) {
			System.out.println("24시간");
			choose -= option[0];
		}
		if (choose >= option[1]) {
			System.out.println("흡연실");
			choose -= option[1];
		}
		if (choose >= option[2]) {
			System.out.println("와이파이");
			choose -= option[2];
		}
		if (choose >= option[3]) {
			System.out.println("주차장");
			choose -= option[3];
		}
	}
}
