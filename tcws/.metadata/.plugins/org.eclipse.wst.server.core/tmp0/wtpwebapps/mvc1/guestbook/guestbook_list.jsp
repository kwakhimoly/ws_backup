<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.kosa.mvc1.guestbook.*"%>
<%@ page import="com.kosa.mvc1.common.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook List</title>
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
	<form name="myform" id="myform">
		<input type="hidden" name="cmd" id="cmd"> <input type="hidden"
			name="pg" id="pg" value="<%=pg%>"> <input type="hidden"
			name="searchOpt" id="searchOpt" value="<%=searchOpt%>">

		<%@ include file="/include/navbar.jsp"%>


		<div class="container mt-3">
			<h3>게시판</h3>
			<p>This example adds a dropdown menu in the navbar.</p>

			<div class="input-group mt-3 mb-3">
				<button type="button" class="btn btn-primary dropdown-toggle"
					data-bs-toggle="dropdown">
					<span id="select">검색</span>
				</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#none"
						onclick="goSelect('1')">제목</a></li>
					<li><a class="dropdown-item" href="#none"
						onclick="goSelect('2')">내용</a></li>
					<li><a class="dropdown-item" href="#none"
						onclick="goSelect('3')">제목+내용</a></li>
				</ul>
				<input type="text" class="form-control" placeholder="키워드를 입력하세요.."
					name="searchKey" id="searchKey" value="<%=searchKey%>">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button" onclick="goSearch()">GO</button>
				</div>
			</div>

			<table class="table">
				<colgroup>
					<!-- 테이블의 열별로 공통 스타일을 적용하고자 할 때 사용. 각 컬럼의 크기 지정에 많이 사용된다. -->
					<col style="width: 8%">
					<col style="width: *">
					<col style="width: 14%">
					<col style="width: 18%">
					<col style="width: 10%">
				</colgroup>
				<thead class="table-dark">
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
					int totalCnt = (int) request.getAttribute("totalCnt");
					List<GuestbookDto> list = (List<GuestbookDto>) request.getAttribute("list");
					//request.getAttribute => object(정보가 들어 있음)->list로 변환(다운캐스팅)->list의 형식을 dto로 지정
					//다운 캐스팅을 하자

					for (GuestbookDto dto : list) {
						String url = CONTEXT + "/guestbook.do?cmd=view&seq=" + dto.getSeq();
					%>

					<tr>
						<td><%=totalCnt - dto.getRnum() + 1%></td>
						<td><a href="<%=url%>"><%=dto.getTitle()%></a></td>
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
			<!--  <ul class="pagination justify-content-center">
  	<li class="page-item"><a class="page-link" href="#none" onclick = "goPage('0')">first</a></li>
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    <li class="page-item"><a class="page-link" href="#none" onclick = "goPage('0')">1</a></li>
    <li class="page-item"><a class="page-link" href="#none" onclick = "goPage('1')">2</a></li>
    <li class="page-item"><a class="page-link" href="#none" onclick = "goPage('2')">3</a></li>
    <li class="page-item"><a class="page-link" href="#none" onclick = "goPage('3')">4</a></li>
    <li class="page-item"><a class="page-link" href="#none" onclick = "goPage('4')">5</a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
    <li class="page-item"><a class="page-link" href="#">last</a></li>
  </ul> -->
			<%=Pager.makeTag(request, totalCnt, 10)%>
		</div>

		<div class="container" style="text-align: right">
			<button type="button" class="btn btn-primary" id="btnWrite">글쓰기</button>
		</div>

	</form>
</body>
<script type="text/javascript">
	let title = ["검색", "제목", "내용", "제목+내용"];
	let sel = '<%=searchOpt%>';
window.onload=()=>{
	//자바스크립트에서 자바 코드 사용 가능
	
	if(sel==""){
		sel=0;
		$("#select").html(title[0]);
	} else{
		$("#select").html(title[sel])
	}
	
	let user_id = '<%=session.getAttribute("user_id")%>';
	console.log(user_id);
	
	
	let btnWrite = document.getElementById("btnWrite");
	btnWrite.addEventListener("click",()=>{
	if(user_id=="null"||user_id==""){
		alert("로그인을 하세요");
		location.href="<%=CONTEXT%>/member.do?cmd=logon"; //로그인 페이지로 이동하기
		return;
		}
		let frm = document.myform;
		frm.action = "<%=CONTEXT%>/guestbook.do";
		frm.cmd.value="write";
		frm.submit();
	})
}

function goPage(page){
	let frm = document.myform;
	frm.pg.value = page; //필요한 파라미터들에 모두 값 넣고
	frm.cmd.value="list";
	frm.action="<%=CONTEXT%>/guestbook.do";
	frm.submit();
}

function goSelect(sel){
	$("#searchOpt").val(sel);
	// li 태그는 value가 없다. 그래서 hidden 태그에 값을 저장한다. 
	$("#select").html(title[sel]);
}

function goSearch(){
	let frm = document.myform;
	frm.pg.value=0; // 검색 누르면 어느 페이지에 있었던 첫 페이지로 이동
	frm.cmd.value="list";
	frm.action="<%=CONTEXT%>/guestbook.do";
	frm.submit();
}
</script>
</html>