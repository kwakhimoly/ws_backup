<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script> 
$(()=>{
$("#box").click(()=>{
	$("#box").animate({
		left: "500px",
//		top: "150px", //top에서 150 밀어낸단 뜻이었나봐~~
		opacity: 0.2
	}, 3000, ()=>{
		$("#box").animate({
			top:"150px"
		});
	});
});
});

</script> 
</head>
<body>



<div id="box" style="background:#98bf21;height:100px;width:100px;position:absolute;"></div>

</body>
</html>
