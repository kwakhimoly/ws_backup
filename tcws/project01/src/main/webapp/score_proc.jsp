<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; 
String userid = "k";
String pwd = "1234";

Class.forName(driver);
Connection conn = DriverManager.getConnection(url, userid, pwd);


request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");

String seq = request.getParameter("seq");
String name = request.getParameter("name");
String sKor = request.getParameter("kor");
String sEng = request.getParameter("eng");
String sMat = request.getParameter("mat");
String mode = request.getParameter("mode");
System.out.println(seq);

String msg = "";
String sql ="";


if(mode.equals("insert")){
sql = "insert into tb_score values ("
+seq
+", '"+name+"', '"+sKor+"', '"+sEng+"', '"+sMat+"', sysdate)";
msg = "등록 완료";
} else if(mode.equals("modify")){
sql = "update tb_score set seq = '"+seq+"' " +", name='"+name+"' "
			+", kor='"+sKor+"' "+", eng='"+sEng+"' " +", mat='"+sMat+"' "
+ " where seq = " +seq;
msg="수정완료";
} else if(mode.equals("delete")){
sql = "delete from tb_score " + "where seq = "+seq;
msg="삭제완료";
}
System.out.println(sql);

Statement stmt = conn.createStatement();
stmt.execute(sql);


stmt.close();
conn.close();
%>
<script type="text/javascript">
alert("<%=msg%>");
location.href="score.jsp";
</script>