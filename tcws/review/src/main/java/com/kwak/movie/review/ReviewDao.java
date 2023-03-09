package com.kwak.movie.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.kwak.movie.common.*;

public class ReviewDao {
	public ReviewDao() {

		try {
			Class.forName(DBUtil.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(ReviewDto dto) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("insert into tb_review(m_seq, m_password, m_title, m_writer, m_director, m_actor, m_rate, m_review, m_date, m_poster, m_wdate) values ");
			buffer.append("(rv_seq.nextval, ");
			buffer.append(dto.getM_password()+", '");
			buffer.append(dto.getM_title()+"', '");
			buffer.append(dto.getM_writer()+"', '");
			buffer.append(dto.getM_director()+"', '");
			buffer.append(dto.getM_actor()+"', ");
			buffer.append(dto.getM_rate()+", '");
			buffer.append(dto.getM_review()+"', to_date('");
			buffer.append(dto.getM_date()+"', 'yyyy-mm-dd'), '");
			buffer.append(dto.getM_poster()+"', sysdate)");
			
			System.out.println(buffer.toString());
			
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();
			stmt.execute(buffer.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
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
	
	
	public List<ReviewDto> getList(ReviewDto paramDto){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ReviewDto> list = new ArrayList<ReviewDto>();
		try {			
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();
			StringBuffer buffer = new StringBuffer();

			buffer.append("select a.m_seq, a.m_title, a.m_writer, a.m_poster, a.m_rate, to_char(a.m_date, 'yyyy-mm-dd') as m_date, a.pg, a.rnum from");
			buffer.append("(select m_seq, m_title, m_writer, m_poster, m_rate, m_date, ");
			buffer.append("row_number() over(order by m_seq desc) as rnum, ");
			buffer.append("ceil(row_number() over(order by m_seq desc)/12)-1 pg ");
			buffer.append("from tb_review ");
			buffer.append( getSearch(paramDto));
			buffer.append(") A  where pg="+paramDto.getPg());
			buffer.append(" order by rnum");
			System.out.println(buffer.toString());
			rs = stmt.executeQuery(buffer.toString());
			while (rs.next()) {
				ReviewDto dto = new ReviewDto();
				dto.setM_seq(rs.getString("m_seq"));
				dto.setRnum(rs.getInt("rnum"));
				dto.setM_title(rs.getString("m_title"));
				dto.setM_writer(rs.getString("m_writer"));
				dto.setM_rate(rs.getString("m_rate"));
				dto.setM_date(rs.getString("m_date"));
				dto.setM_poster(rs.getString("m_poster"));
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
	
	public int getTotal(ReviewDto paramDto) {
		Connection conn = null;
		Statement stmt = null; 
		ResultSet rs = null;
		int totalCnt=0;
		
		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("select count(*) from tb_review");
			buffer.append( getSearch(paramDto));
			
			//System.out.println(buffer.toString()); // 디버깅용! 콘솔창에서 쿼리가 제대로 되었는지 꼭 확인하자~! 나중에는 log4j라는 라이브러리를 연결해서 확인한다.
			
			rs = stmt.executeQuery(buffer.toString()); // 쿼리 실행 후 결과집합을 반환한다
			
			if (rs.next()) { // 맨 앞에는 데이터가 아니다. 한 번 next 호출해야 데이터이다.
				totalCnt = rs.getInt(1); //첫번째 필드값
			}
			// db랑 연결된 상태로 jsp로 넘기면 안됨 -> db랑 연결 끊고 list만 넘겨야 됨
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
		
		return totalCnt;
	}
	
	public String getSearch(ReviewDto paramDto) {
		String searchText = " where 1=1"; //1-1 모든 데이터라는 뜻
		if(paramDto.getSearchOpt().equals("1")) {
			searchText += " and m_title like '%"+paramDto.getSearchKeyword()+"%' ";
		} else if(paramDto.getSearchOpt().equals("2")) {
			searchText += " and m_director like '%"+paramDto.getSearchKeyword()+"%' ";
		} else if(paramDto.getSearchOpt().equals("3")) {
			searchText += " and m_rate like '%"+paramDto.getSearchKeyword()+"%' ";
		}
		System.out.println(searchText);
		
		return searchText;
	}
	
	public ReviewDto getView(String seq){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ReviewDto dto = new ReviewDto();
		
		try {			
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			String sql = "select a.m_seq, a.m_password, a.m_title, a.m_writer, a.m_director, a.m_actor, a.m_rate, a.m_review, to_char(a.m_date, 'yyyy-mm-dd') as m_date, a.m_poster from tb_review A where m_seq="+seq;
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				dto.setM_seq(rs.getString("m_seq"));
				dto.setM_password(rs.getString("m_password"));
				dto.setM_title(rs.getString("m_title"));
				dto.setM_writer(rs.getString("m_writer"));
				dto.setM_director(rs.getString("m_director"));
				dto.setM_actor(rs.getString("m_actor"));
				dto.setM_rate(rs.getString("m_rate"));
				dto.setM_review(rs.getString("m_review"));
				dto.setM_date(rs.getString("m_date"));
				dto.setM_poster(rs.getString("m_poster"));
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
	
	public void delete(String seq) {
		Connection conn = null;
		Statement stmt = null; // java.sql

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			String sql = "delete from tb_review where m_seq =" + seq;

			System.out.println(sql); // 디버깅용! 콘솔창에서 쿼리가 제대로 되었는지 꼭 확인하자~! 나중에는 log4j라는 라이브러리를 연결해서 확인한다.

			stmt.execute(sql); // 쿼리 실행 후 결과집합을 반환한다

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
