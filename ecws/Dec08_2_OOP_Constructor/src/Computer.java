
public class Computer {
	String cpu;
	int ram;
	int hdd;

	public Computer() {
		hdd = 512;
		System.out.println("ㅋ");
	}

	public void printCom() {
		System.out.println(cpu);
		System.out.printf("%dgb\n", ram);
		System.out.println(hdd);
	}
}
