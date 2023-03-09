<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajax  테스트</h1>
	
	<div id="result"></div>
	
	<button type="button" onclick="loadDoc()">Ajax 호출</button>
	
</body>
<script>
function loadDoc()
{
	let xhttp = new XMLHttpRequest(); //XMLHttpRequest :비동기 통신을 담당할 클래스
	//비동기 통신담당 객체를 만든다
	//xhttp객체에는 onload라는 변수(특성)가 있다. 이 변수에 통신이 완료한 후에 
	//호출할 함수의 주소를 전달한다. 주의할점 화살표함수를 사용 못한다. 
	//이유는 통신내용을 받아올때 this를 사용해야 하는데 화살표함수는 this 를 
	//사용하지 못한다 
	xhttp.onload=function(){
		//서버로부터 응답이 완료될때 이 함수가 호출된다. 
		document.getElementById("result").innerHTML 
		          = this.responseText;
		//this: xhttp 객체 자신 
		//통신이 완료한 후에 responseText  변수에 서버로부터 전달받은 값이
		//들어 있다
	}
	
	//서버로 요청을 한다
	xhttp.open("GET", "ajax_test.txt", true); 
	//GET:통신방식, GET, POST 중에 선택가능 POST 는 파라미터 전달방식이 
	//복잡하다. 그래서 보통은 javascript로 ajax를 하지 않고 jquery나 
	//axios같은 라이브러리를 이용해 ajax 통신을 한다 
	//"ajax_test.txt"- 서버의 주소 jsp나 서블릿을 호출 할 수 있다. 
	//여기선 간단한 text파일을 호출한다 
	//true ->  비동기 동기여부 보통은 true 만 사용한다 
	xhttp.send(); //위 정보를 기반으로 서버와 통신한다 
}
</script>
</html>







