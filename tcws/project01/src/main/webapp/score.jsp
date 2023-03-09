<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="myform">
	<%

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String userid = "k";
	String pwd = "1234";

	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, userid, pwd);
	Statement stmt = conn.createStatement();
	String sql = "select rn as rate, seq, name, kor, eng, mat, total, avg, sdate"+
	" from (select rownum as rn, seq, name, kor, eng, mat, total, avg, sdate"+
	" from (select seq, name, kor, eng, mat, "+
	"(kor+eng+mat) as total, (kor+eng+mat)/3.0 as avg, to_char(wdate, 'yyyy-mm-dd') as sdate from tb_score order by avg desc))";
	ResultSet rs = stmt.executeQuery(sql);
%>
<input type="hidden" name="mode" value="insert">
<table>
  <tr>
    <th>등수</th>
    <th>학급번호</th>
    <th>이름</th>
<!--     <th>국어</th>
    <th>영어</th>
    <th>수학</th>
    <th>총점</th>
    <th>평균</th> -->
    <th>일시</th>
  </tr>
<% 
	while (rs.next()) {
%>
	

<%--
String sql = "select * from tb_score";
 	
	<%
	int kor = Integer.parseInt(rs.getString("kor"));
	int eng = Integer.parseInt(rs.getString("eng"));
	int mat = Integer.parseInt(rs.getString("mat"));
	double avg = (kor + eng + mat) / 3.0;
	%>


	<h1><%=rs.getString("seq")%>,
		<%=rs.getString("name")%>,
		<%=kor%>,
		<%=eng%>,
		<%=mat%>,
		<%=rs.getString("wdate")%>,
		<%=String.format("%.2f", avg)%></h1> 
--%>

		<%
		String sAvg = rs.getString("avg");
		double dAvg = Double.parseDouble(sAvg);
		String avg = String.format("%.2f", dAvg);
		%>
		

  <tr>
    <td><%=rs.getString("rate") %></td>
    <td><%=rs.getString("seq") %></td>
    <td><a href="/project01/score_view.jsp?seq=<%=rs.getString("seq")%>"><%=rs.getString("name") %></a></td>
<%--     <td><%=rs.getString("kor") %></td>
    <td><%=rs.getString("eng") %></td>
    <td><%=rs.getString("mat") %></td>
    <td><%=rs.getString("total") %></td>
    <td><%=avg %></td> --%>
    <td><%=rs.getString("sdate") %></td>
  </tr>

	<%
	}
	%>
</table>

<button type="button" id="btnWrite">등록</button>

</form>
</body>
<script type="text/javascript">
let frm = document.myform;
window.onload=()=>{
	let btnWrite = document.getElementById("btnWrite");
	
	btnWrite.addEventListener("click", (e)=>{
		e.preventDefault();
		frm.action ="score_write.jsp";
		frm.method="get";
		frm.submit();
	})
}
</script>

</html>