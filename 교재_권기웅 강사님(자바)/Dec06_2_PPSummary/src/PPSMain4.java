import java.util.Random;
import java.util.Scanner;

// 저거 가위바위보 판정을 할수는 있겠는데 좀 어떻게 안되나...

// 1. 가위
// 2. 바위
// 3. 보
// -------
// 뭐 : 3
// 컴 : 바위
// 나 : 보
// 승
// ---------
// 뭐 : 2
// ...
// 질때까지
// 3연승

// 한국어로 설계 -> 직역 -> 정리

public class PPSMain4 {
	public static void printRule(String[] handTable) {
		for (int i = 1; i < handTable.length; i++) {
			System.out.printf("%d. %s\n", i, handTable[i]);
		}
		System.out.println("-----");
	}
	
	public static int comFire() {
		Random r = new Random();
		return r.nextInt(3) + 1;
	}
	
	public static int userFire() {
		Scanner k = new Scanner(System.in);
		System.out.print("뭐 : ");
		int userHand = k.nextInt();
		return (userHand < 1 || userHand > 3) ? userFire() : userHand;
	}
	
	public static void printHand(String[] ht, int ch, int uh) {
		System.out.printf("컴 : %s\n", ht[ch]);
		System.out.printf("나 : %s\n", ht[uh]);
	}
	
	// 게임 계속 돌릴거면 true/그만 돌릴거면 false
	// 이겼네/비겼네/졌네가 main으로 전달되어야
	public static int judge(int comHand, int userHand) {
		int t = userHand - comHand;
		if (t == 0) {
			System.out.println("비김");
			return 0;
		} else if(t == 2 || t == -1) {
			System.out.println("패");
			return -48759834;
		} else {
			System.out.println("승");
			return 1;
		}
	}
	
	public static void printResult(int win) {
		System.out.printf("%d연승", win);
	}
	
	public static void main(String[] args) {
		String[] handTable = {"오호~", "가위", "바위", "보"};
		printRule(handTable);	
		
		int comHand;
		int userHand;
		int win = 0;
		int result;
		while (true) {
			comHand = comFire();
			userHand = userFire();
			printHand(handTable, comHand, userHand);
			result = judge(comHand, userHand);
			if (result == -48759834) {
				printResult(win);
				break;
			}
			win += result;
			System.out.println("-----");
		}
	}
}




