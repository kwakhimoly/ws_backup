package com.kwak.dec234.project.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hayoung.kwak.db.manager.KwakDBManager;

public class ManageDAO {
	private int allCGVCount;
	private int allMovieCount;
	private int allTheaterCount;

	public ManageDAO() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");
			String sql = "select count(*) from dec23_cgv";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allCGVCount = rs.getInt("count(*)");

			sql = "select count(*) from dec23_movie";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allMovieCount = rs.getInt("count(*)");

			sql = "select count(*) from dec23_theater";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allTheaterCount = rs.getInt("count(*)");

			sql = "select count(*) from dec23_runmovie";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			rs.getInt("count(*)");

		} catch (Exception e) {
			e.printStackTrace();
		}
		KwakDBManager.close(con, pstmt, rs);

	}

	public ArrayList<CGV> getCGV(int pageNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");

			int cgvPerPage = 5;
			int start = 0;
			int end = 0;

			start = (pageNo - 1) * cgvPerPage + 1;
			end = pageNo * 5;

			String sql = "select * from (select rownum as rn, cgv_name, cgv_location, cgv_room "
					+ "from (select* from dec23_cgv order by cgv_name)) where rn>=? and rn<=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			ArrayList<CGV> cgv = new ArrayList<>();

			while (rs.next()) {
				cgv.add(new CGV(rs.getString("cgv_name"), rs.getString("cgv_location"), rs.getInt("cgv_room")));
			}

			return cgv;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KwakDBManager.close(con, pstmt, rs);
		}
	}

	public ArrayList<Movie> getMovie(int pageNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");

			int cgvPerPage = 5;
			int start = 0;
			int end = 0;

			start = (pageNo - 1) * cgvPerPage + 1;
			end = pageNo * 5;

			String sql = "select * from (select rownum as rn, m_title, m_director, m_date, m_time "
					+ "from (select * from dec23_movie order by m_date)) where rn>=? and rn<=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			ArrayList<Movie> mv = new ArrayList<>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			while (rs.next()) {
				mv.add(new Movie(0, rs.getString("m_title"), rs.getString("m_director"),
						sdf.format(rs.getDate("m_date")), rs.getInt("m_time")));
			}

			return mv;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KwakDBManager.close(con, pstmt, rs);
		}
	}

	public ArrayList<Theater> getTheater(int pageNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");

			int cgvPerPage = 5;
			int start = 0;
			int end = 0;

			start = (pageNo - 1) * cgvPerPage + 1;
			end = pageNo * 5;

			String sql = "select * from (select rownum as rn, t_name, t_cgv_name, t_number "
					+ "from (select * from dec23_theater order by t_cgv_name)) where rn>=? and rn<=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			ArrayList<Theater> tt = new ArrayList<>();

			while (rs.next()) {
				tt.add(new Theater(0, rs.getString("t_name"), rs.getString("t_cgv_name"), rs.getInt("t_number")));
			}

			return tt;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KwakDBManager.close(con, pstmt, rs);
		}
	}

	public ArrayList<Every> getRunMovie(int pageNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");

			int cgvPerPage = 5;
			int start = 0;
			int end = 0;

			start = (pageNo - 1) * cgvPerPage + 1;
			end = pageNo * 5;

			String sql = "select * from (select rownum as rn, r_t_cgv_name, r_t_name, r_m_title "
					+ "from (select * from dec23_runmovie order by r_t_cgv_name)) where rn>=? and rn<=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			ArrayList<Every> ev = new ArrayList<>();

			while (rs.next()) {
				ev.add(new Every(rs.getString("r_t_cgv_name"), rs.getString("r_t_name"), rs.getString("r_m_title")));
			}

			return ev;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KwakDBManager.close(con, pstmt, rs);
		}
	}

	public ArrayList<Every> getMEvery(String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");

			String sql = "select m_no, m_title from dec23_movie " + "where m_title in ? order by m_no";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);

			rs = pstmt.executeQuery();

			ArrayList<Every> all = new ArrayList<>();

			while (rs.next()) {
				all.add(new Every(rs.getInt("m_no"), rs.getString("m_title")));
			}

			return all;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KwakDBManager.close(con, pstmt, rs);
		}
	}

	public ArrayList<Every> getTEvery(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");

			String sql = "select t_no, t_name, t_cgv_name from dec23_theater " + "where t_cgv_name in ? order by t_no";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			rs = pstmt.executeQuery();

			ArrayList<Every> all = new ArrayList<>();

			while (rs.next()) {
				all.add(new Every(rs.getInt("t_no"), rs.getString("t_name"), rs.getString("t_cgv_name")));
			}

			return all;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KwakDBManager.close(con, pstmt, rs);
		}
	}

	public int getCGVCount() {
		double cgvPerPage = 5;
		int cgvPageCount = (int) Math.ceil(allCGVCount / cgvPerPage);
		return cgvPageCount;
	}

	public int getMovieCount() {
		double mvPerPage = 5;
		int mvPageCount = (int) Math.ceil(allMovieCount / mvPerPage);
		return mvPageCount;
	}

	public int getTheaterCount() {
		double ttPerPage = 5;
		int ttPageCount = (int) Math.ceil(allTheaterCount / ttPerPage);
		return ttPageCount;
	}

	public int getRMCount() {
		double rmPerPage = 5;
		int rmPageCount = (int) Math.ceil(allTheaterCount / rmPerPage);
		return rmPageCount;
	}

	public String setCGV(CGV c) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");
			String sql = "insert into dec23_cgv values(?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getLocation());
			pstmt.setInt(3, c.getRoom());

			int row = pstmt.executeUpdate();

			if (row == 1) {
				allCGVCount++;
				return "success";
			} else {
				return "null";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			KwakDBManager.close(con, pstmt, null);
		}
	}

	public String setMovie(Movie movie) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");
			String sql = "insert into dec23_movie values(dec23_m_seq.nextval, ?, ?, to_date(?, 'yyyy-mm-dd'), ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, movie.getM_title());
			pstmt.setString(2, movie.getM_director());
			pstmt.setString(3, movie.getM_date());
			pstmt.setInt(4, movie.getM_time());

			int row = pstmt.executeUpdate();

			if (row == 1) {
				allMovieCount++;
				return "success";
			} else {
				return "null";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			KwakDBManager.close(con, pstmt, null);
		}
	}

	public String setTheater(Theater theater) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");
			String sql = "insert into dec23_theater values(dec23_t_seq.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, theater.getT_name());
			pstmt.setString(2, theater.getT_cgv_name());
			pstmt.setInt(3, theater.getT_number());

			int row = pstmt.executeUpdate();

			if (row == 1) {
				allTheaterCount++;
				return "success";
			} else {
				return "fail";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			KwakDBManager.close(con, pstmt, null);
		}
	}

	public String setRM(Every every) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");
			String sql = "insert into DEC23_RUNMOVIE values (dec23_r_seq.nextval, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, every.getT_no());
			pstmt.setInt(2, every.getM_no());
			pstmt.setString(3, every.getT_name());
			pstmt.setString(4, every.getT_cgv_name());
			pstmt.setString(5, every.getM_title());

			int row = pstmt.executeUpdate();

			if (row == 1) {
				return "success";
			} else {
				return "fail";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			KwakDBManager.close(con, pstmt, null);
		}
	}

	public String deleteCGV(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");
			String sql = "delete from dec23_cgv where cgv_name = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name);

			int row = pstmt.executeUpdate();

			if (row == 1) {
				return "success";
			} else {
				return "null";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			KwakDBManager.close(con, pstmt, null);
		}
	}

	public String deleteMovie(String m_title) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");
			String sql = "delete from dec23_movie where m_title = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, m_title);

			int row = pstmt.executeUpdate();

			if (row == 1) {
				return "success";
			} else {
				return "null";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			KwakDBManager.close(con, pstmt, null);
		}
	}

	public String deleteTheater(String t_name, String t_cgv_name) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");
			String sql = "delete from dec23_theater where t_name = ? and t_cgv_name = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, t_name);
			pstmt.setString(2, t_cgv_name);

			int row = pstmt.executeUpdate();

			if (row == 1) {
				return "success";
			} else {
				return "null";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			KwakDBManager.close(con, pstmt, null);
		}
	}

	public String deleteRM(String r_m_title, String r_t_cgv_name, String r_t_name) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = KwakDBManager.connect("jdbc:oracle:thin:@192.168.0.3:1521:xe", "khy", "sol0415");
			String sql = "delete from dec23_runmovie where r_m_title = ? and r_t_cgv_name = ? and r_t_name = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, r_m_title);
			pstmt.setString(2, r_t_cgv_name);
			pstmt.setString(3, r_t_name);

			System.out.println(r_m_title);
			System.out.println(r_t_cgv_name);
			System.out.println(r_t_name);
			int row = pstmt.executeUpdate();

			if (row >= 1) {
				return "success";
			} else {
				return "null";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		} finally {
			KwakDBManager.close(con, pstmt, null);
		}
	}

}
