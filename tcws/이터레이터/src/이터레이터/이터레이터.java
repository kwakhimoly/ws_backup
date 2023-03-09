package 이터레이터;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class 이터레이터 {
	public static int add(int x, int y) {
		x *= 2;
		y *= 3;
		return x;
	}
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		
		x = add(x,y);
		
		System.out.println(x);
		System.out.println(y);
		
		List<String> list = new ArrayList<>();
		list.add("사과");
		list.add("수박");
		list.add("배");
		list.add("포도");
		list.add("자몽");
		list.add("바나나");

		Iterator<String> it = list.iterator();
		while (it.hasNext()) { // 다음 요소가 있으면 true
			System.out.println(it.next());
//		next 함수: 현재 요소를 반환하고 다음 요소로 이동			
		}

		HashMap<String, String> map = new HashMap<>();
		map.put("one", "un");
		map.put("two", "deux");
		map.put("three", "trois");
		map.put("four", "quatre");

		Iterator<String> key = map.keySet().iterator();
		while (key.hasNext()) {
			String k = key.next();
			System.out.println(k + "===>" + map.get(k));
		}
	}
}
