package com.kwon.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import kiung.kwon.db.manager.KwonDBManager;
// 지점명 : 강
// -----------------
// 소설  30021.123
// IT 	 20490.126

// 카테별 평균가

public class SelectMain3 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.32:1521:xe";
			con = KwonDBManager.connect(url, "teacher", "1");
			
			System.out.print("지점명 : ");
			String n = k.next();
			
			String sql 
					= "select b_cate, avg(b_price) as avg_price "
					+ "from dec22_book "
					+ "where b_no in ( "
					+ "		select s_b_no "
					+ "		from dec22_sell "
					+ "		where s_j_name like '%'||?||'%' "
					+ ") "
					+ "group by b_cate "
					+ "order by b_cate";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("b_cate"));
				System.out.println(rs.getDouble("avg_price"));
				System.out.println("-----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		KwonDBManager.close(con, pstmt, rs);
		k.close();
	}
}



