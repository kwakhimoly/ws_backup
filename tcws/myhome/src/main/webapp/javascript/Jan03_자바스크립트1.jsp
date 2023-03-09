<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트1</title>
</head>
<body>
	<h1>자바스크립트 객체 접근 방법</h1>
	<pre>
	id 속성: 하나의 웹페이지에 id는 하나만 가능하다.
			id는 모든 태그에 부여할 수 있는 속성이다.
				var ob1 = document.getElemetById("id 속성");
			동일한 아이디가 여러개 있어도 첫번째 하나만 가져온다.
			
	name 속성: 서버로 정보를 전송가능한 태그만 가질 수 있는 속성이다.
				id와 달리 여러 태그가 같은 이름을 가질 수 있다.
				배열 형태로 접근한다.
				input, select, textarea만 가질 수 있다.
					var obs = document.getElementsByName("name 속성");
				동일 name을 갖는 다른 태그가 없더라도 항상 배열 형태로 처리한다.
					obs[0].value = 4; 인덱스 생략을 할 수 없다.
				name 속성을 갖지 않는 태그들은 innerHTML 속성을 통해 내용을 읽거나 변경할 수 있다.
	class 속성: 보통은 css를 지정하기 위해 사용한다. 배열로
					var obs = document.getElementsByClassName("class 속성");
	tag 명으로 접근 가능:
					var obs = document.getElementsByTagName("tagname");
	최근에 추가:
					querySelector("#id" 또는 ".class" 태그나 name도 가능) -> 단수로 가져온다.
					querySelectorAll("#id" 또는 ".class" 태그나 name도 가능) -> 복수로 가져온다.
	
	form 태그를 이용해 객체 참조를 가져올 수도 있다.
	form 태그 참조 가져오기
	1) document.form의 name 속성;
	2) document.getElementById("form의 id속성");
	3) document.forms[0]; 하나의 페이지에 form이 여러개 있을 수 있어서
		document의 forms라는 배열 객체에 폼에 대한 참조가 저장되어 있다.
		이 셋 중 하나로 form 개체를 가져올 수 있다.
	
	form객체.name속성 형태로 접근 가능하다.
		
		var frm = document.myform;
		if(frm.userid.valuee=="")....
	</pre>
	
	<h3>자바</h3>
	<h3>Jsp</h3>
	<h3>서블릿</h3>
	<h3>React</h3>
	
	<h2 id="want1">커피</h2>
	<h2 id="want2">초코</h2>
	<h2 id="want3">마시멜로</h2>
</body>
<script>
	/* 글자색 변경하기 */
	var obs = document.getElementsByTagName("h3");
	var bs = document.getElementsByTagName("h2");
	
	/* javascript for문 */
	for(i = 0; i < bs.length; i++){
		bs[i].style.color = "#ff0000"
	}
	
	/* for(i in bs){
		bs[i].style.color = "#ff0000"
	} */ // => in 연산자는 배열로부터 인덱스를 가져온다. => 모던 스크립트에서 추가된 문법이 기존 시스템하고 충돌난다.
		// => style.color처럼 스타일 지정하는 형식은 안 됨.
	
	for ( var i in bs) {
		console.log(bs[i]);
	}
	
	for(ob of obs){
		ob.style.color = "ff0000"
	} // => of 연산자는 배열로부터 차례로 참조를 하나씩 가져온다.
	
	/* obs 배열 속에서 한 개 씩 ob로 꺼내기 */
	for (let ob of obs) {
		ob.style.color = "#13baed"
	}
	
	var ob1 = document.getElementById("want1");
	console.log(ob1);
	/* console.log(ob1.length); */ // -> 배열이 아니라 객체 하나만 오기 때문에 undefined 처리 됨.
	ob1.style.color = "darksalmon";
	
	colors= ["", "lightblue", "lightgreen", "lightpink"]
	for (var i = 1; i < 4; i++) {
		document.getElementById("want"+i).style.color = colors[i];
	}
</script>
</html>
