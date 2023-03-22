// 조건문
//		if - else if - else : 주력
//		switch - case : 기능/가독성 부족, 권한부여때는 소스 짧게 가능

// switch (key) {
// case 값: 조건식 못씀
//	
//	 break;
// ...
// default:
//	 break;
// }

// Database
//		DBA(admin)
//			전원/사용자 관리
//			백업/복구
//			CRUD
//			DB서비스 사용
//		DBP(programmer)
//			CRUD(Create Read Update Delete)
//			DB서비스 사용
//		DBU(user)
//			DB서비스 사용
public class CSMain3 {

	public static void main(String[] args) {
		String role = "DBA";
		
		switch (role) {
		case "DBA":
			System.out.println("전원/사용자 관리");
			System.out.println("백업/복구");
		case "DBP":
			System.out.println("CRUD");
		default:
			System.out.println("서비스 사용");
		}
		
		String grade = "일병";
		
		switch (grade) {
		case "이병":
			System.out.println("눈치");
		case "일병":
			System.out.println("관등성명");
		case "상병":
			System.out.println("훈련");
		default:
			System.out.println("잠");
			break;
		}
		
		
		
		
		
		
		int score = 90;

		switch (score) {
		case 90:
			System.out.println("수");
			//break;
		case 80:
			System.out.println("우");
			//break;
		default:
			System.out.println("ㅇㅇ");
			break;
		}
	}
}
