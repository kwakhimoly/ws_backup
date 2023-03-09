<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 자바 파일, html, utf-8 명시 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index.jsp</title>
</head>
<body>
	<%
	/* 자바 코드를 둘 수 있다 */
	/* http://localhost:8080/Dec29_MyHome_1/index.jsp 직접 입력해도 실행 가능 */
	String hello = "안녕하세요 JSP입니다";
		
	%>
	<h1><%= hello %></h1> 
	<a href="<%=request.getContextPath()%>/연습1.jsp">연습1</a>
</body>
</html>

