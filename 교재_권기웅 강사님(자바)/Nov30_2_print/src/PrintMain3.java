// 글자데이터 : "값"
// 숫자데이터 : 값

// 특수문자
//		%d : 10진수(decimal)데이터 들어갈 자리
//		%05d : 0채워서 무조건 5자리로
//		%f : 실수(float)데이터 들어갈 자리
//		%.3f : 소수점 이하 3자리로(반올림)
//		%s : 글자(String)데이터 들어갈 자리
//		%% : %
public class PrintMain3 {
	public static void main(String[] args) {
		// System.out.printf("형식", 데이터);
		System.out.printf("%d호선\n", 2);
		System.out.printf("%05d호선\n", 2);
		System.out.printf("시력 : %f\n", 2.0);
		System.out.printf("시력 : %.3f\n", 2.0);
		System.out.printf("나 : %s\n", "ㅋㅋㅋ");
		System.out.printf("습도 : %d%%", 15);
	}
}



