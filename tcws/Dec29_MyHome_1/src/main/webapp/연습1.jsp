<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습1</title>
</head>
<body>
	<%
	int i = 0;
	for (i = 1; i <= 10; i++) {
		out.print(i);

		/*
		System.out.println(); : 콘솔창에 print(디버깅)
		out.println() : 브라우저에 print
		*/
	}
	%>
</body>
</html>