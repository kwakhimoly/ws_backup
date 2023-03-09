<%@page import="javax.swing.text.Document"%>
<%@page import="com.kosa.mvc1.score.ScoreDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Score view</title>
</head>
<body>
<form name="myform">
<%
String seq = request.getParameter("seq");
ScoreDto dto = (ScoreDto)request.getAttribute("dto");
String CONTEXT = request.getContextPath();
%>
<input type="hidden" name="cmd">
<input type="hidden" name="seq" value="<%=seq%>">



<ul>
<li><%=dto.getSeq() %></li>
<li><%=dto.getName() %></li>
<li><%=dto.getKor() %></li>
<li><%=dto.getEng() %></li>
<li><%=dto.getMat() %></li>
<li><%=dto.getWdate() %></li>
</ul>


	<button type="button" id="btnList">목록</button>&nbsp;&nbsp;
	<button type="button" id="btnModify">수정</button>&nbsp;&nbsp;
	<button type="button" id="btnDelete">삭제</button>
	
</form>
<script type="text/javascript">
let btnList = document.getElementById("btnList");
let btnModify = document.getElementById("btnModify");
let btnDelete = document.getElementById("btnDelete");

let frm = document.myform;

btnList.addEventListener("click",()=>{
	frm.action="<%=CONTEXT%>/score.do";
	frm.cmd.value="list";
	frm.submit();
})

btnModify.addEventListener("click",()=>{
	frm.action="<%=CONTEXT%>/score.do";
	frm.cmd.value="modify";
	frm.submit();
})

btnDelete.addEventListener("click",()=>{
	if(confirm("삭제하시겠습니까?")){			
		frm.action = "<%=CONTEXT%>/score.do";
		frm.cmd.value="delete";
		frm.submit();
		}
})
</script>
</body>
</html>