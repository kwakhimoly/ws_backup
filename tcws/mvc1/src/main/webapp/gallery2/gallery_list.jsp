<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kosa.mvc1.gallery.*, com.kosa.mvc1.common.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gallery list</title>
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

	<form id="myform" name="myform">
		<input type="hidden" id="cmd" name="cmd">
		<input type="hidden" id="seq" name="seq">
		<input type="hidden" id="pg" name="pg">

		<div class="container mt-3">
			<h3>Navbar With Dropdown</h3>
			<p>This example adds a dropdown menu in the navbar.</p>

			<div class="input-group mt-3 mb-3">
				<button type="button" class="btn btn-primary dropdown-toggle"
					data-bs-toggle="dropdown">Dropdown button</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">Link 1</a></li>
					<li><a class="dropdown-item" href="#">Link 2</a></li>
					<li><a class="dropdown-item" href="#">Link 3</a></li>
				</ul>
				<input type="text" class="form-control" placeholder="Username">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button">GO</button>
				</div>
			</div>

<%	List<GalleryDto> list = (List<GalleryDto>)request.getAttribute("list"); 
	int totalCnt = (int)request.getAttribute("totalCnt");
	
	for(int i=0; i<list.size(); i++){
		GalleryDto dto = list.get(i);
		if(i%4==0){
%>
			<div class="row"> 
<!-- 이미지 4개당 한번씩 등장해야 한다 => i가 4로 나누었을 때 나머지가 0일 때 열을 새로 생성 -->
<% }%>
		<% String url = CONTEXT+"/gallery.do?cmd=view&seq="+dto.getSeq();%>
				<div class="col-sm-3">
					<div class="thumbnail">
						<a href="#none" onclick="goView(<%=dto.getSeq()%>);"> 
						<img
							src="<%=CONTEXT%>/upload/gallery/<%=dto.getImage()%>" 
							alt="<%=dto.getTitle() %>" style="width: 100%">
							<div class="caption">
								<p><%=dto.getTitle() %></p>
							</div>
						</a>
					</div>
				</div>
<%	if( i%4==3 || i==list.size()-1) {	%>
			</div> 
<!-- div 태그를 닫아야 함 => 조건: 0부터 시작하는 i가 3까지 갔을때(4개가 등록됐을 때) 혹은 i가 list.size(1부터 시작)와 같은 숫자, 즉 마지막 사진일 때 닫기 -->
<% 	}}	%>


		</div>
		<br>
		<div class="container" style="text-align: right">
			<%=Pager.makeTag(request, totalCnt, 12) %>
		</div>

		<div class="container" style="text-align: right">
			<button type="button" class="btn btn-primary" id="btnWrite">글쓰기</button>
		</div>

	</form>
</body>
<script>
$(()=>{
	$("#btnWrite").click(()=>{
		let frm = $("#myform");
		$("#cmd").val("write"); //파라미터에 write 저장
		frm.prop("action", "<%=CONTEXT%>/gallery.do");
		//action 속성에 url 주는 jquery 방식
		frm.submit();
	})
})

function goView(seq){
	let frm = $("#myform");
	$("#cmd").val("view");
	$("#seq").val(seq);
	frm.prop("action", "<%=CONTEXT%>/gallery.do");
	frm.submit();
}

function goPage(page){
	let frm = document.myform;
	frm.pg.value = page; //필요한 파라미터들에 모두 값 넣고
	frm.cmd.value="list";
	frm.action="<%=CONTEXT%>/gallery.do";
	frm.submit();
}

</script>
</html>