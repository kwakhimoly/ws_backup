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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<form name="myform" id="myform">
		<input type="hidden" name="idcheck" id="idcheck" value="N">
		<!-- 메뉴 -->
		<%@ include file="../include/navbar.jsp"%>



		<div class="container mt-3">
			<h3>Login</h3>


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
								<input type="text" class="form-control" placeholder="아이디를 입력하세요" name="user_id" id="user_id"> 
							</div>
						</td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td>
							<div class="input-group">
								<input type="password" class="form-control" placeholder="패스워드를 입력하세요" name="password" id="password">
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		</div>

		<div class="container" style="text-align: right">
			<button type="button" class="btn" style="background-color: lavender" id="btnSave">로그인</button>
		</div>
	</form>
</body>


<script>
    $(()=>{
    	
    	$("#btnSave").click(()=>{
    		if(!fnErrorCheck()){
    			return false; 
    		}
    		
    		let data = $("#myform").serialize();
    		$.ajax({
    			url:"<%=request.getContextPath()%>/member/login_proc",
    			data:data,
    			type:"POST",
    			dataType:"JSON"
    		})
    		.done((res)=>{
    			alert(res.message);
    			if(res.result=="success"){
    				location.href="<%=request.getContextPath()%>/";
    			}
    		})
    		.fail((res, status, error)=>{
    			console.log(status);
    			console.log(error);
    		})
    		
    	})
    	})
    	
	
    function fnErrorCheck(){
    	if($("#user_id").val().trim().length<6){
    		alert("아이디는 6자리 이상이어야 합니다.");
    		$("#user_id").focus();
    		return false;
    	}
    	
    	if($("#password").val().trim().length<4){
    		alert("비밀번호는 4자리 이상이어야 합니다.");
    		$("#password").focus();
    		return false;
    	}
    	return true;
    }

</script>
</html>