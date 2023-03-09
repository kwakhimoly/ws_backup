<%@page import="com.kosa.mvc1.score.ScoreDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Score write</title>
</head>
<body>
<%
String seq = request.getParameter("seq");
String cmd = request.getParameter("cmd");
String CONTEXT = request.getContextPath();

ScoreDto dto = (ScoreDto)request.getAttribute("dto");
	
	if(dto==null){ 
		dto=new ScoreDto(); 
	}
	
%>
	<form name="myform" method="post">
	<input type="hidden" name="cmd">
		번호: <input type="text" name="seq"><br> 
		이름: <input type="text" name="name"><br> 
		국어 점수: <input type="text" name="kor"><br> 
		영어 점수: <input type="text" name="eng"><br> 
		수학 점수: <input type="text" name="mat"><br> 
		
	<button type="button" id="btnSave" value="등록">저장</button>
	</form>
</body>
<script type="text/javascript">
let btnSave = document.getElementById("btnSave");
btnSave.addEventListener("click", ()=>{
	let frm = document.myform;
	frm.action="<%=CONTEXT%>/score.do";
	<%if(cmd.equals("write")){%>
	frm.cmd.value="save";
	<%}else if(cmd.equals("modify")){%>
	frm.cmd.value="update";
	<%}%>
	frm.submit();
})
</script>
</html>