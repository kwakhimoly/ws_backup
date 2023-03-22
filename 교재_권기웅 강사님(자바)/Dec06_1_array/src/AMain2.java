public class AMain2 {
	public static void main(String[] args) {
		// int[] kor = { 100, 90, 80 };
		// kor[0] : 100
		int[][] score = { { 100, 90, 80 }, { 90, 50, 60 }, { 12, 33, 12 } };
		// score[0] : {100, 90, 80}
		// score[0][1] : 90
		System.out.println(score[0]);
		System.out.println(score[0][1]);
		// 첫번째 학생의 영어점수
		for (int[] is : score) {
			for (int is2 : is) {
				System.out.println(is2);
			}
		}
	}
}
