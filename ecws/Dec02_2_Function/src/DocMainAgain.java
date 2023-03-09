import java.util.Scanner;
//개갓이 실패
public class DocMainAgain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("이름: ");
		String name = k.next();
		
		double h = k.nextDouble();
		cal(h);
		double w = k.nextDouble();
		cal2(w);
	}
	
	public static double cal(double h) {
		Scanner k = new Scanner(System.in);
		
		System.out.print("키: ");
		double height = h;
		
		return height;
	}
	
	public static double cal2(double w) {
		Scanner k = new Scanner(System.in);
		
		System.out.print("체중: ");
		double weight = w;
		
		return weight;
	}
}
