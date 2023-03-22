package com.kwon.dec233ddp.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kiung.kwon.db.manager.KwonDBManager;

// DAO/DTO패턴 : DB관련 작업이 있는 MVC패턴
// 		DAO(Data Access Object) : DB관련 작업하는 M
// 		DTO(Data Temp/Transfer Object)
public class BookDAO {
	public static ArrayList<Book> getBook() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KwonDBManager.connect("jdbc:oracle:thin:@192.168.0.32:1521:xe", "teacher", "1");
			String sql = "select * from dec22_book";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Book> books = new ArrayList<>();
			while (rs.next()) {
				books.add(
					new Book(
						rs.getString("b_title"), 
						rs.getInt("b_price")));
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KwonDBManager.close(con, pstmt, rs);
		}
	}
}
