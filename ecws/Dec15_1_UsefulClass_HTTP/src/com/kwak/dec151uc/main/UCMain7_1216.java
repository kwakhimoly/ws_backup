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

public class UCMain7_1216 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			String when = "20220315";
			URL u = new URL(
					"http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/json/CardSubwayStatsNew/1/600/"
							+ when);
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject jo = (JSONObject) jp.parse(isr);
			JSONObject subwayStart = (JSONObject) jo.get("CardSubwayStatsNew");
			JSONArray row = (JSONArray) subwayStart.get("row");
			JSONObject subInfo = null;
//			객체를 받아옴 => 스트링으로 변환 => 데이트로 변환? (불가 ㅠ)

			FileOutputStream fos = new FileOutputStream("C:/kwak/httpex/subInfo/sub.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			for (int i = 0; i < row.size() /* JSON array 갯수 */; i++) {
				subInfo = (JSONObject) row.get(i); // 배열 속 나열된 객체를 순번대로 소환해야지!
				bw.write(when.substring(0, 4) + ",");
				bw.write(when.substring(4, 6) + ",");
				bw.write(when.substring(6, 8) + ",");
				bw.write(subInfo.get("LINE_NUM") + ",");
				bw.write(subInfo.get("SUB_STA_NM") + ",");
				bw.write(subInfo.get("RIDE_PASGR_NUM") + ",");
				bw.write(subInfo.get("ALIGHT_PASGR_NUM") + "\r\n");
				bw.flush();
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
