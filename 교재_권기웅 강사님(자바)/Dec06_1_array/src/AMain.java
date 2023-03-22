// 변수 : 데이터 임시로 저장
//		변수 1 : 데이터 1
// 빅데이터 분석 -> 100년치 날씨 받아다가 날씨 예측
//		변수 1 : 데이터 n => 배열

// 만들때 칸 수 넣고, 변경불가
//		만들때 칸 수 모르면?
//		활용도 떨어질텐데...
public class AMain {
	public static void main(String[] args) {
		// 오리지널
		int[] eng = new int[4];
		eng[0] = 90;
		eng[1] = 30;
		eng[2] = 50;
		eng[3] = 66;
				
		// 과도기
		int[] mat = new int[] {50, 90};
		
		// 학생 3명 국어점수
		// int kor[];
		int[] kor = {100, 90, 80}; // 최신
		
		System.out.println(kor[1]); // 0번부터
		System.out.println(kor.length); // 총 몇개
		System.out.println("-----");
		for (int i = 0; i < kor.length; i++) {
			System.out.println(kor[i]);
		}
		
	}
}




