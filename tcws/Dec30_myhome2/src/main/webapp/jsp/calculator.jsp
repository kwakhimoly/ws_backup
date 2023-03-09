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

<!-- form 태그 안의 input 태그의 정보를 전송 -->
<input type="hidden" name="operator">
x: <input type="text" name="xValue"><br>
y: <input type="text" name="yValue"><br>

<button type="button" onclick="goSend('1')">+</button>
<button type="button" onclick="goSend('2')">-</button>
<button type="button" onclick="goSend('3')">*</button>
<button type="button" onclick="goSend('4')">/</button>

</form>
</body>

<script type="text/javascript">
function goSend(oper) {
	var frm = document.myform;
	frm.operator.value = oper;
	frm.action = "<%= request.getContextPath()%>/jsp/result2.jsp";
	frm.method = "post";
	frm.submit();
}
</script>

</html>


<!-- 
input, select, text-area 태그에만 정보를 담을 수 있음
button은 데이터를 담을 수 x
onclick : 
이벤트?? => 클릭, 드래그, 더블 클릭
이벤트는 미리 정의 되어 있음 : onclick

var frm = document.myform;
	java script 문서를 지칭하는 객체 : document
	document.(name) : 객체 소환

	var:
	컴파일러 언어(java) => 전체를 다 번역해서 오류가 없어야 실행 됨
	인터프리터 언어(java script) => 한 줄씩 읽고, 번역해서 실행
				단점: 에러 메세지가 다양하지 않음 -> 디버깅이 어려움
				변수 선언의 의미가 없음 => 어차피 전체를 한번에 다 번역하는 게 아니라서..
				script : 독자적인 번역기가 없는 언어
				
db에 데이터를 넣으려면 java 가 필요함
java script는 번역기가 브라우저
 -->