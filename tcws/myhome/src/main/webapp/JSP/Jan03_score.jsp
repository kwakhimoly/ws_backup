<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적처리 - 강사님</title>
</head>
<body>
<!-- 
form 태그 내에 있는 input, select, textarea의 값들만 서버로 넘어간다. 
서버로 전송할 때 위 태그들의 name 속성을 키 값으로 하고 value 속성을 값으로 한다. 

form 태그에는 action 속성과 method 속성이 있다.
값을 안 주면 기본값이 action은 자기 페이지, 자신을 다시 불러온다.
method는 get 방식이다.
action 태그는 button의 type을 button으로 지정하지 않으면 submit 버튼으로 알아 듣는다. -> 결과가 2번 넘어감
type="button"하고 버튼을 누르면 자기 페이지를 다시 불러온다. (결과 확인 버튼을 눌러도 화면이 변하지 않는 이유)
	=> type 지정하는게 중요함 : 데이터를 2번씩 전송하고 싶은게 아니면
-->
<form name="myform" action="/myhome/teacherscore">
이름 : <input type="text" name="userName"><br> 
국어 : <input type="text" name="kor"><br> 
수학 : <input type="text" name="mat"><br> 
영어 : <input type="text" name="eng"><br>

<button id="btnSend">결과</button>

</form>

<!-- 
ctrl-shift-r : 크롬의 캐시를 삭제한다.
css랑, html이나 자바스크립트만 변경하면 이전에 실행되었던 페이지에 대한 정보를 캐시(임시저장)시켜 놓고 캐시된 데이터를 불러와서
바로 바로 반영이 안 되는 경우가 있다. 이때 이 캐시 메모리를 지우는 역할을 한다. 익스는 별도로 메뉴에서 항상 새로고침을 할 수 있게 되어 있다.

캐시
: 문서를 서버로부터 불러와서 내 메모리에 쌓아놓는다. 동일 문서를 서버에 요청 => 바뀐게 없으면 내 메모리에 있는걸 도로 출력 
- SSD(플래쉬메모리 -> 속도가 빠르고 비싸서 차마 쓸 수 없었던 소재) - 대용량의 고속의 보조기억장치로 사용
 -->

</body>
<script type="text/javascript">
	let btnSend = document.getElementById("btnSend");
	
	/* 
	자바에서 comparator 나 comparable 인터페이스
	자바에서 sort를 직접 구현하지 않고, 대부분은 자바가 구현.
	근데 문제가 비교부분은 데이터 타입마다 달라야 한다. 그래서 그 부분만 인터페이스로 만들어서 사용자가 새로 정의해서 보낼 수 있도록 한다.
	개발자가 일부분만 작업을 해도 전체가 다 원활히 돌아가도록 해서 프로그래머의 일을 줄이기 위한 방법이다. -> 이케아의 조립가구(원하는 대로 사서 조립화)
	=> 이벤트 핸들러 방식
	
	버튼에 클릭이 발생하면 두번째 인자로 전달된 함수를 호출해라
	*/
	btnSend.addEventListener("click", (e)=>{
		/* 
		addEventListner의 첫번째 인자는 이벤트의 종류이고
		두번째 인자는 첫번째 인자로 전달되는 이벤트가 발생했을 때 호출될 콜백함수 주소이다. 함수, 함수표현식, 화살표 함수 모두 가능
		이 때 전달될 콜백함수는 발생한 이벤트에 대한 모든 정보들을 갖고 있는 객체를 매개변수로 갖고 있다. 
		이 객체는 시스템이 사용자한테 전달하고 이 정보를 이용해 부가적인 처리를 할 수 있다. 
		
		
		*/
		console.log(e); //객체의 내용을 상세히 확인할 수 있다.
		// 마우스를 클릭 => os의 메세지 루프 => 브라우저 => 이벤트가 발생한 객체의 정보 전달 
		
		console.log(e.target) //이벤트가 발생한 객체 참조를 갖고 있다. 
		
		e.preventDefault(); //원래의 기능을 뺏음 => btnSend가 갖고 있는 submit(); 기능(버튼 타입을 지정하지 않아서 생김) 뺏기
		// 이벤트가 발생한 객체의 고유기능을 막고 나서 다른 기능을 부여한다. 
		let frm = document.myform;
		
		if(frm.userName.value.trim()==""){
			alert("이름을 입력하세요");
			frm.userName.focus();
			return false;
		}
		
		//이미 action 속성에 url 값이 들어가 있어서 url로 이동한다. 
		frm.submit();
	})
</script>
</html>