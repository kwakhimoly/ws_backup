<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find PW</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

</head>
<body>
<form name="myform">
<input type="hidden" name="idcheck" id="idcheck" value="N">


<%@ include file="/include/navbar.jsp" %>



<div class="container mt-3">
  <h3>logon</h3>
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
			    <input type="text" class="form-control" 
			    placeholder="아이디를 입력하세요"
			    name="user_id" id="user_id">
			 </div>
        </td>
      </tr>
      <tr>
        <th>이메일</th>
        <td>
        	 <div class="input-group">
			    <input type="text" class="form-control" 
			    placeholder="이메일을 입력하세요"
			    name="email" id="email">
			 </div>
        </td>
      </tr>
      
    </tbody>
  </table>
 </div>


 <div class="container" style="text-align:right">
	<button type="button" class="btn btn-primary" onclick="goFindPW()">비밀번호 찾기</button>
 </div>
<br>
<div class="container" id="findpw" style="text-align:center; font-style: oblique; font-weight: bold;"></div>
  </form>
</body>
<script type="text/javascript">
function goFindPW() {
	let user_id = document.getElementById("user_id").value;
	let email = document.getElementById("email").value;
	
	$.ajax({
		url:"<%=CONTEXT%>/member.do",
		data:{cmd:"findPWPROC", user_id:user_id, email:email},
		dataType:"JSON",
		method:"POST"
	})
	.done((response)=>{
		if(response.result=="success"){
			$("#findpw").html("고객님의 비밀번호는 '"+response.password+"' 입니다.");
		} else{
			alert("일치하는 정보가 없습니다.")
		}
	})
	.fail((request, status, error)=>{
		console.log(error);
	});
	
}



</script>
</html>