package com.kwak.dec221jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		Scanner k = new Scanner(System.in);
		try {
			String url = "jdbc:oracle:thin:@192.168.0.3:1521:xe";
			con = DriverManager.getConnection(url, "khy", "sol0415");
			
			System.out.print("지점명: ");
			String n = k.next();
			

			String sql 	= "delete from dec22_store where s_name = ?";

			psmt = con.prepareStatement(sql);	
			
			psmt.setString(1, n);

			if(psmt.executeUpdate()==1) {
				System.out.println("success");
			} else {
				System.out.println("null");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {psmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
		k.close();
		
	}
}
