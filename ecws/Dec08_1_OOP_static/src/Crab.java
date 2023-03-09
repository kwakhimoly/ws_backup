
public class Crab {
	String name;
	double weight;
	int price;
	static String producer = "김수미";
//	static final String PRODUCER = "김수미";
//	(그냥)String producer = "김수미"; 
//	-> 전세계 모든 게장의 생산자가 김수미씨
//	=> 근데 이러면 쓰레기 코드
//	-> 이렇게 할 경우 c와 c2 모두 heap에 기본적으로 각각 김수미씨가 저장된 채로 이름, 무게, 가격 등이 저장됨
	
//	static String producer = "김수미";
//	-> 이걸 사용해라!
//	-> 이렇게 할 경우 heap이 아니라 static에 정보가 저장됨 => heap에서의 메모리 낭비를 줄일 수 있음
//	-> producer 정보는 애초에 static으로 빠지고, 
//	   heap에 생성되는 c나 c2의 정보는 name, weight, price만 담도록 생성됨
	
//	객체들의 공통속성을 기본값(전세계 모든 게장의 생산자가 김수미)으로 부여하고 싶으면 어떻게??

//	static -> 객체들에게 공통속성 부여
	
	
//	멤버변수는 자동 초기화됨
//	숫자: 0
//	참조형: null
	
	
	
	public void printInfo() {
		System.out.printf("품명: %s\n", name);
		System.out.printf("무게: %.1fkg\n", weight);
		System.out.printf("가격: %d원\n", price);
		System.out.printf("생산자: %s\n", producer);
	}
	
	public static void test() {
//		System.out.println(name);
//		static 메소드에서 static 아닌거 사용 불가
		System.out.println(producer);
	
	}
}
