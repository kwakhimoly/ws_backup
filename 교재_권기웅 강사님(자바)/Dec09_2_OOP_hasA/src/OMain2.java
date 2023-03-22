import java.io.PrintStream;

// A강의실
// B강의실
// C강의실
// 그 강의실들이 1대뿐인 커피머신을 같이써서 => static

// Win시스템
// Linux시스템
// 그 시스템들이 JVM체제하의 콘솔창을 같이써서 => static
public class OMain2 {
	public static void main(String[] args) {
//		CoffeeMachine cm = ClassRoom.machine;
//		cm.pick();
		ClassRoom.machine.pick();
//		PrintStream ps = System.out;
//		ps.println("asd");
		System.out.println("asd");
	}
}
