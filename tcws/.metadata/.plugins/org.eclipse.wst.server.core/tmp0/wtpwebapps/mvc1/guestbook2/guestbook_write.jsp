<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook write</title>
</head>
<body>
	<form name="myform" action="/mvc1/guestbook.do?cmd=save" method="post">
		제목: <input type="text" name="title"><br> 
		작성자: <input type="text" name="writer"><br> 
		내용: <input type="text" name="content"><br> 
		
		<input type="submit" value="등록">
	<!-- submit 버튼 사용할 때는 form 태그의 action 속성과 method를 지정해야 한다. -->
	</form>
</body>
</html>