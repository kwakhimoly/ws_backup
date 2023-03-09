<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form id="myform" name="myform">

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
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="제목을 입력하세요"
									name="title" id="title">
							</div>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<div class="input-group">
							<input type="hidden" class="form-control" name="writer" id="writer" value="<%=session.getAttribute("user_id")%>">
								<input type="text" class="form-control" placeholder="이름을 입력하세요"
									name="user_name" id="user_name" readonly value="<%=session.getAttribute("user_name")%>">
							</div>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<div class="input-group">
								<textarea class="form-control" placeholder="내용 입력하세요"
									name="content" id="content" rows="5"></textarea>
							</div>
						</td>
					</tr>


				</tbody>
			</table>
		</div>


		<div class="container" style="text-align: right">
			<button type="button" class="btn" style="background-color: aliceblue" onclick="goSave()">글쓰기</button>
			<button type="button" class="btn" style="background-color: aliceblue" onclick="goList()">목록</button>
		</div>

	</form>
</body>
<script type="text/javascript">
function goSave() {
	var frm = document.myform;
	frm.action="<%=request.getContextPath()%>/guestbook/save";
	frm.method="post";
	frm.submit();
}
function goList(){
	location.href="<%=request.getContextPath()%>/guestbook/list";
}
</script>
</html>