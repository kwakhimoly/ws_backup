import java.util.Scanner;

public class DocMainAns {

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
		// m 단위 쓰지말고(1.8m) cm 단위 써라(180cm)
	}

	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("체중: ");
		return k.nextDouble();
	}

	public static double getStdWeight(double h) {
		return (h - 100) * 0.9;
	}

	public static double getBimand(double w, double sw) {
		return (w / sw) * 100;
	}

	public static String getResult(double b) {
		return (b > 120) ? "운동 하세요" : "정상 체중입니다";
	}

	public static void showResult(String n, double sw, double b, String r) {
		System.out.printf("표준체중: %.1fkg\n", sw);
		System.out.printf("비만도: %.1f%%\n", b);
		System.out.printf("%s씨는 %s\n", n, r);
	}

	public static void main(String[] args) {
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		
		System.out.println("-----------");
		
		double stdWeight = getStdWeight(height);
		double bimando = getBimand(weight, stdWeight);
		String result = getResult(bimando);
		
		showResult(name, stdWeight, bimando, result);
	}
}
