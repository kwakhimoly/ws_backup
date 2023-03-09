package com.kwak.dec151uc.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

//서버: 서비스를 제공하는 컴
//클라이언트: 서비스를 이용하는 컴

//JSP/Spring: 로 HTTP 서버 하자
//		=> 웹 개발 기술 -> 포털 사이트 만들자
//						   데이터만 줄 수도 있어야

//조건문
//반복문
//배열 -> 다 할 수 있고
//그 언어만의 특징:
//		java -> 남의 .jar 잘 쓰자
//				OOP 잘 활용하자
//	=> HTTP 클라이언트 활용 가능 -> 그 언어 잘 쓸 수 있는거

//어제: 데이터 분석
//오늘: 웹+데이터

//분석용 데이터 구축 -> 남의 HTTP 들어가서 구해야지!

//남의 HTTP 서버
//자바 HTTP 클라이언트 하자

//통신
//	HTTP 통신(인터넷): 요청 -> 응답 통신
//	Socket 통신(카톡): 실시간 통신

//(일반적으로 자바수업에는 socket 통신이 빠짐)

//자바에 HTTP 통신 기능이 없음 => 중요한데 왜?? -> 버전 올라가면서 최근에 추가 됨
//	Stream 기능 활용해야 하나?
//	=> 다른 개발자는 만들어 놨을 것! -> 이걸 찾아다 써야지
//	https://apache.org/
//	=> https://hc.apache.org/downloads.cgi httpcomponent-client 4.5.14 다운로드 -> jar 파일 import
public class UCMain {
	public static void main(String[] args) {
		try {
			DefaultHttpClient dhc = new DefaultHttpClient(); // 객체 생성
//			=> deprecated
//				But HTTP 통신 과정이 잘 보여져서 한 번 해봤다~ 이젠 이거 쓸 필요 없음
			
//		Get 방식 요청
			HttpGet hg = new HttpGet("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000"); // 날씨 데이터 뽑아준 주소
																									// String으로 입력
			HttpResponse hr = dhc.execute(hg); // 응답 = 요청;
			
//			응답 내용만 get
			HttpEntity he = hr.getEntity();
			
			/*	DDoS
			 * while (true) { HttpEntity he = hr.getEntity(); Tread.sleep(1000);}
			 */
			
//			utf-8로 줌
			InputStream is = he.getContent(); //정보를 1byte씩 가져오기
			InputStreamReader isr = new InputStreamReader(is, "utf-8"); //디코딩 형식 지정
			BufferedReader br = new BufferedReader(isr); //가져오는 양 늘리기!
			String line = null;
			
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
