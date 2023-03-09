
public class Dog {
	String name;
	int age;

	/*
	 * put dog name, age
	 * 
	 * @param input dog's name and age
	 * 
	 * @return output maybe printed
	 */
//	
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/* print thing */
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
	}

	public Dog() {

	}

}
