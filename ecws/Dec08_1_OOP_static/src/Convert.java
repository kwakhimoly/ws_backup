
public class Convert {
//	cm, inch는 속성이라고 할 수 없음(단위 변환기의 속성이려면 가격 이런거)
//	다만 계산에 필요한 항목이기 때문에 ↓↓
	public static void toInch(double cm) {
//		굳이 stack에 정보를 저장할 필요가 없기 때문에 객체를 안 만들어도 쓸 수 있는 static으로 작성
		System.out.println(cm/2.54);
	}
}
