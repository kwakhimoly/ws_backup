import java.util.Scanner;

public class OMain2 {
	public static void main(String[] args) {
		Scanner amuse = new Scanner(System.in);

		System.out.print("이름: ");
		String name = amuse.next();

		System.out.print("키: ");
		double height = amuse.nextDouble();

		System.out.print("나이: ");
		int age = amuse.nextInt();

		System.out.println("============");
		System.out.printf("%s씨의 키는 %.1fcm, 나이는 %d살\r\n", name, height, age);

		boolean a = (height >= 150);
		System.out.println(a);

		boolean b = (age == 5);
		System.out.println(b);

		boolean c = (height < 200);
		System.out.println(c);

		boolean d = (age % 2 == 0);
		System.out.println(d);

//		boolean e = (name == "홍길동"); -> 안됨
//			연산자: stack 영역 대상
//			String: heap 영역 대상
//			name에 저장된 데이터는 heap의 위치정보를 stack에 담은 것
		boolean e = (name.equals("홍길동"));
		System.out.println(e);

		boolean f = (height >= 150) && (age >= 3);
		System.out.println(f);

//		boolean g = (height >= 200) || (age >= 5); 
//		-> 첫 조건이 희귀하기 때문에 컴퓨터가 굳이 뒷 조건을 확인해야함
//		-> 뒷 조건은 보다 일반적
//		-> or 상황에선 뒷 조건이 더 충족될 확률이 높을 경우엔
//		   검사횟수를 줄이기 위해 배치 변경이 좋음
		boolean g = (age >= 5) || (height >= 200);
		System.out.println(g);

//		키가 180 넘든지 나이가 3살 넘든지 둘 중 하나만 -> 배타적 or
//		boolean h = (age > 3) || (height > 180);
		boolean h = (height > 180) ^ (age > 3);
		System.out.println(h);

//		놀이기구 h 못 타는 사람만 
		boolean i = !h;
		System.out.println(i);

//		같은 변수로 두 가지 조건을 따질 때에도 나눠서 써야함
		boolean j = (age <= 10) && (age >= 5);
		System.out.println(j);

//		키가 150 넘고, 키가 180 넘으면 타
//		-> 앞선 조건은 의미 없는 조건이므로 뒷 조건만 사용
		boolean k = (height > 180);
		System.out.println(k);
	}
}
