package com.kwon.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

// 지점명 : 
public class DeleteMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.32:1521:xe";
			con = DriverManager.getConnection(url, "teacher", "1");
			
			System.out.print("매장명 : ");
			String n = k.next();
			
			String sql = "delete from dec22_jijum where j_name = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			} else {
				System.out.println("없다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
		k.close();
	}
}



