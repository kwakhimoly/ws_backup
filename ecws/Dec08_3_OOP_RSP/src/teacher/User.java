package teacher;

import java.util.Scanner;

public class User {
	Scanner brain; // 속성(태어날때 갖고 태어나잖어)
//	int win; // 속성(개인의 점수는 시합에 필수요소)
	
	public User() {
		brain = new Scanner(System.in);
//		사람들마다 뇌 하나씩 각자 갖고 있으니깐..
	}

	public int fire() {
		return brain.nextInt();
	}
}
