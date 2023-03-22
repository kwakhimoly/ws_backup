package com.kwon.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// 지점명 : 강
// -----------------
// 삼국지1, 소설, 20000, 2001/01/01
// ...

// 최종기술 MyBatis가 java.util.Date를 쓰니
// java.util.Date <-> java.sql.Date 그냥 됨

public class SelectMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.32:1521:xe";
			con = DriverManager.getConnection(url, "teacher", "1");
			
			System.out.print("지점명 : ");
			String n = k.next();
			
			String sql
					= "select b_title, b_cate, b_price, b_when "
					+ "from dec22_book "
					+ "where b_no in ( "
					+ "		select s_b_no "
					+ "		from dec22_sell "
					+ "		where s_j_name like '%'||?||'%' "
					+ ")";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd (E)");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("b_title"));
				System.out.println(rs.getString("b_cate"));
				System.out.println(rs.getInt("b_price"));
				System.out.println(sdf.format(rs.getDate("b_when")));
				System.out.println("-----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {rs.close();} catch (Exception e) {}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
		k.close();
	}
}
