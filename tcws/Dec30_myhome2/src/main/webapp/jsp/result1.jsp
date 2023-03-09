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
	int x = Integer.parseInt(request.getParameter("xValue").toString());
	int y = Integer.parseInt(request.getParameter("yValue").toString());
	%>

	<h1>
		<%=x%>+<%=y%>=<%=x + y%>
	</h1>
	
</body>
</html>