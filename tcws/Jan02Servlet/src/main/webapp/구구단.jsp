<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	단을 입력하세요
	<br>
	<input type="text" name="dan" id="dan">
	<button id="btnPress" type="button">구구단을 외자</button>
	
	<div id="result"></div>
</body>
<script type="text/javascript">
window.onload=()=>{
	var btnPress = document.getElementById("btnPress");
	btnPress.addEventListener("click", ()=>{
		console.log("확인");
		result="";
		dan = document.getElementById("dan").value; //input 태그가 데이터를 읽을 땐 value
		for (var i = 1; i < 10; i++) {
			result += dan + "x" + i + "=" + dan*i +"<br>";
		}
		document.getElementById("result").innerHTML = result;
	});
}
</script>
</html>