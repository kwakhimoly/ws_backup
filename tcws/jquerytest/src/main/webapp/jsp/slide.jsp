<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>slide</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style type="text/css">
#panel, #flip{
	padding: 5px;
	text-align: center;
	background-color: lightblue;
	border: solid 1px;
}
#panel {
	padding: 50px;
}
</style>
</head>
<body>
<div id="flip">Click</div>
<div id="panel">Hello World</div>
</body>
<script type="text/javascript">
$(function(){
	$("#panel").css("display", "none"); // 처음에 안 보이게 시작했다가~
 /*	$("#flip").click(()=>{
		$("#panel").slideUp("slow");
	}) */
	// 내려갔다가 2초 있다 올라오기
	$("#flip").click(()=>{
		$("#panel").slideDown("slow", function(){
			//다 내려오면 콜백함수 호출
			//자바 스크립트에 setTimeout(함수, 시간);
			//				뒤에 지정한 시간이 흐른 이후에 한 번 앞에 함수 호출
			//2초마다 계속 발생하고 싶다면 -> setInterval() 사용
			setTimeout(()=>{
				$("#panel").slideUp();
			},2000)
		});
	})
})
</script>
</html>