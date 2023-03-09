import java.util.Scanner;

public class IMain {

	public static void main(String[] args) {
		
		/*
		 * 콘솔 창에 키보드로 입력할건데
		 * 입력받을 준비 위한 코드
		 */
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("모델명: "); //줄 안 바뀌고 바로 쓸 수 있도록 ln 지우기
		String name=keyboard.next(); //콘솔창에 입력한 글자 가져와서 변수에 담아라
		
		System.out.print("가격: ");
		int price=keyboard.nextInt();
		
		System.out.print("번호: ");
		String number=keyboard.next();
		
		System.out.print("화면 크기: ");
		double inch=keyboard.nextDouble();
		
		System.out.print("약정 종료 여부(True/False로 입력): ");
		boolean contractEnd=keyboard.nextBoolean();
		
		/*
		 * 지금부터 핸드폰 모델명 입력할건데
		 * 그것 좀 저장하게 준비하도록 하는 코드~
		 */
		
		System.out.println("--------");
		System.out.println(name);
		
		System.out.println("--------");
		System.out.println(price);
		
		System.out.println("--------");
		System.out.printf("번호: %s \r\n--------\r\n화면: %.2f\n", number, inch);
		// number, inch 순서 틀리면 안됨
		
		/*System.out.println("--------");
		System.out.printf("%s\n", number);
		
		System.out.println("--------");
		System.out.printf("%.2f인치\n", inch);*/
		
		System.out.println("--------");
		System.out.println(contractEnd);
	}
}
