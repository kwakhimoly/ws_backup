<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fade test</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#btnFadeIn").click(function(){
    $("#div1").fadeIn(); //기본 시간
    $("#div2").fadeIn("slow"); //천천히
    $("#div3").fadeIn(3000, ()=>{
    	alert("완료");
    }); //3초 동안(1000=1초, 3000이라는 시간 부여)
  });
  $("#btnFadeOut").click(function(){
	  $("#div1").fadeOut();
	  $("#div2").fadeOut("slow");
	  $("#div3").fadeOut(3000, ()=>{
		  alert("fin");
	  });
  });
});
</script>
</head>
<body>

<p>Demonstrate fadeIn() / fadeOut() with different parameters.<br>
fadeIn / fadeOut 함수 다른 파라미터 적용시켜 보기</p>

<button type="button" id="btnFadeIn">Click to fade in boxes</button><br><br>
<button type="button" id="btnFadeOut">Click to fade out boxes</button><br><br>

<div id="div1" style="width:80px;height:80px;display:none;background-color:lightpink;"></div><br>
<div id="div2" style="width:80px;height:80px;display:none;background-color:lightgreen;"></div><br>
<div id="div3" style="width:80px;height:80px;display:none;background-color:lightblue;"></div>

</body>
</html>
