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

<!-- AJAX는 form태그로 전송하지 않는다. 선택적으로 사용 가능 -->

x: <input type="text" id="xvalue"><br>
y: <input type="text" id="yvalue"><br>

<div id="result"></div>
<button type="button" onclick="loadDoc()">Ajax 테스트</button>



</body>
<script type="text/javascript">
function loadDoc(){
	let xhttp = new XMLHttpRequest();
	/* 
	XMLHttpRequest: 비동기 통신을 담당할 클래스
	비동기 통신담당 객체를 만든다
	xhttp 객체에는 onload라는 변수(특성)가 있다. 이변수에 통신이 완료한 후에 호출할 함수의 주소를 전달한다.
	주의할 점 : 화살표 함수를 사용 못한다.
				-> 통신내용을 받아올 때 this를 사용해야 하는데 화살표 함수는 this를 사용하지 못한다.
	*/
	xhttp.onload=function(){
		//서버로부터 응답이 완료될 때 이 함수가 호출된다.
		document.getElementById("result").innerHTML = this.responseText;
		//this: xhttp 객체 자신
		//통신이 완료한 후에 responseText 변수에 서버로부터 전달받은 값이 들어 있다. 
	}
	
				//get방식일 경우에 receive1.jsp?xvalue=5&yvalue=8의 형태로 url을 만든다
				//post방식일 경우, 파라미터를 만들어줌
	let params = "xvalue="+document.getElementById("xvalue").value+"&yvalue="+document.getElementById("yvalue").value;
	
	console.log(params); 
	//url이 잘 만들어졌는지 확인용 코드
				
				// 서버로 요청을 한다
	xhttp.open("POST", "receive1.jsp", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xhttp.send(params); 
	//위 정보를 기반으로 서버와 통신한다.
				
}
</script>
</html>