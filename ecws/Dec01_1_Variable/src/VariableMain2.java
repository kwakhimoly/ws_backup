
public class VariableMain2 {
	public static void main(String[] args) {
		/* 
		 * 핸드폰 모델명			
		 * 가격
		 * 전화번호
		 * 화면크기
		 * 약정
		 */
		
		String phoneModelName = "IPhone 13 Pro";
		int phonePrice = 1300000;
		String phoneNumber = "010-1234-5678";
		double phoneScreen = 8.2;
		int phoneEnd = 3;
		boolean end = false;
		
		System.out.println(phoneModelName);
		System.out.printf("%d원\n", phonePrice);
		System.out.printf("번호: %s", phoneNumber);
		System.out.printf("\n%.2f인치\n", phoneScreen);
		System.out.printf("%d년\n", phoneEnd);
		System.out.println(end);
			
	}
}
