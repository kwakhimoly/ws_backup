
public class OMain {
	
	public static void test() {
		System.out.println("테스트");
	}
	
	
	public static void main(String[] args) {
//		단위 변환기
//		cm -> inch
	
		Convert.toInch(30);
//		static으로 작성했기 때문에 객체 생성(Convert con = new Convert();)할 필요 없음
//		메모리 사용량 제로
		
		
		System.out.println("===================");
		
		
//		게장
//		품명이 설날특선 간장 게장 세트
//		무게가 5kg
//		가격이 39900
//		정보출력
		test();
		System.out.println(Math.PI);
		
		System.out.println("=================");
		
//		System.out.println(PRODUCER);
//		static으로 선언된 변수는 클래스명 그 자체로 접근해야함 (c가 아니라 Crab을 앞에 붙여야함)
//		객체 없이도 쓸 수 있음 => 굳이 앞에 객체(Crab c = new Crab();)를 만들지 않아도 됨
		
		Crab c = new Crab();
		c.name = "설날 특선 간장게장 세트";
		c.weight = 5.0;
		c.price = 39900;
//		Crab.producer = "최수미"; 
//		-> static으로 정보를 보내놓고 공유하고 있는 상황이기 때문에
//		c에서 최수미로 바꾼다면 c2에도 바뀐 정보 값이 들어가게 됨
//		-> 그냥 일반 String으로 선언한 경우라면 c와 c2 각각에 김수미가 들어간 상황이기 때문에
//		c의 김수미를 최수미로 바꿔도 c2는 영향이 없음 
//		-> 만약 static final로 선언했다면 상수화돼서 변경할 수 없음

		c.printInfo();

		System.out.println("==============");
		
		Crab c2 = new Crab();
		c2.name = "X-MAS 특선 양념게장 세트";
		c2.weight = 3;
		c2.price = 59900;
		
		c2.printInfo();
		
		c2.test();
	}
}
