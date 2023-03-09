<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 메뉴 -->
<meta charset="UTF-8">
<!-- 한글 깨짐 방지 -->
<%
// 공통변수 CONTEXT 만들어 놓고 갖다 쓰기
String CONTEXT = request.getContextPath();
%>


<nav class="navbar navbar-expand-sm navbar-light" style="background-color: lavenderblush">
	<div class="container-fluid">
		<a class="navbar-brand" href="<%=CONTEXT%>"> <img
			src="<%=CONTEXT%>/images/logo.png" alt="Avatar Logo"
			style="width: 40px;" class="rounded-pill">
		</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Menu</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="<%=CONTEXT%>/movie.do?cmd=list">Watched Movie list</a></li>
						<li><a class="dropdown-item" href="<%=CONTEXT%>/movie.do?cmd=write">Watched Movie write</a></li>
						<li><a class="dropdown-item" href="#">A third link</a></li>
					</ul></li>
			</ul>
		</div>
<!-- 	<ul class="navbar-nav justify-content-end">
				<li class="nav-item">
				<a class="nav-link" href="https://pedia.watcha.com/ko-KR/">Watcha Pedia</a>
				</li>
			</ul> -->
		
	</div>
</nav>
<script type="text/javascript">
function goLogout() {
	let xhttp = new XMLHttpRequest();
	let url = "/mvc1/member.do?cmd=logout";
	
	xhttp.onload=function(){
		console.log(this.responseText);
		let data = JSON.parse(this.responseText);
		alert("로그아웃 되었습니다.");
		location.href="/mvc1";
	}
	
	xhttp.open("GET", url, true);
	xhttp.send();
}
</script>