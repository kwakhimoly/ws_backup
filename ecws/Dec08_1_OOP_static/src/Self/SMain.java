package Self;

import java.util.Scanner;

public class SMain {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		Movie bones = new Movie();
		System.out.print("제목: ");
		bones.title = k.next();
		System.out.print("개봉날짜: ");
		bones.yearMonthDay = k.nextInt();
		System.out.print("별점: ");
		bones.rate = k.nextDouble();
		System.out.print("또 볼 생각?: ");
		bones.again = k.nextBoolean();
		System.out.print("장소: ");
		bones.where = k.next();

		bones.printInfo();

		System.out.println();

		Movie fH = new Movie();
		fH.title = "Fraces Ha";
		fH.yearMonthDay = 20131112;
		fH.rate = 3.5;
		fH.again = true;
		fH.where = "At home";

		fH.printInfo();
	}

}
