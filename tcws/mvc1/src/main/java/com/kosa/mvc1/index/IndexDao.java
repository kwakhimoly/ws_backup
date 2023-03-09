package com.kosa.mvc1.index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kosa.mvc1.DBUtil;

public class IndexDao {
//		생성자에서 DB모듈을 불러와야 한다.
//		그래야 객체 만들 때 자동으로 호출 된다. 
	public IndexDao() {

		try {
			Class.forName(DBUtil.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public List<IndexDto> getText(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<IndexDto> listTxt = new ArrayList<IndexDto>();

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			String sql = "select a.seq, a.title, a.user_name from "
					+ "(select a.seq, a.title, b.user_name from tb_guestbook a left outer join tb_member b on a.writer = b.user_id order by seq desc) a "
					+ "where rownum<=9";
			//서브쿼리 활용
//			sql = 
//			"select A.seq, a.title, 
//			(select user_name from tb_member b where a.writer=b.user_id) user_name 
//			from (select seq, title, writer from tb_guestbook a order by seq desc) a where rownum<=9";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				IndexDto dto = new IndexDto();
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("user_name"));
				listTxt.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listTxt;
	}

	public List<IndexDto> getView() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<IndexDto> listImg = new ArrayList<IndexDto>();

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			String sql = "select seq, image from (select * from tb_gallery order by seq desc) where rownum<=5";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				IndexDto dto = new IndexDto();
				dto.setSeq(rs.getString("seq"));
				dto.setImage(rs.getString("image"));
				listImg.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listImg;
	}
}
