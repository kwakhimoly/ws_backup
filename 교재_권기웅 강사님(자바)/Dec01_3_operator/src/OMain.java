import java.util.Scanner;

// 형변환(type casting)
//		자료형 바꾸기
//		(자료형) 값
//			=> 이클립스써서 해결하면 될 일

// 연산자(operator)
//		= 대입연산자
//			우항에 있는거를 좌항에 넣어라
//			무조건 마지막

//		+ - * / %(나머지) 산술연산자 

//		+= -= *= /= %= 산술+대입연산자

//		++ --
public class OMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("x : ");
		int xx = k.nextInt();

		System.out.print("y : ");
		int yy = k.nextInt();

		System.out.println("-----");
		System.out.printf("x는 %d, y는 %d\n", xx, yy);
		
		int a = xx + yy;
		int b = xx - yy;
		int c = xx * yy;
		int d = xx / yy;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println("-----");
		
		String s = "ㅋ";
		// 어떤 데이터든지 + String 하면
		// 붙여서 String으로 만들어 줌
		String e = xx + s;
		System.out.println(e);
		System.out.println("-----");
		
		// Java에서 int끼리 계산 -> 결과가 int
		// Java에서 int랑 double랑 계산 -> double
		// Java에서 double끼리 계산 -> double

		// 나누기할때 소수점 살리려면 
		// 두 항중에 하나이상 double이어야
		double f = xx / (double) yy;
		System.out.println(f);
		
		int g = xx % yy;
		System.out.println(g);
		System.out.println("-----");
		
		// xx = xx + 3;
		xx += 3;
		System.out.println(xx);
	
		yy -= 2;
		System.out.println(yy);
		System.out.println("-----");
	
		// xx = xx + 1;
		// xx += 1;
		xx++;
		System.out.println(xx);
	}
}











