
public class PPSMain {

	public static void main(String[] args) {
		int option = 6;
		
		String[] items = {"주차장", "와이파이", "흡연실", "24시간"};
		
		
		for (int i = items.length-1; i>=0; i--) {

			if (option >= 1 << i) {
				System.out.println(items[i]);
				option -= 1 << i;
			}
		
		}
	}

}
