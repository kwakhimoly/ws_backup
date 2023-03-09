import java.util.Scanner;

public class CSMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("중간고사 점수: ");
		double mid = k.nextDouble();
		System.out.print("기말고사 점수: ");
		double fin = k.nextDouble();

		double avg = (mid + fin) / 2;

		System.out.printf("평균 점수는 %.2f점입니다.\n", avg);
		/*
		 * String good = (avg>80 ? "잘했다." : ""); System.out.println(good);
		 */

		/*
		 * if (avg >= 80) { System.out.println("잘했다"); } else { System.out.println("야");
		 * if (avg >= 70) { System.out.println("노력좀"); } }
		 */

		if (avg >= 90) {
			System.out.println("수");
		} else if (avg >= 80) {
			System.out.println("우");
		} else if (avg >= 70) {
			System.out.println("미");
		} else if (avg >= 60) {
			System.out.println("양");
		} else {
			System.out.println("가");
		}

	}
}
