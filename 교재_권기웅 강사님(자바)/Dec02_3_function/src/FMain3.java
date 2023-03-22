import java.util.Scanner;

// recursive : 원하는 거 나올때까지(입력) 물고 늘어지게
public class FMain3 {
	public static int getOnlyOdd() {
		Scanner k = new Scanner(System.in);
		System.out.print("x : ");
		int xxx = k.nextInt();
		return (xxx % 2 == 1) ? xxx : getOnlyOdd();
	}
	
	public static void main(String[] args) {
		int asd = getOnlyOdd();
		System.out.println("-----");
		System.out.printf("x는 %d\n", asd);
	}
}
