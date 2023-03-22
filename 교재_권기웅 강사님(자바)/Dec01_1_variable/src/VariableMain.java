// 컴
//		CPU : 연산장치 -> 작업이 빠름(코어가 몇개 : 동시에 계산 몇개)
//		RAM : 저장장치 : 변수 형태로 임시 저장 
//		SSD/HDD : 저장장치 : 파일 형태로 영구 저장

//		GPU(그래픽카드) : 그래픽 처리용 CPU+RAM+HDD
// -------------------------------------------------------
// 변수(variable) : 데이터를 임시로 담아놓는 그릇 
//		언제 - 데이터를 임시로 저장
//				데이터 특징을 고려해서 맞는 자료형 선정
//				용량 덜 쓸 궁리
//		문법
//			자료형 변수명;

//		자료형(어떤 데이터 담을건가)
//			기본형
	//			정수 : byte, short, int(이거 쓰고), long(21억 넘으면 이거)
	//			실수 : float, double(이거 쓰고)
	//			한 글자 : char
	//			논리 : boolean
	//			딱히 저장할건 없는데 자리 차지 : void
//			참조형
//				여러 글자 : String
// 				하여튼 나머지들

//		변수명 : 마음대로
//			숫자로 시작x
//			특수문자 x(_, $빼고)
//			자바 문법 x
//			
//			대문자로 시작x
//			한글x
//			알아보기 편하게(뜻 통하게) 
//				=> 띄어쓰기는 못쓰니까
//					=> _로 대체(뱀체)
//					=> 대문자로(낙타체)


// 프로그래밍 언어마다 기본자료형
//		아무 처리도 안해놓고 데이터만 있을때
//		뭘로 인식
//		Java 		  : int, double
//		대부분의 언어 : int, float

// A = B
//		A는 B와 같습니다 - x
//		B를 A에 넣어라 -> 같아지기는 함...

// 글자데이터 : "ㅋ" -> 그렇게 안하면 변수명으로 인식
// 숫자데이터 : 1

public class VariableMain {
	public static void main(String[] args) {
		// 사람 나이가 25살이라는 데이터가 생겼는데
		// 임시보관 해야 할 상황
		int age;
		// 거기다 25 저장하기
		age = 25;
		System.out.println("humanAge");
		System.out.println(age);
		System.out.println(age);
		System.out.println("-----");

		// double eye; // 변수 만들기(선언)
		// eye = 1.5; // 만들어진 변수에 값 담음(대입)
		double eye = 1.5; // 선언 + 대입
		// float eye = 1.5f;
		System.out.println(eye);
		System.out.println(eye);
		
		// ㅋ라는 글자 저장
		char laugh = 'ㅋ';
		System.out.println(laugh);
		
		// 사람 이름이 홍길동 저장
		String name = "홍길동";
		System.out.println(name);
		
		// 지금 추워요? 춥다/안춥다
		boolean cold = true; // false
		System.out.println(cold);
	}
}


// encoding/decoding
// 컴퓨터 : 전자제품 -> 전기가 흐르고/안흐르고
// 모든 데이터는 전기의 흐름으로 저장되어야
// 모르스부호
//	ㅋ -encoding-> 1010 -decoding-> ㅋ














