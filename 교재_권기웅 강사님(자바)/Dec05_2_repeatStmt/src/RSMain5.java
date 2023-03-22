// 원래 : java -jar 파일명
// java -jar 파일명 aaa bbb ccc ...로 실행하면
//	aaa bbb ccc ...가 저 args쪽으로
public class RSMain5 {
	public static void main(String[] args) {
		for (String s : args) {
			System.out.println(s);
		}
		System.out.println("-----");
		
		double[] temp = { -3, -10.5, 2, 12 };

		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
		System.out.println("-----");
		
		for (int i = 0; i < temp.length; i++) {
			double d = temp[i];
			System.out.println(d);
		}
		System.out.println("-----");
		
		// i부분이 없어서 활용도는 떨어짐
		// 순서 조절이 불가능
		for (double d : temp) {
			System.out.println(d);
		}
		
		// 횟수 for
		// 배열탐색용 for-each
		// 조건 while, do-while
		
	}
}
