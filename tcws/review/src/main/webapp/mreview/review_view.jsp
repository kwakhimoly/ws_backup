<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kwak.movie.review.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie view</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
input[type=number] {-webkit-text-security:disc;}
</style>
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
		<h3>What you watched</h3>
		<p>do you love it?</p>

		<%
		ReviewDto dto = (ReviewDto) request.getAttribute("dto");
		%>
		<table class="table">
			<colgroup>
				<col width="15%">
				<col width="18%">
				<col width="15%">
				<col width="18%">
				<col width="15%">
				<col width="18%">
				<col width="18%">
				<col width="18%">
			</colgroup>
			<tbody>
			<tr>
					<td colspan="2">
						<img
							src="<%=CONTEXT%>/upload/poster/<%=dto.getM_poster()%>" 
							alt="<%=dto.getM_title() %>" 
						style="width: 100%">
					</td>
					<td colspan="4"></td>
			</tr>
			<tr>
					<th style="background-color: lavenderblush">제목</th>
					<td colspan="5"><%=dto.getM_title()%></td>
			</tr>
				<tr>
					<th style="background-color: lavenderblush">감독</th>
					<td colspan="2"><%=dto.getM_director()%></td>
					<th style="background-color: lavenderblush">주연배우</th>
					<td colspan="2"><%=dto.getM_actor()%></td>
					
				</tr>
				<tr>
					<th style="background-color: lavenderblush">작성자</th>
					<td><%=dto.getM_writer()%></td>
					<th style="background-color: lavenderblush">감상일</th>
					<td><%=dto.getM_date()%></td>
					<th style="background-color: lavenderblush">별점</th>
					<td><%=dto.getM_rate()%></td>
					
				</tr>
				<tr>
					<th style="background-color: lavenderblush">내용</th>
					<td colspan="6" style="word-break: break-all;"><%=dto.getM_review().replaceAll("\r\n", "<br>")%></td>				
				</tr>
				<tr>
				</tr>				
				


			</tbody>
		</table>
	</div>


	<div class="container" style="text-align: right">
	<input type="number" inputmode="numeric" class="form-control" placeholder="비밀번호는 최대 6자리 숫자입니다."
									style="-webkit-text-security:disc" name="m_password" id="m_password">
		<button type="button" class="btn" style="background-color: lavenderblush" id="btnList">목록</button>&nbsp;&nbsp;
		<button type="button" class="btn" style="background-color: lavenderblush" id="btnDelete">삭제</button>&nbsp;&nbsp;
		
	</div>


</form>
</body>
<script type="text/javascript">
window.onload=()=>{
	let frm = document.myform;
	
	let btnList = document.getElementById("btnList");
	btnList.addEventListener("click",()=>{
		frm.action = "<%=CONTEXT%>/movie.do";
		frm.cmd.value="list";
		frm.submit();
	})
	
	

	
	let btnDelete = document.getElementById("btnDelete");
	btnDelete.addEventListener("click",()=>{
		if(confirm("삭제하시겠습니까?")){			
		frm.action = "<%=CONTEXT%>/movie.do";
		frm.cmd.value="delete";
		frm.submit();
		}
	})


}
</script>
</html>