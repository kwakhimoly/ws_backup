<%@page import="com.kwak.mycompany.score.ScoreDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<ScoreDto> list = (List<ScoreDto>)request.getAttribute("list");
%>

<ul>
				<%
					for (int i = 0; i < list.size(); i++) {
					ScoreDto dto = list.get(i);
				%>
				
					<li><%=dto.getSeq()%></li>
					<li><%=dto.getName()%></li>
					<li><%=dto.getKor()%></li>
					<li><%=dto.getEng()%></li>
					<li><%=dto.getMat()%></li>
					<li><%=dto.getWdate()%></li>
				
				<%
					}
				%>
			</ul>
</body>
</html>