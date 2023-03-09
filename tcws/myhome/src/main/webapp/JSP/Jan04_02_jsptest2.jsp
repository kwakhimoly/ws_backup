<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP test 2</title>
</head>
<body>
	<!-- http://localhost:8080/myhome/JSP/Jan04_02_jsptest2.jsp?limit=5 : 다섯개만 출력 -->

	<%
	String sLimit = request.getParameter("limit");
	int i;
	int limit = Integer.parseInt(sLimit);
	for (i = 1; i <= limit; i++) {
		out.println("i= " + i + "<br>");
	}
	%>
</body>
</html>