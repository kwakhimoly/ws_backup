package com.kwak.dec223.daodto.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hayoung.kwak.db.manager.KwakDBManager;

public class BookDAO {
//	여기서 책 정보 출력?

	public BookDAO() {
	}

	public BookDAO(Connection con, PreparedStatement pstmt, ResultSet rs) {
		super();
		this.con = con;
		this.pstmt = pstmt;
		this.rs = rs;
	}

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public void connect() throws Exception {
		String url = "jdbc:oracle:thin:@192.168.0.4:1521:xe";
		con = KwakDBManager.connect(url, "khy", "sol0415");
	}

	public PreparedStatement getInfo(Connection con) throws Exception {
		String sql = "select b_title, b_price from dec22_bookInfo order by b_title";
		return con.prepareStatement(sql);
	}

	public ResultSet getResult(BookDAO bd) throws Exception, Exception {
		rs = bd.getInfo(con).executeQuery();
		return rs;
	}

	public void disconnect(ResultSet rs, PreparedStatement pstmt, Connection con) {
		KwakDBManager.close(con, pstmt, rs);
		System.out.println("disconnected");
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

}
