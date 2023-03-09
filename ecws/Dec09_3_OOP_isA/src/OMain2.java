//쇼핑몰
public class OMain2 {
//		펜
//		모나미153
//		500
//		빨간색
//		출력
//		
//		컴퓨터
//		매직스테이션123
//		1000000
//		i7-1234
//		16
//		500
//		출력
	public static void main(String[] args) {
		Pen p = new Pen(); // => Product 상속
		p.name = "모나미153";
		p.price = 500;
		p.color = "빨강";
		p.print();
		
		System.out.println("--------");
		
		Pen p2 = new Pen("모나미132", 700, "파랑");
		p2.print();
		
		System.out.println("--------");
		
		Computer c = new Computer(); // => Product 상속
		c.name = "매직스테이션123";
		c.price = 1000000;
		c.cpu = "i7-1234";
		c.ram = 16;
		c.hdd = 500;
		c.print();
		
		System.out.println("-----------");
		
		LapTop l = new LapTop("그램", 2000000, "i7-5656", 16, 250, 5);
		
		l.print();
		
		System.out.println("------------");
		
		Highlighter h = new Highlighter("스테들러", 1020, "노랑", "바나나향");

		h.print();
		
		System.out.println("------------");
		
		Snack s = new Snack("새우깡", 1500, 20221210);
		
		s.print();
		
		System.out.println("------------");
		
		Shoes sh = new Shoes("에어맥스123", 100000);
		sh.print();
	}
	

}
