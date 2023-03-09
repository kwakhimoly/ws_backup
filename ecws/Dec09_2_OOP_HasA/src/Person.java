
public class Person {
	String name;
	int age;
	String species;
	Dog pet;
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		species = "사람";
	}

	public Person(String name, int age, Dog pet) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
		species = "사람";
	}
	
	

	public Person(String name, int age, Dog pet, City living) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
		species = "사람";
	}

	public void printInfo() {
		if (pet != null) {
			pet.printInfo();
		}
		System.out.println(name);
		System.out.println(age);
		System.out.println(species);
	}
}
