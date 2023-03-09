<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample1</title>
	<!-- <script src="/jquerytest/js/jquery-3.6.3.min.js"></script> -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<h1>JQuery Test</h1>
	
	<button type="button" id="btnClick">click</button>
</body>
<script type="text/javascript">
//	자바 스크립트의 window.onload에 대응한다.
//	문서 전체가 메모리로 로딩되고 나면 이 부분이 호출된다.
//	자바 스크립트 : document.getElementbyId, ~~~
//	$("셀렉터")  
//				document.getElementbyId -> $("#btnClick")
//		$("태그")
//		$("#아이디")
//	value => val() 
	innerHTML => html()
	$(document).ready(()=>{
		$("#btnClick").click(()=>{
			$("h1").html("JQuery는 재밌다");
		})
	});
</script>
</html>