package com.kwak.dec223.daodto.main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsoleScreen {
	
	public static void print(BookDAO bd) throws SQLException, Exception {
		ResultSet rs = bd.getResult(bd);
		while (rs.next()) {
			System.out.println(rs.getString("b_title"));
			System.out.println(rs.getInt("b_price"));
		}
	}
	
	
}
