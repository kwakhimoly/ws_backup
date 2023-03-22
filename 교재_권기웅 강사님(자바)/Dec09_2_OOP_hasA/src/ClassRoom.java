
public class ClassRoom {
	String name;
	int seat;
	static CoffeeMachine machine 
		= new CoffeeMachine("ABC123", 50);

	public ClassRoom() {
		// TODO Auto-generated constructor stub
	}

	public ClassRoom(String name, int seat) {
		super();
		this.name = name;
		this.seat = seat;
	}

}
