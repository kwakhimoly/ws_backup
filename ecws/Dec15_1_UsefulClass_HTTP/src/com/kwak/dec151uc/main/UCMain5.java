package com.kwak.dec151uc.main;

import java.io.InputStream;
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
//	콘솔 저장 버전

public class UCMain5 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		try {
			String server = "http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25/";

			URL u = new URL(server);
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			int what = xpp.getEventType();
			String tagName = null;

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년,MM월,dd일,kk시");
			String now = sdf.format(new Date());
			
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (what == XmlPullParser.TEXT) {
					if(tagName.equals("MSRRGN_NM")) {
						System.out.print(now+",");
						System.out.print(xpp.getText()+",");
					} else if(tagName.equals("MSRSTE_NM")) {
						System.out.print(xpp.getText()+",");
					} else if(tagName.equals("PM10")) {
						System.out.print(xpp.getText()+",");
					} else if(tagName.equals("PM25")) {
						System.out.print(xpp.getText()+",");
					} else if(tagName.equals("IDEX_NM")) {
						System.out.println(xpp.getText());
						System.out.println("---------------------------");
					}
				} else if (what == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();
				what = xpp.getEventType();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}

}