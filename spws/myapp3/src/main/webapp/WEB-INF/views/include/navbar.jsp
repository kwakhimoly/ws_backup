<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메뉴 -->
<meta charset="UTF-8">
<!-- 한글 깨짐 방지 -->
<%
// 공통변수 CONTEXT 만들어 놓고 갖다 쓰기
String CONTEXT = request.getContextPath();
%>


<nav class="navbar navbar-expand-sm navbar-light" style="background-color: lavender">
	<div class="container-fluid">
		<a class="navbar-brand" href="<%=CONTEXT%>"> <img
			src="https://imjustcreative.com/wp-content/uploads/2015/11/Screenshot-2019-11-23-17.32.44.jpg" alt="Avatar Logo"
			style="width: 40px;" class="rounded-pill">
		</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="<%=CONTEXT%>/board/list?pg=0">List</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=CONTEXT%>/board/write">Write</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=CONTEXT%>/member/write">Sign up</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Gallery</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="<%=CONTEXT%>/gallery/list">Gallery list</a></li>
						<li><a class="dropdown-item" href="<%=CONTEXT%>/gallery/write">Gallery write</a></li>
						<li><a class="dropdown-item" href="#">A third link</a></li>
					</ul></li>
			</ul>
		</div>
		<%if(session.getAttribute("user_id")==null||session.getAttribute("user_id").equals("")) {%>
			<ul class="navbar-nav justify-content-end">
				<li class="nav-item">
				<a class="nav-link" href="<%=CONTEXT%>/member/login">로그인</a>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="<%=CONTEXT%>/member/write">회원가입</a>
				</li>
			</ul>
		<%} else {%>
			<ul class="navbar-nav justify-content-end">
				<li class="nav-item">
				<a class="nav-link" href="#none"><%=session.getAttribute("user_name") %></a>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="#none" onclick="goLogout()">로그아웃</a>
				</li>
			</ul>
		<%} %>
	</div>
</nav>
<script type="text/javascript">
function goLogout() {
	$.ajax({
		url:"<%=request.getContextPath()%>/member/logout",
		method:"POST",
		dataType:"JSON"
	})
	.done(function (response){
		alert(response.message);
		if(response.result=="success"){
			location.href="<%=request.getContextPath()%>/";
		}
	})
	.fail((response, status, error)=>{
		console.log(error);
	});
}

</script>