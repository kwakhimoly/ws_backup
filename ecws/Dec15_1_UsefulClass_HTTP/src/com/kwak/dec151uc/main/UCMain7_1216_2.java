package com.kwak.dec151uc.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UCMain7_1216_2 {
	public static void main(String[] args) {


		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {

			FileOutputStream fos = new FileOutputStream("C:/kwak/httpex/subInfo/subY.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			String when = null;
			for (int year = 2015; year < 2022; year++) {
				for (int month = 1; month < 13; month++) {
					for (int day = 1; day < 32; day++) {
						when = String.format("%d%02d%02d", year, month, day);
//						%02d => 빈자리 0 채워서 두 자릿수 정수로 표현

						URL u = new URL(
								"http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/json/CardSubwayStatsNew/1/600/"
										+ when);
						huc = (HttpURLConnection) u.openConnection();
						InputStream is = huc.getInputStream();
						InputStreamReader isr = new InputStreamReader(is, "utf-8");

						JSONParser jp = new JSONParser();

						JSONObject jo = (JSONObject) jp.parse(isr);
						JSONObject subwayStart = (JSONObject) jo.get("CardSubwayStatsNew");
						if (subwayStart != null) {
//							null인 경우 자동으로 지나침
							JSONArray row = (JSONArray) subwayStart.get("row");
							JSONObject subInfo = null;

							for (int rowNum = 0; rowNum < row.size(); rowNum++) {
								subInfo = (JSONObject) row.get(rowNum);
								bw.write(when.substring(0, 4) + "," + when.substring(4, 6) + "," + when.substring(6, 8)
										+ ",");
								bw.write(subInfo.get("LINE_NUM") + "," + subInfo.get("SUB_STA_NM") + ","
										+ subInfo.get("RIDE_PASGR_NUM") + "," + subInfo.get("ALIGHT_PASGR_NUM")
										+ "\r\n");
								bw.flush();
							}
//							System.out.println(when); -> 작업이 되고 있는지 궁금하니까 하루치 끝날 때마다 콘솔에 표시하기
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
