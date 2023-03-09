<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Ajax 테스트</h1>

	<table style="width: 60%; margin: auto; border: 1px solid;">
		<colgroup>
			<col width="50%">
			<col width="50%">
		</colgroup>
		<thead>
			<tr>
				<th>이름</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody id="tbody">

		</tbody>
	</table>

	<button type="button" onclick="loadDoc()">JSON 받아오기</button>



</body>
<script type="text/javascript">
	function loadDoc() {
		let xhttp = new XMLHttpRequest();

		xhttp.onload = function() {
			//JSON 라이브러리
			data = JSON.parse(this.responseText);
			let tbody = document.getElementById("tbody");
			//배열의 요소마다 호출된다.
			
			deleteAll(); //기존의 ㅔ이블 데이터를 모두 삭제하자
			data.forEach((item)=>{
				let row = tbody.insertRow(tbody.rows.length);
				//테이블의 마지막 행을 추가
				
				let cell1 = row.insertCell(0); //0번 칼럼 추가
				let cell2 = row.insertCell(1);
				
				cell1.innerHTML = item.username;
				cell2.innerHTML = item.email;
			})
			
		}

		let url = "receive3.jsp"; //결과를 JSON 형태로 보낸다
		//JSON 데이터 형식이 {"키1":"값1", "키2":"값2", "키3":"값3",...}
		//html 등의 태그도 없어야 한다. 딱 JSON데이터만 전송해야 한다.
		console.log(url);
		xhttp.open("Get", url, true);

		xhttp.send();

	}
	
	function deleteAll() {
		let tbody = document.getElementById("tbody");
		for (var i = tbody.rows.length-1; i >= 0; i--) { //역으로 삭제
			tbody.deleteRow(i);
		}
	}
</script>
</html>