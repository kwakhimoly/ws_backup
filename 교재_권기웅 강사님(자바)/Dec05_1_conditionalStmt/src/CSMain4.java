// 주차장		1 << 0 = 1
// 와이파이		1 << 1 = 2
// 흡연실		1 << 2 = 4
// 24시간		1 << 3 = 8

public class CSMain4 {
	public static void main(String[] args) {
		int option = 7;

		if (option >= (1 << 3)) {
			System.out.println("24시간");
			option -= (1 << 3);
		}
		if (option >= (1 << 2)) {
			System.out.println("흡연실");
			option -= (1 << 2);
		}
		if (option >= (1 << 1)) {
			System.out.println("와이파이");
			option -= (1 << 1);
		}
		if (option >= (1 << 0)) {
			System.out.println("주차장");
			option -= (1 << 0);
		}
	}
}
