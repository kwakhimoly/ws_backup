<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="myform">
	<input type="hidden" name="operator" id="operator">
		x : <input type="text" name="x"><br> 
		y : <input type="text" name="y"><br>

		<button type="button" id="btnAdd">더하기</button>
		<button type="button" id="btnSub">빼기</button>
		<button type="button" id="btnMul">곱하기</button>
		<button type="button" id="btnDiv">나누기</button>
		
		<br>
	</form>
</body>
<script>
window.onload=(e)=>{
	let btnAdd = document.getElementById("btnAdd");
	btnAdd.addEventListener("click", goSend);
	btnSub.addEventListener("click", goSend);
	btnMul.addEventListener("click", goSend);
	btnDiv.addEventListener("click", goSend);
}
function goSend(e) {
	
		e.preventDefault(); //target의 기본 이벤트 동작을 막는다.
		let frm = document.myform; //이름 통해 form 객체 찾아감
		let oper = document.getElementById("operator");
		
		if (e.target==btnAdd) {
			document.getElementById("operator").value="add";
		} else if (e.target==btnSub) {
			document.getElementById("operator").value="sub";
		} else if (e.target==btnMul) {
			document.getElementById("operator").value="mul";
		} else if (e.target==btnDiv) {
			document.getElementById("operator").value="div";
		}
		
		/* 공백도 값으로 인식 -> trim() 함수 통해서 데이터 양 쪽의 공백을 없앰
		(실질적으로 없애진 않음. 예를 들면 1(공백) 이렇게 보낼 경우 (공백)을 없애고 공백인가 아닌가 판단 -> 후 1(공백) 전송) */
		if(frm.x.value.trim()==""){
			alert("숫자를 입력하세요");
			frm.x.focus(); //커서를 이동시킨다.
			return false; // return false : 밑에 frm 어쩌고로 못 내려가게 return으로 막기
		}
		if(frm.y.value.trim()==""){
			alert("숫자를 입력하세요");
			frm.y.focus(); //커서를 이동시킨다.
			return false;
		}

		
		frm.method="get"; //get이 기본 방식
		frm.action = "/Jan02myhome/add"; //서블릿 url => add servlet 호출
		frm.submit(); //서버로 전송
		//action에 쓴 url이 받고 전송방식은 method에 지정한 방식으로 보낸다
	}

</script>
</html>