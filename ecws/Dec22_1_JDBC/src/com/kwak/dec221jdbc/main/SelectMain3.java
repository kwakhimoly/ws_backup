package com.kwak.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectMain3 {

//	insert / update / delete : 데이터 몇 개가 영향 받았나
//	select : 데이터들

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		Scanner k = new Scanner(System.in);
		
		try {
			String url = "jdbc:oracle:thin:@192.168.0.3:1521:xe";
			con = DriverManager.getConnection(url, "khy", "sol0415");
			
			System.out.print("지점명:");
			String n = k.next();
			
			String sql = "select b_genre, avg(b_price) as avg_price from DEC22_BOOKINFO where b_no in "
					+ "(select sl_b_no from DEC22_SELL where sl_s_name like '%'||?||'%') group by b_genre order by b_genre desc";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, n);
			
			rs = pstmt.executeQuery();

			
			
			while (rs.next()) {
				System.out.println("========");
				System.out.println(rs.getString("b_genre"));
				System.out.println(rs.getDouble("avg_price"));
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
