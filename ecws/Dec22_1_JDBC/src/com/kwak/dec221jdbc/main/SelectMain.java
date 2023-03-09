package com.kwak.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectMain {

//	insert / update / delete : 데이터 몇 개가 영향 받았나
//	select : 데이터들

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // list에 더 가까움

		try {
			String url = "jdbc:oracle:thin:@192.168.0.3:1521:xe";
			con = DriverManager.getConnection(url, "khy", "sol0415");

			String sql = "select * from dec22_store order by s_name";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
//			rs.next(); => 커서를 다음 데이터로
//						  다음 데이터가 있으면 true
//						  다음 데이터가 없으면 false
//			rs.getXXX("필드명");
//			rs.getXXX(필드번호); => 이것도 가능 : 근데 굳이?
			
			while (rs.next()) {
				System.out.print(rs.getString("s_name")+","+rs.getString("s_addr")+","+rs.getInt("s_size")+"\r\n");
				System.out.println("========");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {rs.close();} catch (Exception e) {}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}

	}
}
