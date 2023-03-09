<%@page import="com.kwak.movie.review.ReviewDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Write</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<style type="text/css">
input[type=number] {-webkit-text-security:disc;}
</style>
</head>
<body>
	<form name="myform" id="myform" method="post" enctype="multipart/form-data">
		<input type="hidden" name="cmd" id="cmd"> 
		<%@include file="/include/navbar.jsp"%>


<%
String m_seq = request.getParameter("m_seq");
%>
		<div class="container mt-3">
			<h3>영화 리뷰 작성</h3>
			<p>how was the movie?</p>

			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="20%">
					<col width="10%">
					<col width="20%">
					<col width="10%">
					<col width="20%">
				</colgroup>

				<%
				//forward로 페이지 이동이 되면 이전 페이지에서 받았던 파라미터도 가져온다
				String cmd = request.getParameter("cmd");
				m_seq = request.getParameter("m_seq");
				ReviewDto dto = (ReviewDto) request.getAttribute("dto");
				if (dto == null) { 
					dto = new ReviewDto(); 
				}
				%>
				<tbody>
					<tr>
						<th>영화 제목</th>
						<td>
							<div class="input-group">
								<%
								System.out.println(dto.getM_title());
								%>
								<input type="text" class="form-control" placeholder="영화 제목을 입력하세요"
									name="m_title" id="m_title" value="<%=dto.getM_title() %>">

							</div>
						</td>
						<th>감독</th>
						<td>
							<div class="input-group">
								<%
								System.out.println(dto.getM_director());
								%>
								<input type="text" class="form-control" placeholder="감독의 이름을 입력하세요"
									name="m_director" id="m_director" value="<%=dto.getM_director()%>">
							</div>
						</td>
						<th>주연 배우</th>
						<td>
							<div class="input-group">
								<%
								System.out.println(dto.getM_actor());
								%>
								<input type="text" class="form-control" placeholder="주연 배우의 이름을 입력하세요"
									name="m_actor" id="m_actor" value="<%=dto.getM_actor()%>">
							</div>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="작성자 이름을 입력하세요"
									name="m_writer" id="m_writer" value="<%=dto.getM_writer()%>">
							</div>
						</td>
						<th>감상일</th>
						<td>
							<div class="input-group">
								<input type="date" class="form-control" name="m_date" id="m_date" value="<%=dto.getM_date()%>">
							</div>
						</td>
						<th>비밀번호</th>
						<td>
							<div class="input-group">
								<input type="number" inputmode="numeric" class="form-control" placeholder="비밀번호는 최대 6자리 숫자입니다."
									style="-webkit-text-security:disc" name="m_password" id="m_password" value="<%=dto.getM_password()%>">
							</div>
						</td>
					</tr>
					<tr>
						<th>별점</th>
						<td colspan="5">
							<div class="input-group">
								<input type="text" placeholder="별점을 입력하세요(예시: 3.5)"
									name="m_rate" id="m_rate" style="width: 100%;" value="<%=dto.getM_rate()%>">
							</div>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="5">
							<div class="input-group">
								<textarea class="form-control" placeholder="내용을 입력하세요"
									name="m_review" id="m_review" rows="5" cols="40"><%=dto.getM_review()%></textarea>
							</div>
						</td>
					</tr>
					
					<tr style="column-span: 4">
						<th>이미지</th>
						<td colspan="5">
							<div class="input-group">
								<%
								System.out.println(dto.getM_title()+": 영화 제목");
								%>
								<input type="file" class="form-control" placeholder="이미지를 선택하세요"
									name="m_poster" id="m_poster">

							</div>
						</td>
					</tr>

				</tbody>
			</table>
		</div>


		<div class="container" style="text-align: right">
			<button type="button" class="btn btn-light" style="background-color: lavenderblush" id="btnSave" value="등록">저장</button>
		</div>



	</form>
</body>
<script type="text/javascript">
$(()=>{	
$("#btnSave").click(()=>{
		
 		$("#cmd").val("save");  
 		
		const formData = new FormData(document.myform);
		console.log(formData);

		for(key of formData.keys()){
			console.log(key, formData.get(key));			
		}
		
	$.ajax({
		url:"<%=CONTEXT%>/movie.do",
		data:formData,
		dataType:"JSON", 
		type:"POST",
		enctype:"multipart/form-data",
		processData:false,
		contentType:false
	})
	.done((response)=>{
		console.log(response);
		if(response.result=="success"){
			alert("글이 등록 되었습니다.");
			location.href="<%=CONTEXT%>/movie.do?cmd=list&pg=0";
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