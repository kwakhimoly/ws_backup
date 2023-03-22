import java.util.Random;
import java.util.Scanner;

// 이거 함수 정리하기 전
public class PPSMain3 {

	public static int pickAns() {
		Random r = new Random();
		return r.nextInt(10000) + 1;
	}

	public static int tellAns() {
		Scanner k = new Scanner(System.in);
		System.out.print("뭐 : ");
		int userAns = k.nextInt();
		return (userAns < 1 || userAns > 10000) ? tellAns() : userAns;
	}

	public static boolean judge(int gameAns, int userAns) {
		if (gameAns == userAns) {
			return false;
		} else if (gameAns > userAns) {
			System.out.println("UP");
		} else {
			System.out.println("DOWN");
		}
		return true;
	}

	public static void printResult(int turn) {
		System.out.printf("%d턴만에 정답\n", turn);
	}

	public static void main(String[] args) {
		int gameAns = pickAns();
		int userAns = 0;

		for (int turn = 1; true; turn++) {
			userAns = tellAns();
			// == true : 생략가능
			// == false : !조건식 
			if (!judge(gameAns, userAns)) {
				printResult(turn);
				break;
			}
		}
	}
}
