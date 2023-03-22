// 특수문자(모든 언어 공통)
//		\n : new line : 줄만바꾸기
//		\r : carrage return : 커서 맨 앞으로
//		\r\n : 엔터
//			=> \n만 해도 괜찮은거는 콘솔창이라서 편의 봐준거
//			   다른데 출력할때는 신경써야
//		\t : tab키
//		\b : backspace(1byte만큼) 
//			=> 한 글자당 2bytes인 Java에서 써먹기는...
//		\\ : \
//		\" : "
public class PrintMain2 {

	public static void main(String[] args) {
		System.out.println("권\r\n기웅");
		System.out.println("집:\t분당");
		System.out.println("학원:\t가산\b");
		System.out.println("퇴\"근\"시간 \\괜찮을라나");
	}

}


