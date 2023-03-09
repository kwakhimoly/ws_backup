<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적처리</title>
</head>
<body>

	<form name="myform">
		이름 : <input type="text" name="userName"><br> 
		국어 : <input type="text" name="kor"><br> 
		수학 : <input type="text" name="mat"><br> 
		영어 : <input type="text" name="eng"><br>

		<button type="button" id="result">결과</button>
	</form>
</body>
<script>
let btnr = document.getElementById("result");
window.onload=()=>{
	btnr.addEventListener("click", ()=>{
	let frm = document.myform;
	frm.method="get"; 
	frm.action = "/myhome/Score"; 
	frm.submit();			
	})
}
</script>
</html>