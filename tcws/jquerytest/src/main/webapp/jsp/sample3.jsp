<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample3</title>
	<!-- script src="/jquerytest/js/jquery-3.6.3.min.js"></script -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<p> p태그1 </p>
	<p> p태그2 </p>
	<p> p태그3 </p>
	<p> p태그4 </p>
	<p> p태그5 </p>
	<p class="intro"> p태그6 </p>
	<p> p태그7 </p>
	<p class="intro"> p태그8 </p>
	<p class="intro"> p태그9 </p>
	
	<h3 class="intro">h3 태그1</h3>
	<h3 class="intro">h3 태그2</h3>
	<h3 class="intro">h3 태그3</h3>
	
	
	<button type="button" id="btnClick1">전체적용</button>
	<button type="button" id="btnClick2">클래스적용1</button>
	<button type="button" id="btnClick3">클래스적용2</button>
	<button type="button" id="btnClick4">첫번째것만</button>
	<hr style="border: 1px dashed;">
	<table>
	<tr>
		<td>1행 1열</td><td>1행 2열</td>
	</tr>
	<tr>
		<td>2행 1열</td><td>2행 2열</td>
	</tr>
	<tr>
		<td>3행 1열</td><td>3행 2열</td>
	</tr>
	<tr>
		<td>4행 1열</td><td>4행 2열</td>
	</tr>
	<tr>
		<td>5행 1열</td><td>5행 2열</td>
	</tr>
	</table>
	
	<button type="button" id="btnChange">테이블 선택</button>
</body>
<script >
	$(document).ready( ()=>{
		
		$("#btnClick1").click(()=>{
			$("*").css("color", "red"); //스타일 바꾸기 
		});
		//"*" => 전체적용: 버튼의 텍스트 컬러도 바뀜
		
		$("#btnClick2").click(()=>{
			$(".intro").css("color", "green");
		});
		
		$("#btnClick3").click(()=>{
			$("p.intro").css("color", "blue");
		});
		// p.intro : p 태그의 intro 클래스만 적용
		
		$("#btnClick4").click(()=>{
			$("p:first").css("color", "violet");
			$("h3:first").css("background-color", "yellow");
			
			$("p:last").css("color", "magenta");
			$("h3:last").css("background-color", "gray");			
		});
		
		$("#btnChange").click(()=>{
			$("tr:odd").css("background-color", "red");
		});
	});
	
</script>
</html>