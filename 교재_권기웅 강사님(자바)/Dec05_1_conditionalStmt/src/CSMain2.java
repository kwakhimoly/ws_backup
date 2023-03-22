import java.util.Scanner;

public class CSMain2 {
	public static String getName() {
		Scanner k = new Scanner(System.in);
		System.out.print("이름 : ");
		return k.next();
	}

	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("키 : ");
		double h = k.nextDouble();
		return (h < 3) ? h : getHeight();
	}

	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("몸무게 : ");
		return k.nextDouble();
	}

	public static double calcBMI(double h, double w) {
		return w / (h * h);
	}

	public static String judge(double b) {
		if (b >= 35) {
			return "고도 비만";
		} else if (b >= 30) {
			return "중도 비만";
		} else if (b >= 25) {
			return "경도 비만";
		} else if (b >= 23) {
			return "과체중";
		} else if (b >= 18.5) {
			return "정상";
		} 
		return "저체중";
	}

	public static void printResult(String n, double b, String r) {
		System.out.printf("BMI : %.1f\n", b);
		System.out.printf("%s씨는 %s\n", n, r);
	}
	
	public static void main(String[] args) {
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		System.out.println("-----");
		double bmi = calcBMI(height, weight);
		String result = judge(bmi);
		printResult(name, bmi, result);
	}
}



