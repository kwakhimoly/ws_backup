package com.kwon.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 연결
			String url = "jdbc:oracle:thin:@192.168.0.32:1521:xe";
			con = DriverManager.getConnection(url, "teacher", "1");
			
			// 데이터 확보
			System.out.print("지점명 : ");
			String n = k.next();
			System.out.print("주소 : ");
			String a = k.next();
			System.out.print("매장크기 : ");
			int s = k.nextInt();

			// SQL(미완성)
			// 		값 들어갈 부분은 ?로 처리해서 
			//		;빼고
			//		띄어쓰기 주의
			String sql = "insert into dec22_jijum values(?, ?, ?)";
		
			// DB관련작업들 다 해주는 1회용 매니저
			pstmt = con.prepareStatement(sql);
			
			// sql완성 : pstmt.setXXX(번호, 값);
			pstmt.setString(1, n);
			pstmt.setString(2, a);
			pstmt.setInt(3, s);
			
			// DB서버로 전송해서 실행하고 결과 받아오기
			int row = pstmt.executeUpdate();
			
			if (row == 1) {
				System.out.println("등록 성공");
			} else {
				System.out.println("?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
		k.close();
	}
}






