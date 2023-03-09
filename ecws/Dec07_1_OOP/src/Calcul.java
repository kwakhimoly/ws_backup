/*
 계산기의 속성
 : 가격, 모델명, 무게 등
 : int a, int b 같은건 속성이 아님
 	-> 그건 메소드 변수로 포함시키고!
 */



public class Calcul {
	int price;
	
	public void printPlus(int x, int y) {
		int z = x + y;
		System.out.println(z);
	}
}
