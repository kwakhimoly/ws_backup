package com.kosa.mvc1.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kosa.mvc1.DBUtil;

public class MemberDao {

	public MemberDao() {
		super();
		try {
			Class.forName(DBUtil.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 아이디 중복체크하기. 만일 아이디가 이미 있으면 true, 없으면 false 반환. -> 이 함수의 호출값이 false일 때 사용가능한
	// 아이디가 된다.
	public boolean isDuplicate(String user_id) {
		String sql = "select count(*) cnt from tb_member where user_id='" + user_id + "'";

		Connection conn = null;
		Statement stmt = null; // java.sql
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			System.out.println(sql);

			rs = stmt.executeQuery(sql); // 쿼리 실행 후 결과집합을 반환한다

			if (rs.next()) {
				if (rs.getInt("cnt") == 0) {// 사용가능
					return false;
				} else {
					return true;
				}
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
		return true;
	}

	public boolean insert(MemberDto dto) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into tb_member (member_id, user_id, user_name, password, email, phone) values ");
		buffer.append("(sq_member.nextval");
		buffer.append(", '" + dto.getUser_id() + "' ");
		buffer.append(", '" + dto.getUser_name() + "' ");
		buffer.append(", '" + dto.getPassword() + "' ");
		buffer.append(", '" + dto.getEmail() + "' ");
		buffer.append(", '" + dto.getPhone() + "')");
		System.out.println(buffer);

		Connection conn = null;
		Statement stmt = null; // java.sql

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			stmt.execute(buffer.toString()); // data set이 있는지 없는지 여부에 따라 true, false

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

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
		return false;
	}

	MemberDto logon(String user_id, String password) {
		String sql = "select * from tb_member where user_id='" + user_id + "' and password='" + password + "'";

		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null; // java.sql
		ResultSet rs = null;

		MemberDto dto = new MemberDto();

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setEmail(rs.getString("email"));
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
		return dto; // getUser_id() 공백이면 로그온 실패, 공백 아니면 로그온 성공
	}

	public MemberDto findID(String user_name, String email) {
		String sql = "select user_id from tb_member where user_name='" + user_name + "' and email='" + email + "'";

		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null; // java.sql
		ResultSet rs = null;

		MemberDto dto = new MemberDto();

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
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
		return dto; // getUser_id() 공백이면 로그온 실패, 공백 아니면 로그온 성공
	}

	public String findPW(String user_id, String email) {
		String sql = "select password from tb_member where user_id='" + user_id + "' and email='" + email + "'";

		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null; // java.sql
		ResultSet rs = null;

		String pw = "";

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				pw = rs.getString("password");
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
		return pw;
	}
}
