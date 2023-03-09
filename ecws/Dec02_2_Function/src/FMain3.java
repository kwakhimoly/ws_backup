import java.util.Scanner;

public class FMain3 {
	public static void main(String[] args) {
		int asd = getOnlyOdd();
		System.out.println("-----");
		System.out.printf("x는 %d\n", asd);
	}
	
	public static int getOnlyOdd() {
		Scanner k = new Scanner(System.in);
		System.out.print("x: ");
		int xx = k.nextInt();
		return (xx % 2 == 1) ? xx : getOnlyOdd();

	}
}


