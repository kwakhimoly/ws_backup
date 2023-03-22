// 김수미라는 유일한 분이 게장1, 게장2번을 만든
// 심판1, 심판2가 같은내용의 책을 갖고있을 뿐
//
// 근데 이번에는 본부에 비치되어있는 책 한권을
//	심판1, 심판2가 같이 쓰는걸로...
public class Referee {
	static String[] ruleBook = { null, "가위", "바위", "보" };
	int userWin;

	public void readRuleBook() {
		for (int i = 1; i < ruleBook.length; i++) {
			System.out.printf("%d. %s\n", i, ruleBook[i]);
		}
		System.out.println("-----");
	}

	public int userFire(User u) {
		System.out.print("뭐 : ");
		int uh = u.fire();
		return (uh < 1 || uh > 3) ? userFire(u) : uh;
	}

	public int enemyFire(Enemy e) {
		return e.fire();
	}

	public void tellHand(int userHand, int enemyHand) {
		System.out.printf("컴 : %s\n", ruleBook[enemyHand]);
		System.out.printf("너 : %s\n", ruleBook[userHand]);
	}

	public boolean judge(int userHand, int enemyHand) {
		int t = userHand - enemyHand;
		if (t == 0) {
			System.out.println("무");
		} else if (t == -1 || t == 2) {
			System.out.println("패");
			return true;
		} else {
			System.out.println("승");
			userWin++;
		}
		return false;
	}

	public void bye() {
		System.out.printf("%d연승\n", userWin);
	}
	
	public void start(User u, Enemy e) {
		readRuleBook();
		int userHand;
		int enemyHand;
		while (true) {
			userHand = userFire(u);
			enemyHand = enemyFire(e);
			tellHand(userHand, enemyHand);
			if (judge(userHand, enemyHand)) {
				bye();
				break;
			}
		}
	}

}
