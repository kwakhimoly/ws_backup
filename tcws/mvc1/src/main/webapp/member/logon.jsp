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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

</head>
<body>
	<form name="myform">
		<input type="hidden" name="idcheck" id="idcheck" value="N">


		<%@ include file="/include/navbar.jsp"%>



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
			<button type="button" class="btn btn-primary" onclick="goLogon()">로그인</button>
			<button type="button" class="btn btn-primary" onclick="goFindid()">아이디찾기</button>
			<button type="button" class="btn btn-primary" onclick="goFindpw()">패스워드찾기</button>
		</div>

	</form>
</body>
<script>
function goLogon() {
	let user_id = document.getElementById("user_id").value;
	let password = document.getElementById("password").value;
	
	$.ajax({
		url:"<%=CONTEXT%>/member.do",
		data:{cmd:"logon_proc", user_id:user_id, password:password},
		dataType:"JSON",
		method:"POST"
	})
	.done((response)=>{
		console.log(response);
		if(response.result=="success"){
			alert("로그인 성공");
			location.href = "<%=CONTEXT%>";
		} else{
			alert("아이디나 비밀번호가 일치하지 않습니다.");
		}
	})
	.fail(
		(request, status, error)=>{
			console.log(request);
			console.log(status);
			console.log(error);
	});
}

function goFindid(){
	location.href="<%=CONTEXT%>/member.do?cmd=findID"
}
function goFindpw(){
	location.href="<%=CONTEXT%>/member.do?cmd=findPW"
}

</script>
</html>