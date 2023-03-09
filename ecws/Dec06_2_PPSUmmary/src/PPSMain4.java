import java.util.Random;
import java.util.Scanner;

public class PPSMain4 {

	public static int me() {
		Scanner k = new Scanner(System.in);
		return k.nextInt();
	}

	public static int com() {
		Random r = new Random();
		return r.nextInt(3);
	}

	public static String comResult() {

		int cNum = com();

		String[] 가위바위보 = { "가위", "바위", "보" };
		String cR = null;
		
		while (cNum == 0 || cNum == 1 || cNum == 2) {
			if (cNum == 0) {
				System.out.printf("컴퓨터: %s\n", 가위바위보[0]);
				cR = 가위바위보[0];
				break;
			} else if (cNum == 1) {
				System.out.printf("컴퓨터: %s\n", 가위바위보[1]);
				cR = 가위바위보[1];
				break;
			} else if (cNum == 2) {
				System.out.printf("컴퓨터: %s\n", 가위바위보[2]);
				cR = 가위바위보[2];
				break;
			}
		}
		return cR;
	}

	public static String userResult() {

		System.out.print("뭐: ");
		int kNum = me();
		String[] 가위바위보 = { "가위", "바위", "보" };
		String uR = null;
		while (kNum == 1 || kNum == 2 || kNum == 3) {
			if (kNum == 1) {
				System.out.printf("당신: %s\n", 가위바위보[0]);
				uR = 가위바위보[0];
				break;
			} else if (kNum == 2) {
				System.out.printf("당신: %s\n", 가위바위보[1]);
				uR = 가위바위보[1];
				break;
			} else if (kNum == 3) {
				System.out.printf("당신: %s\n", 가위바위보[2]);
				uR = 가위바위보[2];
				break;
			}
		}
		return uR;
	}

	public static void main(String[] args) {
		System.out.printf("1. %s 2. %s 3. %s\n", "가위", "바위", "보");
		userResult();
		comResult();
		
	}

}
