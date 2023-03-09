<%@page import="com.kosa.mvc1.guestbook.GuestbookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook Write</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<%
	String seq = request.getParameter("seq");
	%>
	<form name="myform" id="myform" method="post" enctype="multipart/form-data">
		<input type="hidden" name="cmd" id="cmd"> 
		<input type="hidden" name="seq" id="seq" value="<%=seq%>">
		<%@include file="/include/navbar.jsp"%>



		<div class="container mt-3">
			<h3>이미지 등록</h3>
			<p>select your images</p>

			<table class="table">
				<colgroup>
					<col width="30%">
					<col width="*">
				</colgroup>

				<%
				//forward로 페이지 이동이 되면 이전 페이지에서 받았던 파라미터도 가져온다
				String cmd = request.getParameter("cmd");
				seq = request.getParameter("seq");
				GuestbookDto dto = (GuestbookDto) request.getAttribute("dto");
				if (dto == null) { //cd=list -> cmd=write로 온 경우에는 dto가 없다.
					dto = new GuestbookDto(); //비어있는 객체를 하나 만든다.
				}
				%>
				<tbody>
					<tr>
						<th>제목</th>
						<td>
							<div class="input-group">
								<%
								System.out.println(dto.getTitle());
								%>
								<input type="text" class="form-control" placeholder="제목을 입력하세요"
									name="title" id="title" value="<%=dto.getTitle()%>">

							</div>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<div class="input-group">
								<input type="hidden" name="writer" id="writer"
									value="<%=session.getAttribute("user_id")%>"> <input
									type="text" class="form-control" placeholder="이름을 입력하세요"
									name="user_name" id="user_name" readonly
									value="<%=session.getAttribute("user_name")%>">
							</div>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<div class="input-group">
								<textarea class="form-control" placeholder="내용 입력하세요"
									name="content" id="content" rows="5"><%=dto.getContent()%></textarea>
							</div>
						</td>
					</tr>
					<tr>
						<th>이미지</th>
						<td>
							<div class="input-group">
								<%
								System.out.println(dto.getTitle()+": dto.getTitle()");
								%>
								<input type="file" class="form-control" placeholder="이미지를 선택하세요"
									name="image" id="image">

							</div>
						</td>
					</tr>

				</tbody>
			</table>
		</div>


		<div class="container" style="text-align: right">
			<button type="button" class="btn btn-primary" id="btnSave" value="등록">저장</button>
		</div>



	</form>
</body>
<script type="text/javascript">
//		 url, data : {user_id:"test", password:"1234"};
//		 서버로 전송할 파라미터를 읽어와서 data를 만들어준다.
//		 1.직렬화: 객체를 네트워크나 파일로 그대로 전송하는 기술
//				serialize 이 함수는 id로 접근한다. 그래서 태그에 id가 있어야 한다 
//				파일첨부는 안된다. 
//		 2.FormData 객체를 사용
		
$(()=>{	
$("#btnSave").click(()=>{
		
 		$("#cmd").val("save2"); // ajax 통신에 맞춰서 함수 따로 만들기
/*		let param = $("#myform").serialize();
		console.log(param); */
	
		const formData = new FormData(document.myform);
		console.log(formData);
		
//		const formData = new FormData($("#myform")[0]);
//		console.log(formData); // 키 값하고 값의 형태로 저장한다. 
		
//		keys() -> 키 값만 배열 형태로 가져오는 함수
//		of : 개체 배열로부터 개체를 하나씩 가져오는 연산자

		for(key of formData.keys()){
			console.log(key, formData.get(key));			
		}
		
	$.ajax({
		url:"<%=CONTEXT%>/gallery.do",
		data:formData,
		dataType:"JSON", // 받아올 데이터 타입이 json이다(받아올 때 json으로 받겠다.)
		type:"POST", //파일 전송이라 반드시 POST로(FormData는 파일 전송이 가능)
		enctype:"multipart/form-data", //파일 전송임을 알려주기
		processData:false,
		contentType:false
	})
	.done((response)=>{
		console.log(response);
		if(response.result=="success"){
			alert("글이 등록 되었습니다.");
			location.href="<%=CONTEXT%>/gallery.do?cmd=list&pg=0";
		} else{
			
		}
	})
	.fail((response, status, error)=>{
		console.log(status);
	}); 
})

})
</script>
</html>