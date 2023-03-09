<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<title>값 읽고 쓰기</title>
</head>
<body>
<form id="myform" name="myform">

관심 분야: <br>
	<input type="checkbox" name="interest" value="1"> 프로그래밍
	<input type="checkbox" name="interest" value="2"> 웹프로그래밍
	<input type="checkbox" name="interest" value="3"> 데이터 베이스
	<input type="checkbox" name="interest" value="4"> 빅데이터
	<input type="checkbox" name="interest" value="5"> 머신러닝
	<input type="checkbox" name="interest" value="6"> 딥러닝 
	
	<br><br>
	<button id="btnAllS" type="button">전체 선택</button>
	<button id="btnAllR" type="button">전체 선택 해제</button>
</form>
</body>
<script type="text/javascript">
$(()=>{
	$("#btnAllS").click(()=>{
		$("input[type=checkbox][name=interest]").prop("checked", true);
	});
	$("#btnAllR").click(()=>{
		$("input[type=checkbox][name=interest]").prop("checked", false);
	});
})
</script>
</html>