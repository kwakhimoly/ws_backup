import java.util.Scanner;
// 연산자 : stack영역 대상

// 논리연산자
//		미만 	이하 
//		<		<=	

//		같다 	다르다
//		==		!=

//		이상 	초과
//		>=		>

// 논리결합연산자
//		~고(and)			~거나(or)
//		&&  				|| 
//		확률 낮은거 앞으로	확률 높은거 앞으로 배치

//		eXclusive OR(배타적OR)
//		^

//  and			or			xor
//	o o -> o	o o -> o	o o -> x
//  o x -> x    o x -> o	o x -> o
//  x o -> x    x o -> x	x o -> o
//  x x -> x    x x -> x	x x -> x

//	not
//	!

public class OMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = k.next();
		
		System.out.print("키 : ");
		double height = k.nextDouble();
		
		System.out.print("나이 : ");
		int age = k.nextInt();
		
		System.out.println("-----");
		System.out.printf("키는 %.1fcm, 나이는 %d살\n", height, age);
		
		// 키가 150이상이면 타도 됨 
		boolean a = (height >= 150);
		System.out.println(a);
		
		// 나이가 5살인 사람만 타도 됨
		boolean b = (age == 5);
		System.out.println(b);
		
		// 키가 200미만이면 타도 됨
		boolean c = (height < 200);
		System.out.println(c);
		
		// 나이가 짝수면 타도 됨
		boolean d = (age % 2 == 0);
		System.out.println(d);
		
		// 홍길동만 타도 됨(면접 포인트)
		boolean e = (name == "홍길동"); // #3 == "홍길동"
		System.out.println(e);
		
		boolean f = name.equals("홍길동");
		System.out.println(f);
		
		// 키가 150이상이고, 나이가 3살이상
		boolean g = (height >= 150) && (age >= 3);
		System.out.println(g);
		
		// 키가 200이상이거나, 나이가 5살이상
		// 검사횟수가 웬만하면 2번
		// boolean h = (height >= 200) || (age >= 5);
		
		// 검사횟수가 웬만하면 1번
		boolean h = (age >= 5) || (height >= 200);
		System.out.println(h);
		
		// 키가 180넘든지 나이가 3살 넘든지
		// 둘중에 하나만
		boolean i = (height > 180) ^ (age > 3);
		System.out.println(i);
		
		// i못타는 사람만 타(i의 반대)
		boolean j = !i;
		System.out.println(j);
		
		// 5 <= 나이 <= 10인 사람만 타
		boolean l = (age <= 10) && (age >= 5);
		System.out.println(l);
		
		// 키가 150넘고, 키가 180넘으면 타
		boolean m = (height > 180);
		System.out.println(m);
	}
}












