
public class AMain2 {
	public static void main(String[] args) {
		int[] kor = { 100, 98, 79 };
//		kor[0] = 100

		
		// 2차원 배열 score
		int[][] score = { { 100, 98, 30 }, { 23, 50, 60 }, { 69, 46, 80 } };
//		score[0] = {100, 98, 30} -> 0번째 값으로 배열이 출력
//		score[0][1] = 98
		
		System.out.println(score[0]);
		System.out.println(score[0][1]);
		for (int[] is : score) {
			for (int is2 : is) {
				System.out.println(is2);
			}
		}
		// 바깥 for문 -> 배열 속 배열 소환
		// 안쪽 for문 -> 배열 속 배열의 값 소환
	}
}
