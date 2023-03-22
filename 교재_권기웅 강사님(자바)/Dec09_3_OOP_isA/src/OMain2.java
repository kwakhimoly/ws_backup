
public class OMain2 {
	public static void main(String[] args) {
		Shoes sh = new Shoes("에어맥스123", 100000);
		sh.showInfo();
		System.out.println("-----");

		Snack s = new Snack("새우깡", 1500, "20221210");
		s.showInfo();
		System.out.println("-----");

		Pen p2 = new Pen("네임펜", 1000, "검정");
		p2.showInfo();
		System.out.println("-----");

		Pen p = new Pen();
		p.name = "모나미153";
		p.price = 500;
		p.color = "빨강";
		p.showInfo();
		System.out.println("-----");

		Notebook n = new Notebook();
		n.name = "그램123";
		n.price = 2000000;
		n.cpu = "i7-1231";
		n.ram = 16;
		n.hdd = 250;
		n.weight = 5;
		n.showInfo();

	}
}
