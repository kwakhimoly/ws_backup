import java.util.Scanner;

// 클래스명 중복되면 곤란
//		클래스명 중복 안되게 잘 짓자
//		- 자바에 있는 클래스명 다 외우게요?
//		- 자바는 전세계적으로 작업한거 공유하는데
//		=> 피하지는 못하겠고
public class OMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("품명 : ");		String n = k.next();
		System.out.print("가격 : ");		int p = k.nextInt();
		System.out.print("사이즈 : ");		double s = k.nextDouble();
		Monitor m = new Monitor(n, p, s);
		m.show();
		System.out.println("-----");
		// Scanner sc = new Scanner("HP123", 500000);
	}
}






