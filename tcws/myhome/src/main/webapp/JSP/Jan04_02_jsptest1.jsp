<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP test 1</title>
</head>
<body>
<%
// < % ~ % > 까지는 자바 코드를 두는 영역이다. 그래서 이 부분의 주석은 자바 주석을 사용한다. 
for(int i = 1; i<=10; i++){
	out.print("i="+i+"<br>"); //br 코드 잘 먹네..?
}
// 이 구간에는 함수를 선언할 수 없다. 클래스도 선언 불가능. 제어문(if, for 등)은 가능
%>
</body>
</html>