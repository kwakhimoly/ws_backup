import java.util.Scanner;

public class BMITestMainAnswer {

	public static String getName() {
		Scanner k = new Scanner(System.in);
		System.out.print("이름: ");
		String n = k.next();
		return n;
	}

	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("키: ");
		double h = k.nextDouble();
		return (h < 3) ? getHeight() : h;
	}

	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("몸무게: ");
		double w = k.nextDouble();
		return w;
	}

	public static double calcBMI(double w, double h) {
		double b = w / ((h/100)*(h/100));
		return b;
	}

	public static String judge(double b) {
		if (b >= 35) {
			return "고도비만";
		} else if (b >= 30) {
			return "중도비만";
		} else if (b >= 25) {
			return "경도 비만";
		} else if (b >= 23) {
			return "과체중";
		} else if (b >= 18.5) {
			return "정상";
		} else {
			return "저체중";
		}
	}
	
	public static void printResult(String n, double b, String r) {
		System.out.printf("BMI : %.1f\n", b);
		System.out.printf("%s씨는 %s\n", n, r);
	}

	public static void main(String[] args) {
	
	String name = getName();
	double height = getHeight();
	double weight = getWeight();
	double bmi = calcBMI(weight, height);
	String result = judge(bmi);
	printResult(name, bmi, result);

	}
}
