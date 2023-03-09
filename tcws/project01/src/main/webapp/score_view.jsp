<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String seq = request.getParameter("seq");

String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //서버컴의 아이피?
String userid = "k";
String pwd = "1234";

Class.forName(driver); //드라이브 파일 로딩 
Connection conn = DriverManager.getConnection(url, userid, pwd);
Statement stmt = conn.createStatement();
String sql = "select rn as rate, seq, name, kor, eng, mat, total, avg, sdate"+
		" from (select rownum as rn, seq, name, kor, eng, mat, total, avg, sdate"+
		" from (select seq, name, kor, eng, mat, "+
		"(kor+eng+mat) as total, (kor+eng+mat)/3.0 as avg, to_char(wdate, 'yyyy-mm-dd') as sdate from tb_score "
		+"where seq= "+seq +" order by avg desc))";
ResultSet rs = stmt.executeQuery(sql);
String snum = "";
String name = "";
String kor = "";
String eng = "";
String mat = "";
String total = "";
String avg = "";
String sdate = "";
if(rs.next()){
	snum = rs.getString("seq");
	name = rs.getString("name");
	kor = rs.getString("kor");
	eng = rs.getString("eng");
	mat = rs.getString("mat");
	total = rs.getString("total");
	
	String sAvg = rs.getString("avg");
	double dAvg = Double.parseDouble(sAvg);
	avg = String.format("%.2f", dAvg);
	
	sdate = rs.getString("sdate");
}
%>

<form name="myform">
<input type="hidden" name="mode" value="modify">
<input type="hidden" name="seq" value="<%=seq%>">

<table>
  <tr>
    <!-- <th>등수</th> -->
    <th>학급번호</th>
    <th>이름</th>
<th>국어</th>
    <th>영어</th>
    <th>수학</th>
    <th>총점</th>
    <th>평균</th>
    <th>일시</th>
  </tr>

		
  <tr>
   <%--  <td><%=rs.getString("rate") %></td> --%>
    <td><%=seq %></td>
    <td><%=name %></td>
	<td><%=kor %></td>
    <td><%=eng %></td>
    <td><%=mat%></td>
    <td><%=total %></td>
    <td><%=avg %></td> 
    <td><%=sdate %></td>
  </tr>


</table>

<button type="button" id="btnModify">수정</button> &nbsp;
<button type="button" id="btnDelete">삭제</button> &nbsp;
<button type="button" id="btnList">목록</button>
</form>
</body>

<script type="text/javascript">
window.onload=()=>{
	document.getElementById("btnModify").addEventListener("click", goModify);
	document.getElementById("btnDelete").addEventListener("click", goDelete);
	document.getElementById("btnList").addEventListener("click", goList);
}
function goModify() {
	let frm = document.myform;
	frm.action = "score_write.jsp";
	frm.submit();
}
function goDelete() {
	if(confirm("삭제하시겠습니까?")){
	let frm = document.myform;
	frm.mode.value="delete";
	frm.action = "score_proc.jsp";
	frm.submit();
	}
}
function goList() {
	location.href = "/project01/score.jsp";
}
</script>
</html>