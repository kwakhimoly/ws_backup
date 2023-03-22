// 함수 recursive 호출
//		재귀적
//		1. 대부분 수업 안함
//		2. 그나마 하는데 
//			지금 같은 계산문제 : 반복문으로 해야
//								 recursive로? => 자기자랑

// 함수를 쓴다
//		jump연산 : 시간을 잡아먹는거 -> 느려짐
//		정리 차원에서 쓰는거(유지보수의 시대라서...)

public class FMain2 {
	
	
	// 정수 하나 넣을건데
	// 1 + 2 + 3 + 4 + ... + 그 수 =
	// 를 구하는 함수
	public static int getHab(int i) {
		return (i == 1) ? 1 : (getHab(i - 1) + i);
	}

	// getFact(4) = getFact(3)          * 4
	//				getFact(2)      * 3	
	//				getFact(1) * 2
	//				1
	
	// 정수하나 넣으면 factorial구하는 함수
	// 3! = 1 * 2 * 3
	public static int getFact(int x) {
		return (x == 1) ? 1 : (getFact(x - 1) * x);
	}
	
	// 정수 하나 넣으면 피보나치수열값 구하는 함수
	// 1 2 3 4 5 6 7  8  9
	// 1 1 2 3 5 8 13 21 34
	public static int getFibo(int as) {
		return (as < 3) ? 1 : (getFibo(as - 2) + getFibo(as - 1));
	}
	
	// getFibo(5) : getFibo(3)               + getFibo(4)
	//				getFibo(1) + getFibo(2)  + getFibo(2) + getFibo(3)
	//				1		   + 1			 + 1		  + getFibo(1) + getFibo(2)
	//													  + 1          + 1				

	public static void main(String[] args) {
		int ans3 = getFibo(5);
		System.out.println(ans3);
		System.out.println("-----");
		
		int ans2 = getFact(4);
		System.out.println(ans2);

		System.out.println("-----");
		int ans = getHab(4);
		System.out.println(ans);
	}

}
