// RAM : 변수형태로 저장하는 임시저장공간
//		어쨌든 재부팅하면 지워짐
// HDD : 파일형태로 저장하는 영구저장공간

// OS가 RAM을 3공간으로 나눠서 사용
//		?
//		stack 
//			아래에서 부터 차곡차곡 쌓여가는
//			그 프로그램 종료되면 자동 반납
//		heap
//			컴이 보기에 적당한 위치에 만드는
//			재부팅할때까지는 거기 자리차지하고 있음
//			=> 수동으로 반납 해줘야

// Garbage Collection
//		heap영역 자동 반납 시스템 
//		=> 그 자동 발동 시점 : 
//			그 번지를 더이상 가리키는 변수가 없을때

public class OMain2 {
	public static void main(String[] args) {
		Chair c = new Chair();
		System.out.println(c);
		c.name = "CRN5007M";
		c.maker = "fursys";
		c.price = 171000;
		c.comfort = false;
		c.printInfo();
		System.out.println("-----");
		
		Chair c2 = new Chair();
		System.out.println(c2);
		c2.name = "asdl123";
		c2.maker = "sidiz";
		c2.price = 50000;
		c2.comfort = true;
		c2.printInfo();
		System.out.println("-----");
		
		// c가 있는데 c3로도 쓸수있게
		Chair c3 = c;
		System.out.println(c3);
		c3.price = 5000;
		c3.printInfo();
		System.out.println("-----");
		c.printInfo();
		
		// null : 참조형 변수가 아무데도 가리키지 않음
		c = null;
		// c.printInfo();
		c3 = null;
		// 3번지 의자 삭제
		
		System.out.println("ㅋ");
	}
}








