package com.kosa.ajaxtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GuestbookDao {
	List<GuestbookDto> list = new ArrayList<GuestbookDto>();

	public GuestbookDao() {
		// 생성자에서 미리 데이터 넣어놓기
//		list.add(new GuestbookDto("1", "제목 1", "작성자 1", "2023-01-09", "내용 1", "0"));
//		list.add(new GuestbookDto("2", "제목 2", "작성자 2", "2023-01-09", "내용 2", "1"));
//		list.add(new GuestbookDto("3", "제목 3", "작성자 3", "2023-01-09", "내용 3", "2"));

//		jsp일 때는 예외처리를 안 해줘도 되지만, java일 때는 반드시 해줘야 함
		try {
			Class.forName(DBUtil.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public List<GuestbookDto> getList() {
		Connection conn = null;
		Statement stmt = null; // java.sql
		ResultSet rs = null;
		List<GuestbookDto> list = new ArrayList<GuestbookDto>();

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();

			String sql = "select seq,title,writer,content,to_char(wdate, 'yyyy-mm-dd') wdate, hit from tb_guestbook order by seq desc";
			System.out.println(sql); // 디버깅용! 콘솔창에서 쿼리가 제대로 되었는지 꼭 확인하자~! 나중에는 log4j라는 라이브러리를 연결해서 확인한다.

			rs = stmt.executeQuery(sql); // 쿼리 실행 후 결과집합을 반환한다

			while (rs.next()) { // 맨 앞에는 데이터가 아니다. 한 번 next 호출해야 데이터이다.
				GuestbookDto dto = new GuestbookDto();
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getString("hit"));
				list.add(dto);
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

		return list;
	}

	public GuestbookDto getView(String seq) {
		Connection conn = null;
		Statement stmt = null; // java.sql
		ResultSet rs = null;
		GuestbookDto dto = new GuestbookDto();

		try {
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USERID, DBUtil.PWD);
			stmt = conn.createStatement();
			
			//조회수 올리기
			String sql = "update tb_guestbook set hit=hit+1 where seq="+seq;
			System.out.println(sql);
			stmt.execute(sql); //insert, update, delete 시 호출 함수
			
			//데이터 가져오기
			sql ="select*from tb_guestbook where seq =" + seq;
			
			System.out.println(sql); // 디버깅용! 콘솔창에서 쿼리가 제대로 되었는지 꼭 확인하자~! 나중에는 log4j라는 라이브러리를 연결해서 확인한다.

			rs = stmt.executeQuery(sql); // 쿼리 실행 후 결과집합을 반환한다

			if (rs.next()) { // 원하는 데이터만 뽑을 것이기 때문에 while이 아니라 if + list에 담을 필요가 없음(특정 데이터만 뽑는거지 전체를 담는게 아니기
								// 때문)
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getString("hit"));
			}
			// db랑 연결된 상태로 jsp로 넘기면 안됨 -> db랑 연결 끊고
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

		return dto; // list랑 view는 다르기 때문에, return dto를 해야 함. return list를 하고 view로 넘길 경우 view에서
					// dto를 못찾기 때문에
//		java.lang.ClassCastException: class java.util.ArrayList cannot be cast to class com.kosa.mvc1.guestbook.GuestbookDto
//		위와 같은 오류가 발생!
	}

	public void insert(GuestbookDto dto) {
		Connection conn = null;
		Statement stmt = null;
		try {
//			String 클래스는 내부 메모리를 데이터 하나 추가될 때마다 새로 잡음(하나 자리 잡았는데 새로 들어오면 폐기하고 두개를 새로 자리 잡음. -> 이걸 추가될 때마다 반복)
//			StringBuffer는 많이 만들어놓고 추가될 때마다 넣어가며 메모리 관리 -> 속도가 더 빠름
			StringBuffer buffer = new StringBuffer();
			buffer.append("insert into tb_guestbook(seq, title, writer, content, wdate, hit) ");
			buffer.append("values (sq_guest.nextval,'");
			buffer.append(dto.getTitle() + "', '");
			buffer.append(dto.getWriter() + "', '");
			buffer.append(dto.getContent() + "', ");
			buffer.append("sysdate, 0)");

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
	
	public void update(GuestbookDto dto) {
		Connection conn = null;
		Statement stmt = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("update tb_guestbook set ");
			buffer.append("title= '"+dto.getTitle() + "', ");
			buffer.append("writer= '"+dto.getWriter() + "', ");
			buffer.append("content= '"+dto.getContent() + "' ");
			buffer.append("where seq="+dto.getSeq());

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
			
			String sql = "delete from tb_guestbook where seq =" + seq;
			
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
