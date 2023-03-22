import java.util.Scanner;

public class BCMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("이름 : ");
		String name = k.next();
		
		System.out.print("키 : ");
		double height = k.nextDouble();
		
		System.out.print("몸무게 : ");
		double weight = k.nextDouble();
		
		System.out.println("-----");
		
		double stdWeight = (height - 100) * 0.9;
		double bimando = (weight / stdWeight) * 100;
		
		System.out.printf("표준체중 : %.1fkg\n", stdWeight);
		System.out.printf("비만도 : %.1f%%\n", bimando);
		System.out.printf("%s씨는 %s\n", name, ((bimando > 120) ? "운동 좀" : "정상"));
		
		System.out.print("끄고 싶으면 뭐라도 쓰시오 : ");
		k.next();
	}	
}





