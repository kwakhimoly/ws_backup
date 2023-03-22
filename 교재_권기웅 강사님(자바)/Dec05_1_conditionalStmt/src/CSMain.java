import java.util.Scanner;

// 제어문
//		조건문
//			3항연산 : 조건 따져서 값 결정
//			조건문 : 조건 따져서 작업 => 3항연산 대체 가능

//	if (조건식A) {
//		조건식A 만족하면 실행
//  } else if (조건식B) {
//		A는 틀렸는데 B는 만족하면 실행
//	} else if (조건식C) {
//		A/B는 틀렸고 C는 만족하면 실행
//	} ...
//	} else {
//		위에 맞는거 하나도 없으면 실행
//	}
public class CSMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		
		System.out.print("중간고사 : ");
		int mid = k.nextInt();
		
		System.out.print("기말고사 : ");
		int _final = k.nextInt();
		
		System.out.println("-----");
		
		double avg = (mid + _final) / 2.0;
		System.out.printf("평균 : %.2f점\n", avg);
		
		// 90점 이상이면 수
		// 80 <= 점수 < 90이면 우
		// ...
		
		if (avg >= 90) {
			System.out.println("수");
		} else if (avg >= 80) {
			System.out.println("우");
		} else if (avg >= 70) {
			System.out.println("미");
		} else if (avg >= 60) {
			System.out.println("양");
		} else {
			System.out.println("가");
		}
		
		
		
		
		// 80점 이상이면 잘했다
		// 아니면 야
		//		근데 70은 넘겼으면 노력좀
		if (avg >= 80) {
			System.out.println("잘했다");
		} else {
			System.out.println("야");
			if (avg >= 70) {
				System.out.println("노력좀");
			}
		}
		
		
	}
}










