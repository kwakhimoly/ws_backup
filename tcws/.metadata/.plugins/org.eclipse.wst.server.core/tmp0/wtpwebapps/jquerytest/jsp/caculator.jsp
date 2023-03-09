<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<title>calculator</title>
</head>
<body>
x: <input type="text" id="x"><br>
y: <input type="text" id="y"><br>
result: <span id="result"></span><br>

<button id="btnAdd" type="button">+</button>
<button id="btnSub" type="button">-</button>
<button id="btnMul" type="button">*</button>
<button id="btnDiv" type="button">/</button>
</body>
<script type="text/javascript">
$(function(){
	$("#btnAdd").click(()=>{
		let x = parseInt($("#x").val());
		let y = parseInt($("#y").val()); //input 태그의 값을 읽고 쓰기
		$("#result").html(x+y);	//선택된 요소의 값을 읽고 쓰기
		
	})
})
</script>
</html>