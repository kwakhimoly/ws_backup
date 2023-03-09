package com.kwak.dec162uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class UMain6 {
	public static void main(String[] args) {

		BufferedReader br = null;
		String line = null;
		String nT = null;
		StringTokenizer st = null;
		String name = null;
		int c = 0;

		HashMap<String, Integer> hm = new HashMap<>();
		try {
			for (int i = 1; i < 11; i++) {
				String fileName = String.format("[이문열]삼국지 %02d.txt", i);
				FileInputStream fis = new FileInputStream(
						"C:\\Users\\user\\Downloads\\자원2021\\for BigData\\이문열 삼국지\\" + fileName);
				InputStreamReader isr = new InputStreamReader(fis, "euc-kr");
				br = new BufferedReader(isr);
				while ((line = br.readLine()) != null) {
					st = new StringTokenizer(line, " "); // 나눠서 쭉 나열할 비정형 데이터에는 Tokenizer 사용이 더 나음
					while (st.hasMoreTokens()) {
						nT = st.nextToken();
//						() 달린거는 쓸 때마다 실행이 새로 되는거니까 변수 부여해서 하나로 만들어야지 -> k.next() 나, st.nextToken()이나...
//						변수 자체를 모르나바...😳😳
						if (nT.contains("유비")) {
							name = "유비";
						} else if (nT.contains("조조")) {
							name = "조조";
						} else if (nT.contains("장비")) {
							name = "장비";
						}

						if (name != null) {
							if (hm.containsKey(name)) {
								c = hm.get(name);
								c += 1;
								hm.put(name, c);
							} else {
								hm.put(name, 1);
							}
						}
					}
				}

			}

			Set<String> s = hm.keySet();
			ArrayList<String> al = new ArrayList<>(s);
			for (String string : al) {
				System.out.println(string);
				System.out.println(hm.get(string));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
