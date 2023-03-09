<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<title>JQueryAjax</title>
</head>
<body>
	x: <input type="text" id="x"><br>

	<div id="result"></div>
	<button id="btnCall" type="button">구구단을 외자</button>
</body>
<script type="text/javascript">
	$(()=>{
		$("#btnCall").click(()=>{
			let x = $("#x").val();
			
			$.ajax({
				url : "multitb.jsp",
					data : {"x": x}
			})
			.done((data)=>{
				$("#result").html(data);
			})
			.fail((error)=>{})
		})
		
	});	
</script>
</html>