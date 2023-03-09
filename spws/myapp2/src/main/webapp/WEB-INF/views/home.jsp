<%@page import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  
  <style type="text/css">
  body {
	font-family: cursive, fantasy;
}
  </style>
</head>
<body>
<form id="myform" name="myform">

<!-- Carousel -->
<div id="demo" class="carousel slide" data-bs-ride="carousel">
<div id="contents">
<!-- json data 자리 -->
</div>

  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>

<div class="container-fluid mt-3" style="text-align: center;">
  <h3>Welcome home!</h3>
  <p style="font-family: monospace"><a href="#none" onclick="goLogin()">Hi</a>, <a href="<%=request.getContextPath()%>/guestbook/list">there</a> <a href="<%=request.getContextPath()%>/gallery/list">:)</a></p>
</div>
</form>
</body>
<script type="text/javascript">
let car = "";
$(()=>{
	load_data();
})

function goLogin(){
	<% HttpSession session = request.getSession();
	if(session.getAttribute("user_id")==null||session.getAttribute("user_id").equals("")){
	%>
	$("#myform").prop("action", "<%=request.getContextPath() %>/member/login");
	$("#myform").submit();
	<% } else{ %>
	$("#myform").prop("action", "<%=request.getContextPath()%>/guestbook/list");
	$("#myform").submit();
	<%}%>
}

function load_data(){
	$.ajax({
		url:"<%=request.getContextPath()%>/home/carousel_data",
		dataType:"JSON",
		method:"POST"
	})
	.done(function (res){
		console.log(res);
		let data = res.data;
		car = "<div class='carousel-indicators'>";
		
		for(i=0; i<3; i++){
			car += "<button type='button' data-bs-target='#demo' data-bs-slide-to='"+i+"' class='active'></button>";
		}
		
		car += "</div>";
		
		car += "<div class='carousel-inner'>";
		
		for(i=0; i<3; i++){
			if(i==0){
				car += "<div class='carousel-item active'> ";				
			}
			else {
				car += "<div class='carousel-item'> ";				
			}
			car += "<img src='<%=request.getContextPath()%>/upload/"+data[i].image1+"' alt='"+data[i].title+"' class='d-block' style='width:100%;'>";
			car += "</div>";
		}
		
		car += "</div>";
		$("#contents").html(car);
		
	})
	.fail(function (res, status, error){
		console.log(status);
		console.log(error);
	})
}


</script>
</html>