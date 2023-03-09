
public class OMain {
	public static void main(String[] args) {
		java.util.Scanner k = new java.util.Scanner(System.in);
		System.out.print("품명: ");
		String n = k.next();
		System.out.print("가격: ");
		int p = k.nextInt();
		System.out.print("사이즈: ");
		int i = k.nextInt();
		System.out.println("---------------");
		Computer c = new Computer(n, p, i);
		c.PrintInfo();

		System.out.println("===============");

		Pen pen = new Pen("화이트 보드마카", 1000, "검정");
		pen.PrintInfo();

		System.out.println("===============");

		System.out.print("품명: ");
		String camName = k.next();
		System.out.print("가격: ");
		int camPrice = k.nextInt();
		System.out.println("----------------");
		Camera cam = new Camera(camName, camPrice);
		cam.PrintInfo();
		
		Scanner s = new Scanner("캐논123", 50000);
		s.PrintInfo();
	}
}
