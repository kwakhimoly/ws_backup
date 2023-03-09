<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>event2 - toggle 연습</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<button type="button" id="btnCheck">나타났다 사라졌다 하기</button>
	<p>toggle 연습</p>
</body>
<script>
$(()=>{
	$("#btnCheck").click(()=>{
		$("p").toggle();
	});
});
</script>
</html>