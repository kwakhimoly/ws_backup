<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log on</title>
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
	<form name="myform">

	<%@ include file="../include/navbar.jsp"%>




		<div class="container mt-3">
			<h3>find id</h3>
			<p>이메일, 이름 입력</p>


			<table class="table">
				<colgroup>
					<col width="30%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>이메일</th>
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="이메일을 입력하세요"
									name="email" id="email">
							</div>
						</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="이름을 입력하세요" name="user_name" id="user_name">
							</div>
						</td>
					</tr>

				</tbody>
			</table>
		</div>

		<div class="container" id="findresult" style="text-align:center; font-style: oblique; font-weight: bold;"></div>
		
		<div class="container" style="text-align: right">
			<button type="button" class="btn btn-primary" onclick="goFindid()">아이디 찾기</button>
		</div>

	</form>
</body>
<script>
function goFindid(){
	let email = $("#email").val().trim();
	let user_name = $("#user_name").val().trim();
	
	$.ajax({
		url:"<%=request.getContextPath()%>/member/findid_proc",
		data: {"email":email, "user_name":user_name},
		method:"POST",
		dataType:"JSON"
	})
	.done(function (response){
		alert(response.message);
		if(response.result=="0"){
//			로그인 성공 시 이동할 페이지 정보
			$("#findresult").html("아이디: "+response.user_id);
		}
	})
	.fail((response, status, error) => {
		console.log(error);
	});
}

</script>
</html>