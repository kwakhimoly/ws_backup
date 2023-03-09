import java.util.Scanner;

public class exercise {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("바퀴 둘레(m): ");
		double wheel = k.nextDouble();

		System.out.print("앞 기어 톱니 수: ");
		int front = k.nextInt();

		System.out.print("뒷 기어 톱니 수: ");
		int back = k.nextInt();

		System.out.print("발 구른 횟수: ");
//		int foot = k.nextInt();
		double foot = k.nextDouble();

		System.out.println("=================");

//		double way = (wheel / (front * back) * foot); -> 틀렸대요~~

//		double ratio = front/(double)back;
//		front/back -> 기어비 계산
		
//		double way = wheel * (front/(double)back * foot) / 1000;
//		-> 기어비는 일회용 변수니까 바로 안에 집어 넣기
		System.out.printf("이동거리는 %.2fkm입니다.", wheel * (front/(double)back * foot) / 1000);
//		-> way는 다시 사용되지 않을테니 바로 안에 집어 넣기
	}

}
