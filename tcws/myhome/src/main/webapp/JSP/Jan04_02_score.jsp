<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적처리</title>
</head>
<body>

	<form name="myform" action="/myhome/JSP/Jan04_02_score_proc.jsp">
		이름 : <input type="text" name="userName"><br> 
		국어 : <input type="text" name="kor"><br> 
		수학 : <input type="text" name="mat"><br> 
		영어 : <input type="text" name="eng"><br>

		<button type="button" id="btnSend">결과</button>
	</form>
</body>
<script>
btnSend.addEventListener("click", (e)=>{

	console.log(e); 
	
	console.log(e.target) 
	e.preventDefault(); 
	let frm = document.myform;
	
	if(frm.userName.value.trim()==""){
		alert("이름을 입력하세요");
		frm.userName.focus();
		return false;
	}
	
	/*
	한글은 get 방식으로 보내면 안 된다. 한글을 변환작업을 거쳐서 서버로 보낸다. 
	버전이 낮은 브라우저에서는 문제가 발생할 수 있다. 
	응답을 받은 쪽에서는 request.setCharacterEncoding("utf-8");
	get 방식으로 굳이 보내고 싶다면 urlencoding 작업을 해서 보내야 한다.
	받는 쪽에서는 urldecoding 작업을 해서 받아야 한다.
	*/
	frm.method = "post";
	frm.submit();
})
</script>
</html>