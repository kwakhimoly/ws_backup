
public class OMain2 {
	public static void main(String[] args) {
//		이름이 1 강의실, 자리수가 30개 강의실
//		이름이 전자동 커피메이커, 가격이 50만원인 커피머신
//		커피 뽑아보기
		
//		ClassRoom cr = new ClassRoom("1강의실", 30);
//		이거 굳이 안해도 됨 -> static은 객체 안 만들어도 쓸 수 있으니깐!!
		
		ClassRoom.machine.takeShot();
//		↑↓ 같은 형식!		
		System.out.println("asd");
//		PrintSystem ps = System.out;
//		ps.println("asd");
		/*
		 * Win 시스템 
		 * Linux 시스템
		 * 그 시스템들이 JVM 체제 하에 콘솔창을 같이 써서
		 * -> System.out.println(); : static
		 */
		
		
	}
}
