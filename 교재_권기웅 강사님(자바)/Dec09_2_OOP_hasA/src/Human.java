
public class Human {
	String name;
	int age;
	Dog pet;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Human(String name, int age, Dog pet) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
	}

	public void print() {
		System.out.println(name);
		System.out.println(age);
		if (pet != null) {
			pet.show();
		}
	}
}







