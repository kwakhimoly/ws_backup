import java.util.Scanner;

public class docMain {

	public static void main(String[] args) {
		Scanner doc = new Scanner(System.in);

		System.out.print("이름: ");
		String name = doc.next();

		System.out.print("키: ");
		double height = doc.nextDouble();

		System.out.print("체중: ");
		float weight = doc.nextFloat();


		System.out.println("==============");

		double averageWeight = (height - 100) * 0.9;
		System.out.printf("표준체중: %.1fkg\n", averageWeight);

		double fat = (weight / averageWeight) * 100;
		System.out.printf("비만도: %.1f%%\n", fat);

		/*String result = (fat < 120 ? "정상 체중입니다" : "운동하세요");
//		System.out.println(result);
		System.out.printf("%s씨, %s\n", name, result);*/

		System.out.printf("%s씨, %s\n", name, (fat < 120 ? "정상 체중입니다" : "운동하세요"));
//		->변수 일회용으로 써질 것 같으면(result) 그냥 바로 집어넣기
		
		
		System.out.printf("프로그램을 종료하시려면 0을 입력하세요: ");
//		-> 뭘 쓰면 프로그램이 종료됨
		doc.next(); // 변수를 활용할 이유가 없으므로 굳이 변수 부여(String s =) 하지 않음
		
	}

}
