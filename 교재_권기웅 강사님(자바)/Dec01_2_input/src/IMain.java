import java.util.Scanner;

public class IMain {
	public static void main(String[] args) {
		// 콘솔창에 키보드로 입력할건데 입력받을 준비
		Scanner keyboardHaha = new Scanner(System.in);
		
		System.out.print("모델명 : ");
		//            콘솔창에 입력한 글자 가져와서
		String name = keyboardHaha.next();
		
		System.out.print("가격 : ");
		//			콘솔창에 입력한 정수 가져와서
		int price = keyboardHaha.nextInt();
		
		System.out.print("번호 : ");
		String no = keyboardHaha.next();
		
		System.out.print("화면크기 : ");
		double size = keyboardHaha.nextDouble();
		
		System.out.print("약정 끝 : ");
		boolean end = keyboardHaha.nextBoolean();
		
		System.out.println("------");
		System.out.println(name);
		System.out.println(price);
		// System.out.printf("형식", 값, 값, 값, ...);
		System.out.printf("번호 : %s, 화면 : %.1f\n", no, size);
		System.out.println(end);
	}
}







