package com.kwak.dec223.daodto.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hayoung.kwak.db.manager.KwakDBManager;

public class BookDAO {

	public static ArrayList<Book> getBook() {
//		메소드 이름 -> 의미 파악해서 정확하게 
//		(동사목적어)
//		abcd 순서 정렬 -> 동사(등록, 삭제 등등..) 중심 정렬
//		(목적어동사)
//		abcd 순서 정렬 -> 주제(목적어: 책, 지점  등등..) 중심 정렬
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			데이터 연결
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.4:1521:xe", "khy", "sol0415");
			
//			데이터 확보
			String sql = "select * from dec22_bookInfo order by b_price";
			
//			총괄객체
			pstmt = con.prepareStatement(sql);
			
//			select 실행
			rs = pstmt.executeQuery();
			ArrayList<Book> books = new ArrayList<>();
			
//			V: 디자이너 : java 못하니까 -> 작업 난이도를 낮춰놔야
			while (rs.next()) {
				Book b = new Book(rs.getString("b_title"), 
						rs.getInt("b_price"), 
						rs.getString("b_genre")); //한바퀴 돌때마다 새 책
				books.add(b); //만들어진 책 ArrayList에 추가
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
		KwakDBManager.close(con, pstmt, rs);
		}
	}
	
}
