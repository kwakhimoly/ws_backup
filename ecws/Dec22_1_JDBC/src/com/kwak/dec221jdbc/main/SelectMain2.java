package com.kwak.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SelectMain2 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner k = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.3:1521:xe";
			con = DriverManager.getConnection(url, "khy", "sol0415");
			k = new Scanner(System.in);
			
			System.out.print("지점명: ");
			String n = k.next();
			
//			String sql = "select * from dec22_bookinfo where b_no in (select sl_b_no from dec22_sell where sl_s_name =?)";
			String sql = "select * from dec22_bookinfo where b_no in "
					+ "(select sl_b_no from dec22_sell where sl_s_name like '%'||?||'%')";
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd (E)");
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("b_title"));
				System.out.println(rs.getString("b_genre"));
				System.out.println(rs.getInt("b_price"));
				System.out.println(sdf.format(rs.getDate("b_date")));
				System.out.println("-----------------------");
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
