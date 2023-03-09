import java.util.Random;
import java.util.Scanner;

//	up down 게임
//	컴퓨터가 1~10000 사이의 랜덤한 숫자 생각해놓게 함
//	내가 맞추기

//	뭐: 1212
//	up
//	---------
//	뭐: 7000
//	down
//	---------
//	...
//	뭐: 5043
//	5번 만에 정답

public class PPSMain3 {

	public static int getAns() {
		Random r = new Random();
		return r.nextInt(99) + 1;
	}

	public static int tellAns() {
		Scanner k = new Scanner(System.in);
		System.out.print("뭐: ");
		int num = k.nextInt();
		return (num < 1 || num > 100) ? tellAns() : num;
	}

	public static boolean judgeAns(int gameAns, int userAns) {
//		계속 게임 해야하면 true
//		그만해야하면 false
		if (userAns == gameAns) {
			return false;
		} else if (userAns < gameAns) {
			System.out.println("up");
		} else {
			System.out.println("down");
		}
			return true;
	}
	
	public static void printResult(int turn) {		
			System.out.printf("%d차 시도만에 정답", turn);
	}
	
	public static void main(String[] args) {

		int gameAns = getAns();

		int userAns = 0;
//		for -> 횟수만큼 돌리기
//		while -> 조건 충족될 때까지 돌리는 이 게임에 걸맞음
		
//		int turn = 0;
//
//		while (!false) {
//			turn++;

		for(int turn = 1; true; turn++) {
			userAns = tellAns();
			
			if(!judgeAns(gameAns, userAns)) {
				printResult(turn);
				break;
			}
		}
	}
}
