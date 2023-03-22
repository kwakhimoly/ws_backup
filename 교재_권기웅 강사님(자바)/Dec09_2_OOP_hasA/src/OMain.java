// part2 : OOP
//		2-1 : OOP기본
//		2-2 : 객체간의 관계(has a/is a)
// 
// A has a B
// 사람 has a 개 : 반려동물

public class OMain {
	public static void main(String[] args) {
		Dog d = new Dog("후추", 2);
		d.show();
		System.out.println("-----");
		
		Human h = new Human("홍길동", 30);
		h.print();
		System.out.println("-----");
		
		Human h2 = new Human("김길동", 20, d);
		h2.print();
		System.out.println("-----");
		
		City c = new City("수원", 200, h2);
		c.showInfo();
		System.out.println("-----");
		
		// c의 이름
		System.out.println(c.name);
		
		// c에 사는 사람 이름
		System.out.println(c.ipjuja.name);
		
		// c에 사는 사람의 전체 정보
		c.ipjuja.print();
		
		// c에 사는 사람이 키우는 개 이름
		System.out.println(c.ipjuja.pet.name);
		
		// c에 사는 사람이 키우는 개 전체 정보
		c.ipjuja.pet.show();
		
		
	}
}



