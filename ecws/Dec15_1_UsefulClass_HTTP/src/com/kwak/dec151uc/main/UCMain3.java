package com.kwak.dec151uc.main;

//import java.io.BufferedReader;
import java.io.InputStream;
//import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

//데이터 parsing
//	=> 데이터 가공 (쓸 데 없는 거 떼고 ....해서 원하는 형태로 만들기)

//IT 바닥
//	제 3자한테 데이터를 주고 싶었는데
//	정해진 형식으로 줘야, 사용자가 split을 할 수 있을 것
//	데이터를 HTML 모양으로 표현: XML
//	시작태그 텍스트 종료태그 -> 한 세트 => DOM(DocumentObjectModel)객체
//	<학생들> : start tag(시작 태그)
//	홍길동 : text(텍스트)
//	</학생> : 종료 태그
//			<학생들> 
//				<학생>
//					<이름>홍길동</이름>
//					<나이>20</나이>
//				</학생> 
//				<학생>
//					<이름>김길동</이름>
//					<나이>22</나이>
//				</학생>
//			</학생들>
//	XML parsing: 관련 기능이 자바에 없음
//				kxml -> android에 내장되어 있어서

//	데이터를 JavaScript 모양으로 표현: JSON
public class UCMain3 {
	public static void main(String[] args) {

		HttpsURLConnection huc = null;
		try {
			String server = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
			URL u = new URL(server);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is, "utf-8");
//			BufferedReader br = new BufferedReader(isr);
//			String line = null;
//
//			while ((line = br.readLine()) != null) {
//
//				System.out.println(line);
//			} => xpp로 내용 빨아들이려면 여기서 빨아들이면 안됨!

//			객체
//				필요없으면 안 만들고 static 메소드 기반
//				필요하면
//						1개? -> singleton 패턴
//						여러개?
//								대량생산 규칙성: factory 패턴 => XmlPullParser
//													-> 공장에서 만들 듯이

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");
//			=> parsing할 사람 입에 빨대(stream) 물려주기 -> br이나 isr 써도 됨

//			지금 빨아낸 게 그 셋(시작태그, 텍스트, 종료태그) 중에 뭐야?
			int what = xpp.getEventType(); // 지금 갖고 있는 xml은 시작태그
//			0: 시작		1: 텍스트	  2: 종료
			String tagName = null;

			while (what != XmlPullParser.END_DOCUMENT /* 빨아낸게 문서 끝이 아닐 동안 */) {
				// 빨아낸 거 -> 처리
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
//					System.out.println(xpp.getName());
				} else if (what == XmlPullParser.TEXT) {
					if (tagName.equals("hour")) {
						System.out.println("~"+xpp.getText()+"시까지");
					} else if(tagName.equals("temp")) {
						System.out.println(xpp.getText()+"℃");
					} else if(tagName.equals("wfKor")) {
						System.out.println(xpp.getText());
						System.out.println("-------");
					}
				} else if (what == XmlPullParser.END_TAG) /* else 쓰면 안됨 세 종류 말고 더 있어서 */ {
					tagName = ""; // tagName 초기화 해서  \r\n은 안 불러오게끔
//					System.out.println(xpp.getName());
				}
				xpp.next(); // 그 다음거 빨기
				what = xpp.getEventType(); // 빨아낸 거 뭐냐
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
