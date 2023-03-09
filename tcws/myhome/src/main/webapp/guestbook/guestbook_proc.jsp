<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"  %>

<%
//원래는 class로 빼서 보안 처리 해야함 => 유지보수+보안
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; 
String userid = "k";
String pwd = "1234";

Class.forName(driver); 
Connection conn = DriverManager.getConnection(url, userid, pwd);


//서버로 넘어오는 값을 받자
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("contents");
String seq = request.getParameter("seq"); //seq 파라미터 값 받아서 조회수 증가하고 데이터 가져오기
String mode = request.getParameter("mode");
String sql = "";
String msg = "";

if(mode.equals("insert")){
sql = "insert into tb_guestbook values ("+
	"sq_guest.nextval, '"+title+"', '"+writer+"', '"+
	content+"', "+ " sysdate, 0)";	
msg = "글이 등록되었습니다.";
} else if(mode.equals("modify")){
sql = "update tb_guestbook set title = '"+title+"' " +", writer='"+writer+"' "
		+", content='"+content+"' " + " where seq = " +seq;
msg ="글이 수정되었습니다.";
} else if(mode.equals("delete")){
	sql = "delete from tb_guestbook " + "where seq = "+seq;
	msg="글이 삭제되었습니다.";
}
System.out.println(sql); // 쿼리 콘솔 창에서 확인

Statement stmt = conn.createStatement();
boolean result = stmt.execute(sql);
stmt.close();
conn.close();
%>

<script type="text/javascript">
alert("<%=msg%>");
location.href="guestbook_list.jsp";
</script>