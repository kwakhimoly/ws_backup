
public class OMain {
	public static void main(String[] args) {
		String name = "솔이";
		System.out.println(name);
		int age = 10;
		System.out.printf("%d살\n", age);
//		절차지향프로그래밍으로 10살 강아지 솔이 표현한 것

		System.out.println("-----------");

		Dog d = new Dog();
		d.name = "후추";
		d.age = 3;
		d.bark();
		d.printInfo();
//		객체지향프로그래밍으로 강아지 중 3살 후추 표현한 것

		System.out.println("------------");

		String[] colorList = { "빨강", "검정", "파랑" };

		Pen p = new Pen();
		p.name = "모나미 153";
		p.maker = "모나미";
		p.color = "빨강 " + colorList[2];
		p.price = 500;
		p.printInfo();
//		객체지향프로그래밍으로 펜 예제

		System.out.println("------------");

		Calcul c = new Calcul();
		c.printPlus(3, 4);
		c.printPlus(21, 23);
	}
}
