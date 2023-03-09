<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 
score_write.jsp 만들고
<form>~
	이름: <input>
	
입력을 받아서 db에 저장은
score_proc.jsp로 하고
score.jsp로 이동하기
 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String mode = request.getParameter("mode"); 
%>
<form name="myform">

<input type="hidden" name="mode" value="<%=mode%>">
학급번호: <input type="text" name="seq"> <br>
이름: <input type="text" name="name"> <br>
국어: <input type="text" name="kor"> <br>
영어: <input type="text" name="eng"> <br>
수학: <input type="text" name="mat"> <br>

<%if(mode.equals("insert")){%>
<button type="button" id="btnSend">등록</button>
<%} else if(mode.equals("modify")){ %>
<button type="button" id="btnSend">수정</button>
<%} %>
</form>
</body>
<script type="text/javascript">
window.onload=()=>{
	let btnSend = document.getElementById("btnSend");
	let frm = document.myform;
	<%if(mode.equals("insert")){%>
	btnSend.addEventListener("click", (e)=>{
		e.preventDefault();
		frm.action = "score_proc.jsp"; //데이터를 db에 저장
		frm.method="get";
		frm.submit();
	})
	<%}else if(mode.equals("modify")){%>
	btnSend.addEventListener("click", (e)=>{
		e.preventDefault();
		frm.action="score_proc.jsp";
		frm.method="get";
		frm.submit();
	})
	<%}%>
}



</script>
</html>