
public class CSMain2 {
	public static void main(String[] args) {

		String role = "DBP";
		// DBA = DataBaseAdmin
		// 		전원 / 사용자 관리
		// 		백업 / 복구
		// 		CRUD
		// 		DB 서비스 사용
		// DBP = DataBaseProgrammer
		// 		CRUD(= Create Read Update Delete)
		// 		DB 서비스 사용
		// DBU = DataBaseUser
		// 		DB 서비스 사용

		
		String db = role;
		switch (db) {
		case "DBA":
			System.out.println("전원/사용자 관리");
			System.out.println("백업/복구");
		case "DBP":
			System.out.println("CRUD");

		default:
			System.out.println("DB 서비스 사용");
			break;
		}
		
		
		String grade = "상병";
		switch (grade) {
		case "이병":
			System.out.println("눈치");
		case "일병":
			System.out.println("관등성명");
		case "상병":
			System.out.println("훈련");
//		case "병장":
//			System.out.println("잠");
//			break;

		default:
			System.out.println("잠");
			break;
		}

		int score = 90;

		switch (score) {
		case 90:
			System.out.println("수");
			break;
		// break가 없고+조건1을 충족할 경우 조건2와 상관없이 우까지 실행
		case 80:
			System.out.println("우");
			break; // break가 없으면 미까지 실행
		case 70:
			System.out.println("미");
			break;
		case 60:
			System.out.println("양");
			break;

		default:
			System.out.println("가");
			break;
		}
	}
}
