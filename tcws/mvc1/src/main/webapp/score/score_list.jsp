<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.*"%>
<%@ page import="com.kosa.mvc1.score.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Score list</title>
</head>
<body>
<%
String CONTEXT=request.getContextPath();
%>
<form name="myform">
<input type="hidden" name="cmd">
	<h1>Score</h1>
	<%
	List<ScoreDto> list = (List<ScoreDto>) request.getAttribute("list");
	
	for(ScoreDto dto : list){
	%>
	<table>
	<tbody>
	<tr>
	<td><%=dto.getSeq() %></td>
	<td><a href="/mvc1/score.do?cmd=view&seq=<%=dto.getSeq()%>"><%=dto.getName() %></a></td>
	<td><%=dto.getKor() %></td>
	<td><%=dto.getEng() %></td>
	<td><%=dto.getMat() %></td>
	<td><%=dto.getWdate() %></td>
	</tr>
	</tbody>
	</table>
<%} %>

<button type="button" id="btnWrite">글쓰기</button>
</form>
</body>
<script type="text/javascript">
let btnWrite = document.getElementById("btnWrite");
btnWrite.addEventListener("click", ()=>{
	let frm = document.myform;
	frm.action = "<%=CONTEXT%>/score.do";
	frm.cmd.value="write";
	frm.submit();
})
</script>
</html>