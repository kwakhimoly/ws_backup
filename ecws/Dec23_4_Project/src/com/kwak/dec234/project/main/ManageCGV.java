package com.kwak.dec234.project.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hayoung.kwak.db.manager.KwakDBManager;

public class ManageCGV {
//	연결
//	등록
//	조회
//	삭제
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection con = null;		
	
	public Connection connect() {
		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("connect fail");
		}
		return con;
	}
	
	public void setCGV(Connection con, String name, String location, int room) throws Exception {

		String sql = "insert into dec23_cgv values(?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, location);
		pstmt.setInt(3, room);
		
		int row = pstmt.executeUpdate();
		if(row==1) {
			System.out.println("success");
		} else {
			System.out.println("null");
		}
	}
	
	public void deleteCGV(Connection con, String name) throws Exception {
		
		String sql = "delete from dec23_cgv where cgv_name = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		
		
		int row = pstmt.executeUpdate();
		if(row==1) {
			System.out.println("success");
		} else {
			System.out.println("null");
		}
	}
	
	public ArrayList<CGV> getCGV(Connection con) throws Exception {
		String sql = "select * from dec23_cgv order by cgv_name";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<CGV> cgv = new ArrayList<>();
		
		while (rs.next()) {
			CGV c = new CGV(rs.getString("cgv_name"), rs.getString("cgv_location"), rs.getInt("cgv_room"));
			cgv.add(c);
		}
		
		return cgv;
	}
	
	public void diconnect(Connection con, PreparedStatement pstmt, ResultSet rs) {
		KwakDBManager.close(con, pstmt, rs);
	}
}
