<%@page import="com.kwak.mycompany.common.Pager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kwak.mycompany.guestbook.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

</head>
<body>
	<%
	String pg = request.getParameter("pg");
	String searchKey = request.getParameter("searchKey");
	String searchKeyword = request.getParameter("searchKeyword");
	if(pg==null||pg.equals("")){
		pg="0";
	}
	if(searchKey==null||searchKey.equals("")){
		searchKey="0";
	}
	if(searchKeyword==null||searchKeyword.equals("")){
		searchKeyword="";
	}
	%>
	<form name="myform" id="myform">
		<input type="hidden" name="pg" id="pg" value="<%=pg%>">

		<!-- 메뉴 -->
		<%@ include file="../include/navbar.jsp"%>



		<%
			List<GuestbookDto> list = (List<GuestbookDto>) request.getAttribute("list");
		int totalCnt = (Integer) request.getAttribute("totalCnt");
		%>

		<div class="container mt-3">
			<h3>Navbar With Dropdown</h3>
			<p>This example adds a dropdown menu in the navbar.</p>

			<div class="input-group mt-3 mb-3">
				<button type="button" class="btn dropdown-toggle" id="select"
					data-bs-toggle="dropdown" style="background-color: aliceblue">선택하세요</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#none" onclick="goSearchKey('0')">선택</a></li>
					<li><a class="dropdown-item" href="#none" onclick="goSearchKey('1')">제목</a></li>
					<li><a class="dropdown-item" href="#none" onclick="goSearchKey('2')">내용</a></li>
					<li><a class="dropdown-item" href="#none" onclick="goSearchKey('3')">제목+내용</a></li>
				</ul>
				<input type="hidden" name="searchKey" id="searchKey" value="<%=searchKey%>">
				<input type="text" class="form-control" id="searchKeyword" name="searchKeyword" placeholder="검색어를 입력하세요" value="<%=searchKeyword%>">
				<div class="input-group-append">
					&nbsp;
					<button class="btn" type="button"
						style="background-color: aliceblue" onclick="goSearch()">GO</button>
				</div>
			</div>

			<table class="table">
				<colgroup>
					<col width="8%">
					<col width="*">
					<col width="12%">
					<col width="12%">
					<col width="8%">
					<col width="8%">
				</colgroup>
				<thead class="table" style="background-color: aliceblue">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < list.size(); i++) {
						GuestbookDto dto = list.get(i);
					%>
					<tr>
						<td><%=dto.getSeq()%></td>
						<td><a
							href="<%=request.getContextPath()%>/guestbook/view?seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
						<td><%=dto.getUser_name()%></td>
						<td><%=dto.getWdate()%></td>
						<td><%=dto.getHit()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<div class="container" style="text-align: right">
			<%=Pager.makeTag(request, totalCnt, 10)%>
			<!-- String 반환하니까 값으로 받기 -->
		</div>
		<%if(session.getAttribute("user_id")==null||session.getAttribute("user_id").equals("")) {%>
		<%} else{ %>
		<div class="container" style="text-align: right">
			<button type="button" class="btn" style="background-color: aliceblue"
				onclick="goWrite()">글쓰기</button>
		</div>
		<%} %>
	</form>
</body>
<script>
var select = ["선택하세요", "제목", "내용", "제목+내용"];

$(()=>{
	if($("#searchKey").val()==1){
		$("#select").html(select[1]);
	} else if($("#searchKey").val()==2){
		$("#select").html(select[2]);
	} else if($("#searchKey").val()==3){		
		$("#select").html(select[3]);
	} else{
		$("#select").html(select[0]);
	}
})
function goSearchKey(key){
	$("#select").html(select[key]);
	$("#searchKey").val(key);
}
function goSearch(){
	$("#myform").prop("action", "<%=request.getContextPath()%>/guestbook/list");
	$("#myform").submit();
}
function goPage(pg) {
	//alert(pg); -> 디버깅용
	document.getElementById("pg").value=pg;
	var frm = document.myform;
	frm.method="get";
	frm.action = "<%=request.getContextPath()%>/guestbook/list";
	frm.submit();
}
function goWrite() {
	var frm = document.myform;
	frm.action="<%=request.getContextPath()%>/guestbook/write";
	frm.method = "post";
	frm.submit();
}
</script>
</html>