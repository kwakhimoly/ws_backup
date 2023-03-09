package com.kosa.mvc1.score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kosa.mvc1.DBUtil;

public class ScoreDao {
	List<ScoreDto> list = new ArrayList<ScoreDto>();

	public ScoreDao() {
		try {
			Class.forName(DBUtil.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public List<ScoreDto> getList() {
		Connection conn = null;
		Statement stmt = null; // java.sql
		ResultSet rs = null;
		List<ScoreDto> list = new ArrayList<ScoreDto>();

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			String sql = "select*from tb_score order by seq";
			System.out.println(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ScoreDto dto = new ScoreDto();
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getString("kor"));
				dto.setEng(rs.getString("eng"));
				dto.setMat(rs.getString("mat"));
				dto.setWdate(rs.getString("wdate"));
				list.add(dto);
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

		return list;
	}

	public ScoreDto getView(String seq) {
		Connection conn = null;
		Statement stmt = null; // java.sql
		ResultSet rs = null;
		ScoreDto dto = new ScoreDto();

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			String sql = "select*from tb_score where seq=" + seq;
			System.out.println(sql);

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getString("kor"));
				dto.setEng(rs.getString("eng"));
				dto.setMat(rs.getString("mat"));
				dto.setWdate(rs.getString("wdate"));
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

		return dto;
	}

	public void insert(ScoreDto dto) {
		Connection conn = null;
		Statement stmt = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("insert into tb_score(seq, name, kor, eng, mat, wdate) ");
			buffer.append("values ('");
			buffer.append(dto.getSeq() + "', '");
			buffer.append(dto.getName() + "', '");
			buffer.append(dto.getKor() + "', '");
			buffer.append(dto.getEng() + "', '");
			buffer.append(dto.getMat() + "', ");
			buffer.append("sysdate)");

			System.out.println(buffer.toString());

			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();
			stmt.execute(buffer.toString());

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
	}

	public void update(ScoreDto dto) {
		Connection conn = null;
		Statement stmt = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("update tb_score set ");
			buffer.append("seq= " + dto.getSeq() + ", ");
			buffer.append("name= '" + dto.getName() + "', ");
			buffer.append("kor= " + dto.getKor() + ", ");
			buffer.append("eng= " + dto.getEng() + ", ");
			buffer.append("mat= " + dto.getMat() + " ");
			buffer.append("where seq= " + dto.getSeq() + "");

			System.out.println(buffer.toString());

			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();
			stmt.execute(buffer.toString());

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
				// TODO: handle exception
			}
		}
	}

	public void delete(String seq) {
		Connection conn = null;
		Statement stmt = null; // java.sql

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			String sql = "delete from tb_score where seq =" + seq;

			System.out.println(sql);
			stmt.execute(sql);

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
	}
}
