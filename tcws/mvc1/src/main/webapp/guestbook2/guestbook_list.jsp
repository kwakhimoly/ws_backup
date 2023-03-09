<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.kosa.mvc1.guestbook.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook</title>
<style>
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    border-left: 1px solid #444444;
    padding: 10px;
  }
  th:first-child, td:first-child {
    border-left: none;
  }
</style>
</head>
<body>
	<h1>Guestbook</h1>
	
	<%
	List<GuestbookDto> list = (List<GuestbookDto>)request.getAttribute("list");
	%>
<%
	for(GuestbookDto dto : list){
%>
	<table>
	<tbody>
		<tr>
		<td style="width: 20%"><a href="/mvc1/guestbook.do?cmd=view&seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
		<td style="width: 20%"><%=dto.getWriter()%></td>
		<td style="width: 20%"><%=dto.getContent()%></td>
		<td style="width: 20%"><%=dto.getWdate()%></td>
		<td style="width: 20%"><%=dto.getHit()%></td>
		</tr>
	</tbody>
	</table>
		
	<%
	}
	%>
</body>
</html>