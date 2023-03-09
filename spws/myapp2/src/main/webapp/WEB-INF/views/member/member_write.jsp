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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<form name="myform" id="myform">
		<input type="hidden" name="idcheck" id="idcheck" value="N">
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
						<th>아이디</th>
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="아이디를 입력하세요"
									name="user_id" id="user_id"> <button type="button"
									class="input-group-text" onclick="goIdcheck()">아이디중복체크</button>
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
					<tr>
						<th>패스워드확인</th>
						<td>
							<div class="input-group">
								<input type="password" class="form-control"
									placeholder="패스워드를 입력하세요" name="password2" id="password2">
							</div>
						</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="이름을 입력하세요"
									name="user_name" id="user_name">
							</div>
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>
							<div class="input-group">
								<input type="email" class="form-control" placeholder="이메일을 입력하세요"
									name="email" id="email">
							</div>
						</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>
							<div class="input-group">
								<input type="tel" class="form-control" placeholder="전화번호를 입력하세요"
									name="phone" id="phone">
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>


		<div class="container" style="text-align: right">
			<button type="button" class="btn" style="background-color: aliceblue" onclick="goSave()">등록</button>
		</div>

	</form>
</body>
<script>
function goSave() {
	if($("#idcheck").val()=="N"){
		alert("아이디 중복체크를 하세요");
		$("#user_id").focus();
		return;
	}
	var frm = document.myform;
	frm.action="<%=request.getContextPath()%>/member/save";
//	$("#user_id").prop("disabled", false); 
//		-> disabled 쓰고 싶은데 폼 전송으로 값 전달도 해야 하면 submit 전에 disabled 해제
	frm.submit();
}
function goIdcheck(){
	let user_id = $("#user_id").val().trim();
	
	if(user_id==""){
		alert("아이디를 입력하세요");
		$("#user_id").focus();
		return;
	}
	
	$.ajax({
		url:"<%=request.getContextPath()%>/member/idcheck",
		data: {"user_id":user_id},
		method: "POST",
		dataType: "JSON"
	})
	.done(function (response){
		if(response.result=="success"){
			$("#idcheck").val("Y");
			$("#user_id").prop("readonly", true);
			/* 
			prop("disabled",true)로 하면 파라미터 값이 안 넘어감
			readonly : input type="text" 에만 가능. 사용자는 value 값을 변경할 수 없음.
			disabled : 모든 input 객체에 대하여 비활성화 처리 가능. Form 전송시 해당 객체는 전송이 안됨.
			*/
			alert("사용가능한 아이디입니다.");
		} else{
			alert("이미 사용중인 아이디입니다.");
		}
	})
	.fail(function (response, status, error){
		console.log(error);
	});
}
</script>
</html>