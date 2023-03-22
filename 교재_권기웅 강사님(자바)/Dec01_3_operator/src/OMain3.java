// <<
//		shift연산자
//		3 << 1
//		1) 3을 2진수로 : 11
//		2) 왼쪽으로 1번 밀고 빈자리 0 : 110
//		3) 110을 다시 10진수로 바꾸면 : 6
//		
//		다중선택용...
// ---------------------------------
// 연산자
//		단항 !
//		2항(대부분)
//		3항
//			조건식 ? 참일때값 : 땡일때값
public class OMain3 {
	public static void main(String[] args) {
		int a = 3 << 1;
		System.out.println(a);
		
		int age = 4;
		// 나이가 20살이상이면 어서오세요, 안되면 저리가
		String say = (age >= 20) ? "어서오세요" : "저리가";
		System.out.println(say);
	}
}