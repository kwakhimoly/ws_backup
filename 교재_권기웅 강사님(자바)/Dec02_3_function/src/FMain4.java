import java.util.Scanner;

public class FMain4 {
	public static String getName() {
		Scanner k = new Scanner(System.in);
		System.out.print("이름 : ");
		return k.next();
	}

	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("키 : ");
		double h = k.nextDouble();
		return (h < 3) ? getHeight() : h;
	}

	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("몸무게 : ");
		return k.nextDouble();
	}

	public static double getStdWeight(double h) {
		return (h - 100) * 0.9;
	}

	public static double getBimando(double w, double sw) {
		return (w / sw) * 100;
	}
	
	public static String getResult(double b) {
		return (b > 120) ? "운동 좀" : "정상";
	}
	
	public static void showResult(String n, double sw, double b, String r) {
		System.out.printf("표준체중 : %.1fkg\n", sw);
		System.out.printf("비만도 : %.1f%%\n", b);
		System.out.printf("%s씨는 %s\n", n, r);
	}

	public static void main(String[] args) {
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		System.out.println("-----");
		double stdWeight = getStdWeight(height);
		double bimando = getBimando(weight, stdWeight);
		String result = getResult(bimando);
		showResult(name, stdWeight, bimando, result);
	}
}
