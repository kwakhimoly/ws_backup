
//상속(IsA)
//A has a B -> 객체 간의 관계: 소유 가능
//A is a B -> 어떤 객체는 다른 객체일 수 있다! : 상속 관계
//	EX) Taxi is a Car

public class OMain {
	public static void main(String[] args) {
		Taxi t = new Taxi();
		t.name = "소나타"; // => Taxi에 없는데 자동완성도 되고 에러도 안나네!
		t.price = 25000000;
		t.pay = 3800; // -> 기능 추가(확장)
		t.print();
	}
}
