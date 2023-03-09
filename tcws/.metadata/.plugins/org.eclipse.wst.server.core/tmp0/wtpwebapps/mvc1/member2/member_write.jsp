<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  
</head>
<body>
<form name="myform">
<input type="hidden" name="idcheck" id="idcheck" value="N">

<%@ include file="/include/navbar.jsp" %>



<div class="container mt-3">
  <h3>sign up</h3>
  <p>회원가입</p>
  

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
			    <input type="text" class="form-control" 
			    placeholder="아이디를 입력하세요"
			    name="user_id" id="user_id">
			    <a href="#none" onclick="goIDCheck()"><span class="input-group-text" >아이디중복체크</span></a>
			 </div>
        </td>
      </tr>
      <tr>
        <th>패스워드</th>
        <td>
        	 <div class="input-group">
			    <input type="password" class="form-control" 
			    placeholder="패스워드를 입력하세요"
			    name="password" id="password">
			 </div>
        </td>
      </tr>
      <tr>
        <th>패스워드확인</th>
        <td>
        	 <div class="input-group">
			    <input type="password" class="form-control" 
			    placeholder="패스워드를 입력하세요"
			    name="password2" id="password2">
			 </div>
        </td>
      </tr>
      <tr>
        <th>이름</th>
        <td>
        	 <div class="input-group">
			    <input type="text" class="form-control" 
			    placeholder="이름을 입력하세요"
			    name="user_name" id="user_name">
			 </div>
        </td>
      </tr>
      <tr>
        <th>이메일</th>
        <td>
        	 <div class="input-group">
			    <input type="email" class="form-control" 
			    placeholder="이메일을 입력하세요"
			    name="email" id="email">
			 </div>
        </td>
      </tr>
      <tr>
        <th>전화번호</th>
        <td>
        	 <div class="input-group">
			    <input type="tel" class="form-control" 
			    placeholder="전화번호를 입력하세요"
			    name="phone" id="phone">
			 </div>
        </td>
      </tr>
    </tbody>
  </table>
 </div>


 <div class="container" style="text-align:right">
	<button type="button" class="btn btn-primary" onclick="goSave()">등록</button>
 </div>

  </form>
</body>
<script type="text/javascript">
function goIDCheck() {
	let xhttp = new XMLHttpRequest();
	let url = "/mvc1/member.do?cmd=idcheck&user_id="+document.getElementById("user_id").value;
	
	xhttp.onload=function(){
		let data = JSON.parse(this.responseText);
		alert(data.result); //JSON에서 아이디 중복 여부 확인하고 result:결과값 형태로 작성해주면 data에 result 값을 받아와서 alert
		console.log(this.responseText);
		
		if(data.result=="success"){
			alert("사용가능한 아이디입니다.");
			document.getElementById("idcheck").value="Y";
			document.getElementById("user_id").disabled=true; //user_id 태그 비활성화
		}
	}
	
	xhttp.open("GET", url, true);
	xhttp.send();
}

function goSave() {
	if(document.getElementById("idcheck").value!="Y"){
		alert("아이디 중복체크를 하세요");
		document.getElementById("user_id").focus();
		return false;
	}
	
	let xhttp = new XMLHttpRequest();
	xhttp.onload=function(){
		let data = JSON.parse(this.responseText);
		if(data.result == "success"){
			alert("회원가입 성공");
			location.href="<%=CONTEXT%>/guestbook.do?cmd=list";
			//메인 페이지로 이동
			//자바스크립트로 페이지 이동 가능
		} else {
			alert("회원가입 실패");
		}
	}
	//파라미터 만들기
	let params = "cmd=member_save"
				+"&user_id="+document.getElementById("user_id").value
				+"&password="+document.getElementById("password").value
				+"&user_name="+document.getElementById("user_name").value
				+"&phone="+document.getElementById("phone").value
				+"&email="+document.getElementById("email").value;
				
	console.log(params);
	xhttp.open("POST", "/mvc1/member.do", true);
	xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
	xhttp.send(params);
	//파일 전송시엔 다른 거 쓴다. 
}
</script>
</html>