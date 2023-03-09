import java.util.Scanner;

public class OMain {

	public static void main(String[] args) {
		Scanner function = new Scanner(System.in);

		System.out.print("x: ");
		int x = function.nextInt();

		System.out.print("y: ");
		int y = function.nextInt();

		System.out.println("============");
		System.out.printf("x는 %d, y는 %d\n", x, y);

		int a = x + y;
		int b = x - y;
		int c = x * y;
		int d = x / y;
		int e = x % y;

		// Java에서 int끼리 계산하면 결과도 int

		System.out.println("============");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);

		System.out.println("============");

		String s = "o0o";
		// 어떤 데이터든지 + String을 하게 되면
		// 붙여서 String 으로 만들어줌
		String f = x + s;
		System.out.println(f);

		System.out.println("============");

		double g = x / (double) y;
		System.out.println(g);
		
		System.out.println("============");
		
		int h = x + 3;
		System.out.println(h);

		x += 4; // x = x + 3;와 동일
		System.out.println(x);
	
		System.out.println("============");
		
		++x;
		System.out.println(x);
	}
}
