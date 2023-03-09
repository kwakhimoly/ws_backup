
public class OMain2 {

	public static void main(String[] args) {		
		Movie b = new Movie();
		
		b.name = "본즈 앤 올";
		b.director = "루카 구아다니노";
		b.actor = "테일러 러셀, 티모시 샬라메";
		b.year = 2022;
		b.month = 11;
		b.day = 30;
		b.genre = "공포, 로맨스, 멜로";
		b.fun = true;
		
		System.out.println(b);
		b.printInfo();
		
		System.out.println("-----------");
		
		Movie n = new Movie();
		
		n.name = "녹터널 애니멀스";
		n.director = "톰 포드";
		n.actor = "에이미 아담스, 제이크 질렌할, 마이클 섀넌, 애런 존슨";
		n.year = 2017;
		n.month = 01;
		n.day = 11;
		n.genre = "스릴러, 드라마";
		n.fun = false;
		System.out.println(n);
		n.printInfo();
		
		System.out.println("-----------");
		
		
		
		
//		b와 같은 정보의 영화 하나 더 -> 아예 코드 자체를 복사해서 적어야함
		
		Movie b2 = b; 
//		b가 있는데 b2로도 쓸 수 있게 해줘라 
//		-> 이름 하나 더 달아주자(!똑같은 정보의 완전 다른 영화 하나 만들자)
		b2.actor = "테일러 러셀, 티모시 샬라말라빙봉";
		System.out.println(b2); // == System.out.println(b); => 같은 위치에 저장
		b2.printInfo();
//		이렇게 하면 속성 중 하나를 변경했을 때 첫번째 본즈앤올 또한 변함
		
		System.out.println("-----------");
		
		System.out.println(b);
		b.printInfo();
//		첫번째 본즈앤올이지만 actor 부분이 샬라말라빙봉으로 변함 
//		=> 같은 위치의 정보값을 변경했기 때문에 정보값 자체가 변한 것
		
		b = null; // b 본즈앤올의 위치 정보(stack에 저장한 3번지) 아예 없애기
//		b.printInfo(); -> 안나옴
		/* => Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Movie.printInfo()" because "b" is null
		at OMain2.main(OMain2.java:57)*/
//		대신 본즈앤올 정보의 위치는 b2에 저장되어 있음(null 처리 안해서)
		b2 = null; // 본즈앤올의 위치 정보 아예 없애기
		/*
		 본즈앤올의 정보가 쓰여질 곳이 없어지기 때문에 
		 Garbage Collection 발동돼서 heap의 본즈앤올 정보가 아예 사라짐
		 */ 
	}

}
