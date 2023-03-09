package hayoung.kwak.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//회사 가서도 쓰게
public class KwakDBManager {
	
	
	public static Connection connect(String url, String id, String pw) throws Exception {
	return DriverManager.getConnection(url, id, pw);
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {rs.close();} catch (Exception e) {}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
	}
}
