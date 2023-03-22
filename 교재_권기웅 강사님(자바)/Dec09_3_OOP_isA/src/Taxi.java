// @xxx : annotation
//		xxx에 뭐 들어가냐에따라 다 다름
//		대부분은 원래 소스작업해야하는데 자동으로 처리하는데

// Taxi는 Car의 기능 + 알파
//	-> Car에 있는 멤버들 상속됨
//	-> Car에 있는 print를 물려받아왔음
//	-> 근데 Car에 있는 print는 이름/가격출력만 있어서 아쉬움
//	-> print를 기본료까지 뜨게 개조하자
//			print메소드 재정의 : overriding

//	오버라이딩을 쓰는데
//		원래 있던 기능 빼고 새 기능만
//		원래 있던 기능 + 새 기능
//		둘 중에 뭘 더 많이 할것인가

// @Override : 바로 밑에 메소드가 무조건 오버라이딩 메소드여야
// => 오버라이딩 메소드 여부를 한 눈에 알수있
// -> 소스 가독성

// super : 상위클래스(Car)
// this : 이거(Taxi)
public class Taxi extends Car {
	int pay;

	@Override
	public void print() {
		super.print();
		System.out.println(pay);
	}
}




