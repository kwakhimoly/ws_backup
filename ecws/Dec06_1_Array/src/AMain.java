
public class AMain {
	public static void main(String[] args) {
//		배열 작성시, []는 자료명 뒤에 붙여도 배열명 뒤에 붙여도 상관 없음
//		만들 때 칸 수 넣은 후, 변경 불가
//		배열 갯수 초과한 순번 소환 시 에러 ex) array.length = 4, array[4] -> 에러
//		만들 때 변수 몇개 넣을지 모르는 경우?

		int[] eng = new int[4]; // 옛날 방식
		eng[0] = 100;
		eng[1] = 28;
		eng[2] = 66;
		eng[3] = 87;

		int[] mat = new int[] { 95, 81, 100, 88 }; // 과도기

		int[] kor = { 100, 80, 33, 78 }; // 요즘 추세
		System.out.println(kor[1]); // 80. 배열 순서는 0부터 시작하기 때문
		System.out.println(kor.length); // 배열 갯수가 몇개인지

		System.out.println("-----------");

		for (int i = 0; i < kor.length; i++) {
			System.out.println(kor[i]);
		}
	}
}
