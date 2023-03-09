package com.kwak.dec151uc.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

//http: 일반 -> 보안 취약
//https: 보안 (인증서 세팅~어쩌고저쩌고~) => 요즘은 이걸 기본으로 사용
//	=> 이거 할 수 있게 해달라고 후속강사한테 부탁하래
//	s 차이 잘 체크하기

public class UCMain2 {
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		try {
			String server = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
			URL /* =>(java.net) */ u = new URL(server);
//			여기부터 http랑 https 갈림 => 주소 보고 맞춰서 쓰기
//			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc = (HttpsURLConnection) u.openConnection(); // 자바가 객체를 만들때 사용자가 어떤 형식을 사용할지 몰라서 다형성으로
															// 만들었으니 원하는 형으로 형변환 해줘야함
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
//		Stream 시리즈는 닫아야 함
//			=> 연관된거는 그 중에 하나만 닫아도 됨
//		huc도 Stream과 연관되어 있음! -> huc 자체를 닫으면 됨(기상청과의 연결 자체를 끊기)
//		try에서 무슨 일이 일어나도 닫혀야 하니까 huc 선언을 try 밖에서 한 후(main 아랫줄)->try 밖에서 disconnect
		huc.disconnect();

//		세션: 연결해놓고 지정값(기본값 30분) 동안 작업 없으면 자동으로 끊김
//		서버
//			초보 개발자가 연결 안 끊고 냅두면 => 서버가 알아서 자름
	}

}
