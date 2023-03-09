<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>
	<form name="myform">
		x : <input type="text" name="xValue"><br> y : <input
			type="text" name="yValue"><br>

		<button type="button" onclick="goSend()">더하기</button>
	</form>
</body>
<!-- 
자바 스크립트는 html이 아니다. 그래서 <script>~</script> 사이에 코드를 두어야 한다.
 -->
<script>
	/*  
	 함수 만들기 => 모든 함수는 function으로 시작해야 한다.
	 자바스크립트는 변수를 선언하지 않아도 사용이 가능하다.
	 변수 앞에는 var 또는 let 접두어만 가능하다.
	 */
	function goSend() {
		/* form 객체에 대한 참조를 가져온다. */
		var frm = document.myform;
		/* document.form의 name 속성 */
		frm.action = "/Dec30_myhome2/jsp/result1.jsp";
		frm.method = "POST";
		/* 전송 방식 post로 변경 -> value가 url에 표시되지 않음 */
		frm.submit();
		/* 서버로 정보를 전송한다. */
	}
</script>
</html>