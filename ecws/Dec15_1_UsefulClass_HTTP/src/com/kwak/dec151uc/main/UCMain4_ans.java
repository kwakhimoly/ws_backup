package com.kwak.dec151uc.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

//http://openapi.seoul.go.kr:8088/sample/xml/RealtimeCityAir/1/25/
//	=> 전체 데이터 다 보이게 1~25
//	BUT 신청해서 써야되니까 오늘은 강사님이 주신 걸로하기
//	=> http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25/

//빅데이터 모아서 분석하려면 1시간마다 실행 -> 서버에서 스케쥴러 따라서 저장 

public class UCMain4_ans {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		String server = "http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25/";
		try {
//			서울 열린 데이터 광장(실패확률 더 높음)
			URL u = new URL(server);
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			int type = xpp.getEventType();
			String tagName = null;

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시");
			String now = sdf.format(new Date());

//			내 컴의 파일(실패 확률 0)
			FileOutputStream fos = new FileOutputStream("C:\\kwak\\httpex/dustInfo/dust_ans.csv", true);
			OutputStreamWriter opsw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(opsw);

			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("MSRRGN_NM")) {
						bw.write(now + ",");
						bw.write(xpp.getText() + ",");
					} else if (tagName.equals("MSRSTE_NM")) {
						bw.write(xpp.getText() + ",");
					} else if (tagName.equals("PM10")) {
						bw.write(xpp.getText() + ",");
					} else if (tagName.equals("PM25")) {
						bw.write(xpp.getText() + ",");
					} else if (tagName.equals("IDEX_NM")) {
						bw.write(xpp.getText() + "\r\n");
						bw.flush();
					}
				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();
				type = xpp.getEventType();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
		try {
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
