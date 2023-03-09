
public class OMain3 {
	public static void main(String[] args) {
		int a = 3 << 2;
		System.out.println(a);

//		----------------------

//		나이가 20살 이상이면 관람 가능, 안 되면 청소년 관람불가
		int age = 12;
		String say = (age >= 20) ? "즐거운 관람 되세요" : "청소년 관람불가";
		System.out.println(say);
	}
}
