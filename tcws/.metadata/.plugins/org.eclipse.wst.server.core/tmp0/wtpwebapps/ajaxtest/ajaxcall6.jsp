<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Ajax 테스트</h1>

<div id="result"></div>

<button type="button" onclick="loadDoc()">JSON 받아오기</button>



</body>
<script type="text/javascript">
function loadDoc(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onload=function(){
		//JSON 라이브러리
		data = JSON.parse(this.responseText); 
		//String이 JSON 객체로 전환
		console.log(data);
		let result = "";
		
		result += "이름:"+data.username+"<br>";
		result += "이메일:"+data.email+"<br>";
		document.getElementById("result").innerHTML=result;
	}
	
	let url = "/ajaxtest/guest.do"; //결과를 JSON 형태로 보낸다
	//JSON 데이터 형식이 {"키1":"값1", "키2":"값2", "키3":"값3",...}
	//html 등의 태그도 없어야 한다. 딱 JSON데이터만 전송해야 한다.
	console.log(url); 
	xhttp.open("Get", url, true);
	
	xhttp.send(); 
				
}
</script>
</html>