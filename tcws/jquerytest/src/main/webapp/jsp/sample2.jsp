<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample2</title>
	<!-- <script src="/jquerytest/js/jquery-3.6.3.min.js"></script> -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<h1>JQuery Test1</h1>
	<h1>JQuery Test2</h1>
	<h1 id="test1">JQuery Test3</h1>
	<h1 id="test1">JQuery Test4</h1>
	<h1 class="test1">JQuery Test5</h1>
	<h1 class="test1">JQuery Test6</h1>
	<h1 class="test1">JQuery Test7</h1>
	
	<button type="button" id="btnClick1">태그로 접근하기</button>
	<button type="button" id="btnClick2">id로 접근하기</button>
	<button type="button" id="btnClick3">클래스로 접근하기</button>
</body>
<script type="text/javascript">

	innerHTML => html()
	$(document).ready(()=>{
		$("#btnClick1").click(()=>{
			$("h1").html("태그로 접근하기");
		});
		$("#btnClick2").click(()=>{
			$("#test1").html("id로 접근하기"); //id는 언제나 한 개만 존재해야 하기 때문에 두 번째(test4)는 영향을 안 받음
		});
		$("#btnClick3").click(()=>{
			$(".test1").html("클래스로 접근하기");
		});
		$("h1").click(function(){
			$(this).html("this로 접근하기"); //h1 태그 하나하나 눌렀을 때
		});
	});
</script>
</html>