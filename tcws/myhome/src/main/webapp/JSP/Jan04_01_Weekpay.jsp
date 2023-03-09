<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주급계산</title>
</head>
<body>
	<form name="myform">
		이름: <input type="text" name="username"><br> 
		주당 근무시간: <input type="text" name="workhour"><br> 
		시간당 단가: <input type="text" name="payment"><br>

		<button type="button" id="btnPay">결과확인</button>
	</form>
</body>
<script type="text/javascript">
let btr = document.getElementById("btnPay");

window.onload=()=>{
btr.addEventListener("click", ()=>{
	let frm = document.myform;
	frm.method = "get";
	frm.action = "/myhome/weekpay";
	frm.submit();
})	
}

</script>
</html>