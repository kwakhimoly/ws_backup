package com.kwon.dec162uc.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

// [] : 0 -> ㅋ
// List계열 : 0 -> ㅋ
// Set계열 : 0 -> ?
// Map계열 : 순서x, 키 -> 값  
public class UCMain5 {
	public static void main(String[] args) {
		HashMap<String, Double> hm = new HashMap<>();
		hm.put("서울", -10.5);
		hm.put("수원", -13.5);
		hm.put("인천", -23.5);
		hm.put("서울", -1.5);
		System.out.println(hm.get("서울"));
		
		System.out.println(hm.containsKey("인천"));
		
		Set<String> s = hm.keySet();
		ArrayList<String> al = new ArrayList<>(s);
		for (String string : al) {
			System.out.println(string);
			System.out.println(hm.get(string));
		}
	}
}


