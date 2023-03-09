package teacher;

public class TMain {
	public static void main(String[] args) {
		Referee r = new Referee();
		User u = new User();
		Enemy e = new Enemy();
//	이미 입장해있는 상태

		r.start(u, e);
	}

}
