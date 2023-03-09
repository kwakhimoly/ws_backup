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
								<input type="text" class="form-control" placeholder="아이디를 입력하세요" name="user_id" id="user_id"> 
									<button type="button" class="btn" style="background-color: lavender" id="btnIdcheck">아이디중복체크</button>
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
					<tr>
						<th>패스워드확인</th>
						<td>
							<div class="input-group">
								<input type="password" class="form-control" placeholder="패스워드를 입력하세요" name="password2" id="password2">
							</div>
						</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="이름을 입력하세요" name="user_name" id="user_name">
							</div>
						</td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="닉네임을 입력하세요" name="nickname" id="nickname">
							</div>
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>
							<div class="input-group">
								<input type="email" class="form-control" placeholder="이메일을 입력하세요" name="email" id="email">
							</div>
						</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>
							<div class="input-group">
								<input type="tel" class="form-control" placeholder="전화번호를 입력하세요" name="phone" id="phone">
							</div>
						</td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td>
					<div class="input-group">
						<input type="text" class="form-control" name="zipcode" id="sample4_postcode" placeholder="우편번호">
						<input type="button" class="btn" style="background-color: lavender" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
					</div>
						</td>
					</tr>
						
					<tr>
						<th>주소</th>
						<td>
					<div class="input-group">
						<input type="text" class="form-control" name="address1" id="sample4_roadAddress" placeholder="도로명주소">
						<input type="text" class="form-control" id="sample4_jibunAddress" placeholder="지번주소">
						<span id="guide" style="color:#999;display:none"></span>
					</div>
						</td>
					</tr>
					<tr>
						<th>상세 주소</th>
						<td>
					<div class="input-group">
						<input type="text" class="form-control" name="address2" id="sample4_detailAddress" placeholder="상세주소">
						<input type="hidden" class="form-control" id="sample4_extraAddress" placeholder="참고항목">
					</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		</div>

		<div class="container" style="text-align: right">
			<button type="button" class="btn" style="background-color: lavender" id="btnSave">등록</button>
		</div>
	</form>
</body>


<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
    
    $(()=>{
    	
    	$("#btnSave").click(()=>{
    		if(!fnErrorCheck()){
    			return false; 
    		}
    		
    		let data = $("#myform").serialize();
    		$.ajax({
    			url:"<%=request.getContextPath()%>/member/save",
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
    	
    	
    	
    	$("#btnIdcheck").click(()=>{
    		let user_id = $("#user_id").val().trim();
    		
    		if($("#user_id").val().trim().length<6)
			{
				alert("아이디는 6자리 이상이어야 합니다.");
				return false; //함수 종료 
			}
    		
    		$.ajax({
    			url:"<%=request.getContextPath()%>/member/idcheck",
    			data: {"user_id":user_id},
    			method: "POST",
    			dataType: "JSON"
    		})
    		.done((res)=>{
    			alert(res.message);
    			
				if(res.result=="success"){
    			$("#idcheck").val("Y");
    			$("#user_id").prop("readonly", "true");					
    			$("#btnIdcheck").prop("disabled", "true");					
				} else{
				$("#user_id").focus();
				}
    		})
    		.fail((res, status, error)=>{
    			console.log(status);
    			console.log(error);
    		});
    	})
    })
	
    function fnErrorCheck(){
    	if($("#user_id").val().trim().length<6){
    		alert("아이디는 6자리 이상이어야 합니다.");
    		$("#user_id").focus();
    		return false;
    	}
    	
    	if($("#idcheck").val()=="N"){
    		alert("아이디 중복체크를 하세요");
    		$("#user_id").focus();
			return false;    		
    	}
    	
    	if($("#password").val().trim().length<4){
    		alert("비밀번호는 4자리 이상이어야 합니다.");
    		$("#password").focus();
    		return false;
    	}
    	if($("#password").val()!=$("#password2").val()){
    		alert("비밀번호 확인이 일치하지 않습니다.");
    		$("#password2").focus();
    		return false;
    	}
    	if($("#user_name").val().trim().length<1){
    		alert("이름을 입력하세요.");
    		$("#user_name").focus();
    		return false;
    	}
    	if($("#email").val().trim().length<1){
    		alert("이메일을 입력하세요.");
    		$("#email").focus();
    		return false;
    	}
    	
    	
    	return true;
    }

</script>
</html>