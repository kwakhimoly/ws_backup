
public class RSMain5 {
	public static void main(String[] args) {
		for (String s : args) {
			System.out.println(s);
		}
		
		double[] temp = {-3, 10.5, 2, 17};
		
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
		
		System.out.println("------------");
		
		for (int i = 0; i < temp.length; i++) {
			double d = temp[i];
			System.out.println(d);
		}
		
		System.out.println("------------");
		
		for(double d : temp) {
//			배열 탐색용 foreach
			System.out.println(d);
		}
//		2번째와 3번째 같은 효과 
	}
}
