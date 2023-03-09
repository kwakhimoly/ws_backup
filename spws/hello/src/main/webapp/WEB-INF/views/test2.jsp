<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test2</title>
</head>
<body>
<h1>test 2</h1>
<h6>값 전달 방식</h6>
<h3><%=request.getAttribute("user_id") %></h3>
<h3>표현식: ${password}</h3>
<!-- 표현식은 for문을 못 씀 -->
</body>
</html>