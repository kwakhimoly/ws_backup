package teacher;
//	종이에 써서 내는 느낌

/*
 * 변수 잘 쓰기
 * 속성 잘 쓰기
 * 말이 되게 하는게 중요함 실행해서 성공하는 것보다
*/

public class Referee {
//	User u;
//	Enemy e;
//	속성이라기엔 어색함
//	만약에 심판이 가위바위보 협회 소속 심판이라 나중에 협회 본부 가서 누구랑 누가 붙었는지 보고를 해야할때
//	근데 아무튼 좀 이상함 뒤에 심판 생성자에 User u랑 Enemy e가 들어가니깐
	static String[] ruleBook = { null, "가위", "바위", "보" }; // 위치?
//	-> 나중에 다른 데서도 쓸 거니까 위치는 여기
//	-> 심판들 간의 공통 속성 부여(static) -> 구라^^ : 심판들이 각자 같은 내용의 ruleBook 갖고 있는거: 모두가 동일한 ruleBook하나를 갖고 있는게 아님
//	만약 한 권의 책을 전세계 심판들이 공유하는 거라면 static을 줄 수 있음..!

	int userWin; // 승자 연승 횟수를 협회에 보고하는 경우
	
	
	
	public void readRuleBook() {
		for (int i = 1; i < ruleBook.length; i++) {
			System.out.printf("%d. %s\n", i, ruleBook[i]);
		}

		System.out.println("===================");
	}

	public int userFire(User u) {
//	User가 기본적으로 있어야 내라고 할 수 있음
		System.out.print("뭐: ");
		int uh = u.fire();
		return (uh < 1 || uh > 3) ? userFire(u) : uh;
	}

	public int enemyFire(Enemy e) {
//	enemy가 기본적으로 있어야 내라고 할 수 있음
		return e.fire();
	}

	public void tellHand(int userHand, int enemyHand) {
		System.out.printf("적: %s\n", ruleBook[enemyHand]);
		System.out.printf("당신: %s\n", ruleBook[userHand]);
	}

	public boolean judge(int userHand, int enemyHand) {
		int t = userHand - enemyHand;
		if (t==0) {
			System.out.println("무승부");
		} else if(t==-1||t==2) {
			System.out.println("패배");
			return true;
		} else {
			System.out.println("승리");
			userWin++;
		}
		System.out.println("-------------");
		return false;
	}
	
	public void bye() {
		System.out.printf("%d연승\n", userWin);
	}

	public void start(User u, Enemy e) {
		/* 대회장에 유저랑 적이랑 심판이 모두 와있음 */

//		*User u = callGuest();*
//		게임 끝나면 볼일 없는 상황
//		대회장에 심판이 있는데 유저랑 적을 부르는 느낌

		readRuleBook();
		int userHand;
		int enemyHand;
		while(true) {
			userHand = userFire(u);
			enemyHand = enemyFire(e);
			tellHand(userHand, enemyHand);
			if(judge(userHand, enemyHand) /*뒤에 ==true 안써도 알아서 알아먹음 -> boolean return 값 받을 때 true가 기본값이니깐*/) {
				bye();
				break;
			};			
		}
		
//		나중에 반복문
	}
}
