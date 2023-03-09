//A has a B 
//A is a B 상속 : Taxi가 Car에게 소속될 때(택시는 차니까!) -> 택시는 자동차로 확장되는데에 전혀 문제가 없기 때문
//	Taxi is a Car

//	세상의 모든 차: 이름, 가격
//	택시: 이름, 가격, 기본료

public class Taxi extends /*=확장*/ Car { 
//		 => Car로부터 상속 받은 Taxi = Car의 기능+알파
//		 -> Car에 있는 멤버들이 상속됨(name, price, print())
//	= Car에 있는 print를 물려받아 왔음
//	= Car에 있는 print는 이름/가격출력만 있어서 아쉬움
//	= print를 기본료까지 뜨게 개조하자
//		=> print 메소드 재정의 : overriding(메소드 오버라이딩)
	
//	오버라이딩을 쓰는데
//			원래 있던 기능 빼고 새 기능만
//			원래 있던 기능 + 새 기능
	
	
	int pay;
	

//	@override 는 바로 밑에 메소드가 무조건 오버라이딩 메소드여야 함 -> 안 그럼 에러
//	=> 아 @override가 붙은 메소드는 무조건 재정의된 메소드구나~ = 소스 가독성 증가!
	
	
	@Override // -> @xxx: annotaion => xxx 자리에 뭐가 들어가냐에 따라 다른데 대부분은 원래 소스작업해야하는데 자동으로 처리
		public void print() {
			// TODO Auto-generated method stub
			super.print(); //super: 상위 클래스(Car) , this: 이거(Taxi) => super.print: Car에 있는 print() 불러온 거
			System.out.println(pay); //super.print()에 항목 추가
		} // 메소드명 조금 치고 자동완성하면 super.print() 되는데 얘는 덮어쓰는게 아니라 추가만 하는게 가넝!
	
	 
//	public void print() {
//		System.out.println(pay);
//	} => 이러면 덮어져서 pay만 출력됨
}
