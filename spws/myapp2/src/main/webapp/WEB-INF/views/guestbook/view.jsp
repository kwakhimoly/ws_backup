<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

</head>
<body>

	<%
		//	일단 가장 큰 차이점은 둘의 리턴 타입이다.
	//		getParameter()메서드의 경우 String타입을 리턴하는반면,
	//		getAttribute()는 Object 타입을 리턴하기 때문에 주로 빈 객체나 다른 클래스를 받아올때 사용된다.

	String seq = request.getParameter("seq"); //폼태그로 넘긴 거 = 파라미터
	GuestbookDto dto = (GuestbookDto)request.getAttribute("dto"); //dto 넣은거 = 어트리뷰트
	%>

	<form id="myform" name="myform">
		<input type="hidden" name="seq" id="seq">
		<!-- 메뉴 -->
		<%@ include file="../include/navbar.jsp"%>





		<div class="container mt-3">
			<h3>Navbar With Dropdown</h3>
			<p>This example adds a dropdown menu in the navbar.</p>


			<table class="table">
				<colgroup>
					<col width="30%">
					<col width="*">
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
						<td colspan="54"><%=dto.getContent().replaceAll("\n", "<br>")%></td>
					</tr>

				</tbody>
			</table>
		</div>


		<div class="container" style="text-align: right">
			<button type="button" class="btn" style="background-color: aliceblue" onclick="goWrite()">글쓰기</button>
			<button type="button" class="btn" style="background-color: aliceblue" onclick="goList()">목록</button>
		</div>

	</form>
</body>
	<script>
	function goWrite(){
		location.href="<%=request.getContextPath()%>/guestbook/write";
	}
	function goList(){
		location.href="<%=request.getContextPath()%>/guestbook/list";
	}
	</script>
</html>