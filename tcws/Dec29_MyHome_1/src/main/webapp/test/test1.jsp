<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./home.css" type ="text/CSS">

</head>
<body>
	<h1>테스트페이지입니다.</h1>
	<!-- http://localhost:8080/Dec29_MyHome_1/test/test1.jsp -->
	<img src="../images/sciencedog.jpg">
	<!-- ../ 한번 할 때마다 상위 폴더 1개 
		 web은 상대경로 사용 안함 -->
	<img src="<%=request.getContextPath()%>/images/sciencedog.jpg">
	<%-- 자바 함수 통해서 절대경로 찾기 : <%=request.getContextPath()%> --%>
	
</body>
</html>