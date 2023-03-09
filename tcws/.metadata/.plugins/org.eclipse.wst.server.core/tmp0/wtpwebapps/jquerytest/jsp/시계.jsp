<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>slide</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style type="text/css">
#panel, #flip {
	padding: 5px;
	text-align: center;
	background-color: lavender;
	border: solid 1px;
}

#panel {
	font-size: 30pt;
	padding: 50px;
}
</style>
</head>
<body>
	<div id="flip">시계 시작과 종료</div>
	<div id="panel">Hello World</div>
</body>
<script type="text/javascript">
/*
 전역 변수
 : 함수의 영역이 아니라 함수 영역 밖에서 존재하는 변수
 자바라면 static 변수여야 한다. 
 */
	let timer1 = null;

$(()=>{
	$("#flip").click(()=>{
		//setInterval(함수, 시간) 시간마다 함수가 호출된다.
		//timer1 변수는 click 내에서만 존재하는 지역 변수라
		//			이 함수가 종료하면 사라진다.
			/* setInterval(함수, 시간)-> 시간마다 함수가 호출됨 */
			if(timer1!=null){
				clearTimeout(timer1);//종료. 근데 종료해도 timer1 변수 값이 null 이 되진 않음
				timer1 = null; //초기화를 직접 하자
			} else{
				timer1 = setInterval(() => {
				today= new Date(); //현재 날짜와 시간
				hour = today.getHours();
				minutes = today.getMinutes();
				seconds = today.getSeconds();	
				
				currentTime = hour+"시"+minutes+"분"+seconds+"초";
				$("#panel").html(currentTime);
			}, 1000); 
		}
	});
	//반환값 => 핸들, 객체 식별값
});
</script>
</html>