package com.kwak.dec162uc.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

//List 계열: 가변 사이즈 배열
//Set 계열 : 중복x -> 넣으면 안되는건 아닌데 넣어도 알아서 없앰 -> 기본형급은 가능한데...(모든 기본형도 아님..)
//Map 계열 : 순서 개념 x, 키 -> 값
//		(python: dict, obj-c: NSDictionary)
public class UMain5 {
	public static void main(String[] args) {
		HashMap<String, Double> hm = new HashMap<>(); // String으로 찾으면 Double 나오게
		hm.put("서울", -10.5);
		hm.put("수원", -13.5);
		hm.put("인천", -12.5);
		hm.put("인천", -2.5);
		System.out.println(hm.get("서울"));
		System.out.println(hm.get("인천")); // 중복된 키에 다른 값을 부여하면 가장 마지막에 넣은 값이 나옴
		
		System.out.println(hm.containsKey("수원")); // 확인하고 싶은 키가 들어있는지 boolean으로 확인
		
		Set<String> s = hm.keySet(); //map에서 key만 추출해서 set으로 줌 
//		Set<key 형식> ___ = 맵이름.keySet();
		ArrayList<String> al = new ArrayList<>(s); //set을 list로 바꿔서 for문에 사용
		
		Comparator<String> c = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		
		al.sort(c);
		
		for (String string : al) {
			System.out.println(string);
			System.out.println(hm.get(string));
		}
	}
}
