package com.kwak.dec151uc.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UCMain7_1216_3_bus {
	public static void main(String[] args) {
//		매운맛 -> 버스 => 전체 데이터는 포기하고, 연간도 힘드니깐 월간?
//		일간만 해도 -> 1~1000번 1001번~2000번..~40000번 까지 나눠서 반복문 돌려야됨 => 데이터 요청 자체가 1000개까지만 됨

		HttpURLConnection huc = null;

		try {
			URL u = new URL(
					"http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/json/CardBusStatisticsServiceNew/1/10/20220301");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
