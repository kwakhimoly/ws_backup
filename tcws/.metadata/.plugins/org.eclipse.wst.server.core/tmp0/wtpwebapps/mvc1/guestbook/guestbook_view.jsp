<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kosa.mvc1.guestbook.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook View</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<%
String seq = request.getParameter("seq");
%>
<form name="myform">
<input type="hidden" name="seq" value="<%=seq%>">
<input type="hidden" name="cmd">
	<%@include file="/include/navbar.jsp"%>


	<div class="container mt-3">
		<h3>방명록</h3>
		<p>This example adds a dropdown menu in the navbar.</p>

		<%
		GuestbookDto dto = (GuestbookDto) request.getAttribute("dto");
		%>
		<table class="table">
			<colgroup>
				<col width="15%">
				<col width="18%">
				<col width="15%">
				<col width="18%">
				<col width="15%">
				<col width="18%">
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td colspan="5"><%=dto.getTitle()%></td>
					
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=dto.getUser_name()%></td>
					<th>작성일</th>
					<td><%=dto.getWdate()%></td>
					<th>조회수</th>
					<td><%=dto.getHit()%></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="5" style="word-break: break-all;"><%=dto.getContent().replaceAll("\r\n", "<br>")%></td>
				</tr>


			</tbody>
		</table>
	</div>


	<div class="container" style="text-align: right">
		<button type="button" class="btn btn-primary" id="btnList">목록</button>&nbsp;&nbsp;
		<%if(dto.getWriter().equals(session.getAttribute("user_id"))){ %>
		<!-- session을 앞에 쓰면, 로그인 안한 상태일 때 session 값이 null이 되기 때문에 equals를 이용해 writer 값과 비교하는 것이 불가능
			하지만 이미 writer은 항상 존재하고 있기 때문에 null일 가능성이 없으며, 존재하는 값과 null을 비교하는 것은 가능하기 때문에
			writer을 앞으로 빼야 함. -->
		<!-- 이렇게 코드를 작성하는 경우, 로그인이 안 되었을 때엔 script에서 modify, delete 버튼이 존재하지 않는 상태에서 event를 만들어놓은 것이
			되어 에러가 발생함. script에도 비슷한 처리를 해야 함. -->
		<button type="button" class="btn btn-primary" id="btnModify">수정</button>&nbsp;&nbsp;
		<button type="button" class="btn btn-primary" id="btnDelete">삭제</button>&nbsp;&nbsp;
		<%} %>
	</div>


</form>
</body>
<script type="text/javascript">
window.onload=()=>{
	let frm = document.myform;
	
	let btnList = document.getElementById("btnList");
	btnList.addEventListener("click",()=>{
		frm.action = "<%=CONTEXT%>/guestbook.do";
		frm.cmd.value="list";
		frm.submit();
	})
	
	<%if(dto.getWriter().equals(session.getAttribute("user_id"))){ %>
	let btnModify = document.getElementById("btnModify");
	btnModify.addEventListener("click",()=>{
	frm.action="<%=CONTEXT%>/guestbook.do";
	frm.cmd.value="modify";
	frm.submit();		
	})
	
	
	let btnDelete = document.getElementById("btnDelete");
	btnDelete.addEventListener("click",()=>{
		if(confirm("삭제하시겠습니까?")){			
		frm.action = "<%=CONTEXT%>/guestbook.do";
		frm.cmd.value="delete";
		frm.submit();
		}
	})
	<%} %>

}
</script>
</html>