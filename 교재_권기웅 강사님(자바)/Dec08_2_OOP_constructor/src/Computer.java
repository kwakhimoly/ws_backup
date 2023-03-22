// 기본값
//		hdd입력하기 귀찮은데
//		따로 안쓰면 500자동으로 들어가게
//		-> 생성자...
// 공통속성표현
//		모든 컴퓨터가 다 hdd가 500
//		-> static
public class Computer {
	String cpu;
	int ram;
	int hdd;

	public Computer() {
		hdd = 500;
		System.out.println("ㅋ");
	}
	
	public void printHahaha() {
		System.out.println(cpu);
		System.out.println(ram);
		System.out.println(hdd);
	}
}
