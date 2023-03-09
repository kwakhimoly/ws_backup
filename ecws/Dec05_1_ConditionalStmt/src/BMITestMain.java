import java.util.Scanner;

public class BMITestMain {

//	또 개갓이 실패 

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		double height = getHeight();
		double weight = getWeight();
		double bmi = weight / ((height / 100) * (height / 100));

		System.out.printf("BMI : %.1f\n", bmi);

		if (bmi <= 18.5) {
			System.out.println("저체중입니다.");
		} else if (bmi <= 22.9) {
			System.out.println("정상입니다.");
		} else if (bmi <= 24.9) {
			System.out.println("과체중입니다.");
		} else {
			System.out.println("비만입니다.");
		}
	}

	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("키 : ");
		double h = k.nextDouble();

		return h < 3 ? getHeight() : h;
	}

	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("몸무게 : ");
		double w = k.nextDouble();

		return w;
	}

}
