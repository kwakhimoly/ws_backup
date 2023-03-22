package com.kwon.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;

// DB메이커는 다양한데 그것들이 통신방식 다 다르고
// Java입장에서 그 다양한 메이커들 통신을 작업해줄수가
// => 통신은 가능한데, 
//	  최종적으로 그 서버에 연결에 쓸 Driver를 만들어줄수가...

// DB서버랑 통신
//		OracleDB
//		MySQL
//		MariaDB
//		SQLPlus
//		...

// OracleDB를 원격제어하고싶은데
// 정품프로그램 : sqlplus -> 불편
// 뭐 좋은 거 없나 찾다가 발견한 사제품 : eclipse
// eclipse로 OracleDB 원격제어 하자
// 안해도됨

// OracleDB랑 연동되는 Java프로그램을 만들고 싶은데
// driver는 없고
// 다른 개발자가 만들어준 .jar가져온거
// 필수

// java프로그램 최종적으로 실행하는 사용자 컴에는 eclipse없음

// OracleDB에 연결할때 쓸 Driver를 만들어야
// Oracle사에 소속된 자바개발자가 만들어준 .jar
// ojdbc8.jar -> instantclient폴더
public class ConnectMain {
	public static void main(String[] args) {
		Connection con = null;
		try {
			// 연결할 때 쓸 드라이버 지정
			// 주소만 봐도 무슨 DB인지 알 수 있으니 주소 보고 알아서 함
			// 근데 JSP/Spring가서 JDBC방식으로 연결할거면 써야함
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 연결할 DB서버 주소[DB메이커마다 양식 다름]
			String url = "jdbc:oracle:thin:@192.168.0.32:1521:xe";
			// 연결
			con = DriverManager.getConnection(url, "teacher", "1");
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {con.close();} catch (Exception e) {}
	}
}






