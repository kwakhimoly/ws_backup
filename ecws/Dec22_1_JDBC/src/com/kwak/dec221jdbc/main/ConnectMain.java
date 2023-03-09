package com.kwak.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;

//통신
//	HTTP 통신: 요청 - 응답
//	Socket 통신: 실시간
//	
//	DB 서버랑 통신 : 표준화된 형식이 따로 없음 -> DB 메이커가 다양해서
//			=> Oracle DB
//			=> MySQL
//			=> Maria DB
//			=> SQLPlus
//	Java 에서 통신은 가능 -> 최종적으로 그 서버 연결에 쓸 Driver를 만들어줄 수가 ... => 만들어서 써야 됨

public class ConnectMain {

	public static void main(String[] args) {
		Connection con = null;

		try {
//		연결할 때 쓸 드라이버 지정
//					: OracleDriver 자동완성 해서 import 한 다음에 주소 복사 붙여넣기
//			Class.forName("oracle.jdbc.driver.OracleDriver"); 
//					=> 굳이 안 써도 java가 주소 보고(무슨 db인지 알 수 있으니까) 알아서 찾음
//					=> JSP/Spring 은 못 찾으니까 거기서 JDBC방식으로 연결할거면 따로 써줘야함

//		연결할 DB서버 주소[DB 메이커별로 양식이 다 다름]
			String url = "jdbc:oracle:thin:@192.168.0.3:1521:xe";

//		연결
			con = DriverManager.getConnection(url, "khy", "sol0415");
			System.out.println("성공");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {con.close();} catch (Exception e) {} // 별로 영양가 없음 -> 닫는거 실패해도 뭐.. 어쩌라고..

	}
}
