
public class ClassRoom {
	String name;
	int chair;
	static CoffeMachine machine = new CoffeMachine("전자동 커피메이커", 50);
//	강의실이 여러개인데 한 대의 커피머신을 공유 -> static 사용!
	
	public ClassRoom() {
		// TODO Auto-generated constructor stub
	}

	public ClassRoom(String name, int chair) {
		super();
		this.name = name;
		this.chair = chair;
	}
	
}
