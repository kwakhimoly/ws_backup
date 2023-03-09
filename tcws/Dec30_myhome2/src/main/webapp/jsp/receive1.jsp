<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive</title>
</head>
<body>
	<h1>receive1.jsp</h1>
	<%
	/* requst 객체 = 클라이언트가 서버한테 요청을 하면 그 요청을 담아서 가져오는 객체
			브라우저에서 서버로 보내는 모든 정보가 담겨 있음	
	*/
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	%>
	아이디 :
	<%=userid%>
	<br> 패스워드 :
	<%=password%>
	<br>

	<!-- 
	기본적으로 Get 방식
	 -->
</body>
</html>