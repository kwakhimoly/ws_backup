import java.util.Random;
import java.util.Scanner;

public class PPSMain4Ans {

	public static int comRand() {
		Random r = new Random();
		return r.nextInt(3) + 1;
	}

	public static int userHan() {
		Scanner k = new Scanner(System.in);
		System.out.print("뭐: ");
		int userPick = k.nextInt();
		return (userPick < 1 || userPick > 4) ? userHan() : userPick;
	}

	public static void printRule(String[] handTable) {
		for (int i = 1; i < handTable.length; i++) {
			System.out.printf("%d. %s\n", i, handTable[i]);
		} // 안내멘트 끝
		System.out.println("==========");
	}

	public static void printHand(String[] ht, int ch, int uh) {
		System.out.printf("컴퓨터: %s\n", ht[ch]);
		System.out.printf("당신: %s\n", ht[uh]);
	}

	public static int judge(int comHand, int userHand) {
		int t = userHand - comHand;
		if (t == 0) {
			System.out.println("=> 무승부");
			return 0;
		} else if (t == 2 || t == -1) {
			System.out.println("=> 패");
			return -4583945;
		} else {
			System.out.println("=> 승");
			return 1;
		}
	}

	public static void printResult(int win) {
		System.out.printf("%d연승\n", win);
	}

	public static void main(String[] args) {
		String[] handTable = { "", "가위", "바위", "보" };
//		""를 왜 넣었을까..
//		-> 배열은 0번부터 세는데 사람은 1번부터 생각하기 때문
//		-> 뒤에 나올 i를 1로 설정하기에 용이

		printRule(handTable);

		int win = 0;
		int comHand;
		int userHand;
		int result;

		while (true) {
			comHand = comRand();
			userHand = userHan();
			printHand(handTable, comHand, userHand);

			result = judge(comHand, userHand);

			if (result == -4583945) {
				printResult(win);
				break;
				// 지면 반복문이 끝나기 때문에 win+=result 는 실행되지 않음
			}
			win += result;

			System.out.println("==========");
		}
	}
}
