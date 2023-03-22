import java.util.Random;
import java.util.Scanner;

// 다른데서 작업한 프로젝트(폴더째로 가져와서)
//		아무데나 던져놓고
//		import
//			general - existing project...
//////////////////////////////////////////////
// User.java에는 개발자의 아이디어
// 기능만 만들어주지
// 왜 지적재산권까지 갖다바치나

// 클래스 작업 끝 -> export해서 JAR로 만들어서 줘
// Java ARchive
//		기계어로 번역된거 압축해놓은 파일

// 받았으면
//		Build Path -> Configure ...
//			Libraries -> Add External JARs...

public class TIJMain {
	public static void main(String[] args) {
		Dog d = new Dog("후추", 3);
		d.show();
		
		
		System.out.println("-----");
		Enemy e = new Enemy();
		int eh = e.fire();
		System.out.println(eh);
		
		System.out.print("뭐 : ");
		User u = new User();
		int uh = u.fire();
		System.out.println(uh);
	}
}


