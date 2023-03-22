package com.kwon.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.32:1521:xe";
			con = DriverManager.getConnection(url, "teacher", "1");
			
			String sql = "select * from dec22_jijum order by j_name";
			
			pstmt = con.prepareStatement(sql);

			// C/U/D : 데이터 몇 개가 영향받았나
			// int row = pstmt.executeUpdate();

			// R : 데이터들
			rs = pstmt.executeQuery();
			
			// rs.next()
			//		커서를 다음 데이터로
			//		그게 있으면 true, 없으면 false
			while (rs.next()) {
				// rs.getXXX("필드명")
				System.out.println(rs.getString("j_name"));
				System.out.println(rs.getString("j_where"));
				System.out.println(rs.getInt("j_size"));
				System.out.println("-----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {rs.close();} catch (Exception e) {}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
	}
}
