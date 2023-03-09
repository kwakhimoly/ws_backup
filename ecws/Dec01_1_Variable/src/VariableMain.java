
public class VariableMain {
	public static void main(String[] args) {
		// 사람 나이 = 25살 이라는 데이터를 임시 보관할 경우
		int age; // 변수 만들기 = 선언
		age = 25; // 변수에 값 넣기 = 대입
		System.out.println(age);
		System.out.println(age);

		// 사람 시력 1.5라는 데이터를 임시 보관
		double sight = 1.5; // 선언 + 대입
		float eye = 1.5f;
		System.out.println(sight);
		System.out.println(eye);
		
		double d = 'c'; // 2진수로 알아들어서 출력 가능 -> 쫌 굳이..? 
		System.out.println(d);
		
		// 웩이라는 글자 저장
		char laugh = '웩';
		char engLaugh = 'p';
		System.out.println(laugh);
		System.out.println(engLaugh);
		
		// 사람 이름이 홍길동 저장
		String name="홍길동";
		System.out.println(name);
		
		// 지금 추워요? 를 저장
				/*
				String freezing = "True";
				System.out.println(freezing);
				 */
		boolean cold = true;
		System.out.println(cold);
		boolean warm = false;
		System.out.println(warm);
	}

}
