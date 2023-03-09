import java.util.Random;
import java.util.Scanner;

public class PPSMain4_1 {
	
	public static void judge(int a) {
		int win = 0;
		if(a == 0) {
			System.out.println("=> 무승부");
		} else if(a == 2 || a == -1) {
			System.out.println("=> 패");
			System.out.printf("%d연승\n", win);

		} else {
			System.out.println("=> 승");
			win++;
		}	
	}
//	연승이 안 올라가서 실패 
	
	public static void main(String[] args) {
		String[] handTable = {"", "가위", "바위", "보"};
		for (int i = 1; i < handTable.length; i++) {
			System.out.printf("%d. %s\n", i, handTable[i]);
		} 
		System.out.println("==========");
		
		while(true) {
		Random r = new Random();
		int comHand = r.nextInt(3)+1;
		
		Scanner k = new Scanner(System.in);
		System.out.print("뭐: ");
		int userHand = k.nextInt();
		
		System.out.printf("컴퓨터: %s\n", handTable[comHand]);
		System.out.printf("당신: %s\n", handTable[userHand]);
		
		int t = userHand - comHand;
		judge(t);
		
		System.out.println("==========");
		}
	}
}
