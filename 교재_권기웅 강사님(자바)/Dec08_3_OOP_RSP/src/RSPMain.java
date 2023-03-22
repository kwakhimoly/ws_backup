public class RSPMain {
	public static void main(String[] args) {
		Referee r = new Referee();
		User u = new User();
		Enemy e = new Enemy();
		r.start(u, e);
	}
}
