
public class FMain_Arr2 {

	public static void test(int a, int[] b, int[] c) {
//		함수 test 안에서만 쓰이는 a,b
		System.out.println(a);
		System.out.println(b[0]);
		System.out.println(c[0]);
		a = 100;
//		test의 변수 a 값을 100으로 지정
		b[0] = 100;
//		main의 배열 b의 0번째 값을 100으로 지정
		c = new int[] { 100, 200 };
//		아예 새로운 배열로 생성한 건 가봐요?? 이름만 같은..?
		System.out.println(a); // call by value
		System.out.println(b[0]); // call by reference -> 원본 자체(배열 b[0]의 값)의 변화가 일어난 후
		System.out.println(c[0]);
	}

	public static void main(String[] args) {
		int a = 10;
		int[] b = { 10, 20 };
		int[] c = { 10, 20 };
//		main 메소드 안에서만 쓰일 수 있는 변수 a,b
		test(a, b, c);
//		test의 a,b 값을 main의 a,b로 지정
		System.out.println(a);
		System.out.println(b[0]);
		System.out.println(c[0]);
//			println(b)할 경우
//			b가 출력되는 게 아니라, 배열 b 속에 속한 값들이 저장된 위치 출력
//			배열은 참조형이기 때문
	}
}
