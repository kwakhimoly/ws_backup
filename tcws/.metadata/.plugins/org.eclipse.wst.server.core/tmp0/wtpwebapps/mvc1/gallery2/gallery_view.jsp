<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kosa.mvc1.gallery.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gallery View</title>
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
		<h3>갤러리</h3>
		<p>This example adds a dropdown menu in the navbar.</p>

		<%
		GalleryDto dto = (GalleryDto) request.getAttribute("dto");
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
					<td colspan="6"><%=dto.getTitle()%></td>
					
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
					<td colspan="6">
						<img
							src="<%=CONTEXT%>/upload/gallery/<%=dto.getImage()%>" 
							alt="<%=dto.getTitle() %>" 
						style="width: 80%">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="6" style="word-break: break-all;"><%=dto.getContent().replaceAll("\r\n", "<br>")%></td>				
				</tr>				
				


			</tbody>
		</table>
	</div>


	<div class="container" style="text-align: right">
		<button type="button" class="btn btn-primary" id="btnList">목록</button>&nbsp;&nbsp;
		<%if(dto.getWriter().equals(session.getAttribute("user_id"))){ %>
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
		frm.action = "<%=CONTEXT%>/gallery.do";
		frm.cmd.value="list";
		frm.submit();
	})
	
	<%if(dto.getWriter().equals(session.getAttribute("user_id"))){ %>
	let btnModify = document.getElementById("btnModify");
	btnModify.addEventListener("click",()=>{
	frm.action="<%=CONTEXT%>/gallery.do";
	frm.cmd.value="modify";
	frm.submit();		
	})
	
	
	let btnDelete = document.getElementById("btnDelete");
	btnDelete.addEventListener("click",()=>{
		if(confirm("삭제하시겠습니까?")){			
		frm.action = "<%=CONTEXT%>/gallery.do";
		frm.cmd.value="delete";
		frm.submit();
		}
	})
	<%} %>

}
</script>
</html>