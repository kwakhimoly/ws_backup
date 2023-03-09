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
			<h3>login</h3>
			<p>로그인 정보 입력</p>


			<table class="table">
				<colgroup>
					<col width="30%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>아이디</th>
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="아이디를 입력하세요"
									name="user_id" id="user_id">
							</div>
						</td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td>
							<div class="input-group">
								<input type="password" class="form-control"
									placeholder="패스워드를 입력하세요" name="password" id="password">
							</div>
						</td>
					</tr>

				</tbody>
			</table>
		</div>


		<div class="container" style="text-align: right">
			<button type="button" class="btn" style="background-color: aliceblue" onclick="goLogin()">로그인</button>
			<button type="button" class="btn" style="background-color: lavenderblush" onclick="goFindid()">아이디 찾기</button>
			<button type="button" class="btn" style="background-color: lavenderblush" onclick="goFindpw()">비밀번호 찾기</button>
		</div>

	</form>
</body>
<script>
function goLogin(){
	let user_id = $("#user_id").val().trim();
	let password = $("#password").val().trim();
	
	$.ajax({
		url:"<%=request.getContextPath()%>/member/login_proc",
		data: {"user_id":user_id, "password":password},
		method:"POST",
		dataType:"JSON"
	})
	.done(function (response){
		alert(response.message);
		if(response.result=="0"){
//			로그인 성공 시 이동할 페이지 정보
			location.href="<%=request.getContextPath()%>/";
		}
	})
	.fail((response, status, error)=>{
		console.log(error);
	});
}

function goFindid(){
	location.href="<%=request.getContextPath()%>/member/findid";
}
function goFindpw(){
	location.href="<%=request.getContextPath()%>/member/findpw";
}

</script>
</html>