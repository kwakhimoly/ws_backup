<%@page import="com.kwak.movie.review.ReviewDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kwak.movie.*, com.kwak.movie.common.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review list</title>
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

	<%@ include file="/include/navbar.jsp"%>
<%
	String pg = request.getParameter("pg");
	String searchOpt = request.getParameter("searchOpt");
	String searchKey = request.getParameter("searchKey");

	if (pg == null || pg.equals("")) {
		pg = "0";
	}
	if (searchOpt == null) {
		searchOpt = "";
	}
	if (searchKey == null) {
		searchKey = "";
	}
	%>
	
	
	<form id="myform" name="myform">
		<input type="hidden" id="cmd" name="cmd"> 
		<input type="hidden" id="seq" name="seq">
		<input type="hidden" id="pg" name="pg" value="<%=pg%>">
		<input type="hidden" name="searchOpt" id="searchOpt" value="<%=searchOpt%>">

		<div class="container mt-3">
			<h3>Look what you watched!</h3>
			<p>don't you have a life?</p>

			<div class="input-group mt-3 mb-3">
				<button type="button" class="btn dropdown-toggle" style="background-color: lavenderblush"
					data-bs-toggle="dropdown">
					<span id="select">검색</span>
				</button> &nbsp;
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#none"
						onclick="goSelect('1')">제목</a></li>
					<li><a class="dropdown-item" href="#none"
						onclick="goSelect('2')">배우</a></li>
					<li><a class="dropdown-item" href="#none"
						onclick="goSelect('3')">별점</a></li>
				</ul>
				<input type="text" class="form-control" placeholder="키워드를 입력하세요.."
					name="searchKey" id="searchKey" value="<%=searchKey%>">
					&nbsp;
				<div class="input-group-append">
					<button class="btn" style="background-color: lavenderblush" type="button" onclick="goSearch()">GO</button>
				</div>
			</div>

			<%
			List<ReviewDto> list = (List<ReviewDto>) request.getAttribute("list");
			int totalCnt = (int)request.getAttribute("totalCnt");

			for (int i = 0; i < list.size(); i++) {
				ReviewDto dto = list.get(i);
				if (i % 4 == 0) {
			%>
			<div class="row">
				<!-- 이미지 4개당 한번씩 등장해야 한다 => i가 4로 나누었을 때 나머지가 0일 때 열을 새로 생성 -->
				<%
				}
				%>
				<%
				String url = CONTEXT + "/movie.do?cmd=view&seq=" + dto.getM_seq();
				%>
				<div class="col-sm-3">
					<div class="thumbnail">
						<a href="<%=url%>">
							<img src="<%=CONTEXT%>/upload/poster/<%=dto.getM_poster()%>"
							alt="<%=dto.getM_title()%>"style="width: 100%; height: 100%;">
						</a>

						<div class="caption">
							<table class="table">
								<colgroup>
									<col style="width: 40%">
									<col style="width: *">
								</colgroup>
								<thead>
									<tr>
										<th style="background-color: lavenderblush;">영화 제목</th>
										<td><%=dto.getM_title()%></td>
									</tr>
									<tr>
										<th style="background-color: lavenderblush;">작성자</th>
										<td><%=dto.getM_writer()%></td>
									</tr>
									<tr>
										<th style="background-color: lavenderblush;">감상일</th>
										<td><%=dto.getM_date()%></td>
									</tr>
									<tr>
										<th style="background-color: lavenderblush;">별점</th>
										<td><%=dto.getM_rate()%></td>
									</tr>

								</thead>
							</table>
						</div>
						
					</div>
				</div>
					
				<%
				if (i % 4 == 3 || i == list.size() - 1) {
				%>
			</div>
			<%
			}
			}
			%>


		</div>
		<br>
		<div class="container" style="text-align: right">
			<%=Pager.makeTag(request, totalCnt, 12)%>
		</div>

		<div class="container" style="text-align: right">
			<button type="button" class="btn" style="background-color: lavenderblush" id="btnWrite">글쓰기</button>
		</div>

	</form>
</body>
<script>

let title = ["검색", "제목", "배우", "별점"];
let sel = '<%=searchOpt%>';

$(()=>{
if(sel==""){
	sel=0;
	$("#select").html(title[0]);
} else{
	$("#select").html(title[sel])
}
	$("#btnWrite").click(()=>{
		let frm = $("#myform");
		$("#cmd").val("write"); //파라미터에 write 저장
		frm.prop("action", "<%=CONTEXT%>/movie.do");
		frm.submit();
	})
})


function goPage(page){
	let frm = document.myform;
	frm.pg.value = page; //필요한 파라미터들에 모두 값 넣고
	frm.cmd.value="list";
	frm.action="<%=CONTEXT%>/movie.do";
	frm.submit();
}

function goSelect(sel){
	$("#searchOpt").val(sel);
	$("#select").html(title[sel]);
}

function goSearch(){
	let frm = document.myform;
	frm.pg.value=0; // 검색 누르면 어느 페이지에 있었던 첫 페이지로 이동
	frm.cmd.value="list";
	frm.action="<%=CONTEXT%>/movie.do";
	frm.submit();
}

</script>
</html>