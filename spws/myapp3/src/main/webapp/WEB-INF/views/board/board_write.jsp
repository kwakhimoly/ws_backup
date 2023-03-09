<%@page import="com.kosa.myapp3.common.*"%>
<%@page import="com.kosa.myapp3.board.*"%>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
<form id="myform" name="myform">
<!-- 메뉴 -->
<%@ include file="../include/navbar.jsp"%>

<%
//		수정, 답글, 추가
//		if 문으로 상황에 따라 다르게 동작하게 하는 것보다는 똑같이 dto 객체를 만들어 보내는 것이 프로그램이 편하다
//		수정 - 수정할 글 정보 Dto
//		답글 - 원글에 대한 정보 Dto
//		추가 - 비어있는 Dto
	BoardDto dto = (BoardDto)request.getAttribute("boardDto");

	String mode = StringUtil.nullToValue(request.getParameter("mode"), "insert");
	String seq = StringUtil.nullToValue(request.getParameter("seq"), "-1");
%>

<input type="hidden" id="mode" name="mode" value="<%=mode %>">
<input type="hidden" id="seq" name="seq" value="<%=seq %>">


<div class="container mt-3">
  <h3>게시판 글쓰기	</h3>
  
   <table class="table">
   	<colgroup>
   		<col width="30%">
   		<col width="*">
   	</colgroup>
    <tbody>
      <tr>
        <th>제목</th>
        <td>
        	 <div class="input-group">
			    <input type="text" class="form-control" placeholder="제목을 입력하세요"
			    name="title" id="title" value="<%=dto.getTitle()%>">
			 </div>
        </td>
      </tr>
      <tr>
        <th>작성자</th>
        <td>
        	 <div class="input-group">
			    <input type="hidden" class="form-control" placeholder="이름을 입력하세요"
			    name="userid" id="userid" value="<%=session.getAttribute("user_id")%>">
			    <input type="text" class="form-control" placeholder="이름을 입력하세요"
			    name="username" id="username" value="<%=session.getAttribute("user_name")%>" readonly>
			 </div>
        </td>
      </tr>
      <tr>
        <th>내용</th>
        <td>
        	 <div class="input-group">
			    <textarea class="form-control" placeholder="내용 입력하세요"
			    name="contents" id="contents" rows="5"><%=dto.getContents() %></textarea>
			 </div>
        </td>
      </tr>
      <tr>
        <th>이미지 첨부</th>
        <td>
        	 <%if(!mode.equals("modify")){ %>
	        	 <div class="input-group">
				    <input class="form-control" type="file" placeholder="이미지 파일을 첨부하세요"
				    name="file1" id="file1">
				 </div>
			 <%}else{ %>
	        	 <div class="input-group">
				    <input class="form-control" type="file" placeholder="이미지 파일을 첨부하세요" name="file1" id="file1" style="display: none">
				    <input type="checkbox" id="del1" onclick="goChange('1')" value="1">
				    <input type="text" name="old_name" id="old_name1" value="<%=dto.getFilename1()%>">
				 </div>
			<%} %>
			
			
			<%if(!mode.equals("modify")){ %>
	        	 <div class="input-group">
				    <input class="form-control" type="file" placeholder="이미지 파일을 첨부하세요"
				    name="file2" id="file2">
				 </div> 
			 <%}else{ %>
				 <div class="input-group">
				    <input class="form-control" type="file" placeholder="이미지 파일을 첨부하세요"
				    name="file2" id="file2" style="display: none">
				    <input type="checkbox" id="del2" onclick="goChange('2')" value="2">
				    <input type="text" name="old_name" id="old_name2" value="<%=dto.getFilename2()%>">
				 </div>
			<%} %>		
			
			
			
			<%if(!mode.equals("modify")){ %>	 
	        	 <div class="input-group">
				    <input class="form-control" type="file" placeholder="이미지 파일을 첨부하세요"
				    name="file3" id="file3">
				 </div>
			  <%}else{ %>
				 <div class="input-group">
				    <input class="form-control" type="file" placeholder="이미지 파일을 첨부하세요"
				    name="file3" id="file3" style="display: none">
				    <input type="checkbox" id="del3" onclick="goChange('3')" value="3">
				    <input type="text" name="old_name" id="old_name3" value="<%=dto.getFilename3()%>">
				 </div>
			<%} %>		
        </td>
      </tr>
      
      
    </tbody>
  </table>
 </div>


 <div class="container" style="text-align:right">
	<button type="button" class="btn" style="background-color: lavender" id="btnSave">글쓰기</button>
 </div>

</form>  
</body>
<script>
$(()=>{
	$("#btnSave").click(goSend); 
	//goSend : 함수 주소만 전달(괄호 없어야함)
	
})

function goChange(id){
	if(document.getElementById("del"+id).checked){
		/* 체크박스 누르면 파일 선택 가능하도록 */
		document.getElementById("file"+id).style.display="block";
	} else{
		document.getElementById("file"+id).style.display="none";
	}
}

function goSend(){
	//자바스크립트 ajax로 파일 전송 시 FormData(폼 객체) 함수를 이용해 form에 있는 데이터들을 직렬화 한다.
	//document.폼이름
	//jquery의 경우 $("#폼아이디")[0] : 인덱스 생략 불가
	let frmData = new FormData(document.myform);
	for(key of frmData.keys()){
		console.log(key); 
		//키 출력
		console.log(frmData.get(key)); 
		//값 출력
	}

	let url ="";
	console.log(frmData);
	
	if($("#mode").val()=="insert"){		
	 	url = "<%=request.getContextPath()%>/board/save"
	} else if($("#mode").val()=="reply"){
		url = "<%=request.getContextPath()%>/board/reply_save";
	} else{
		url = "<%=request.getContextPath()%>/board/modify_save";
	}
	
	console.log($("#mode").val(), url);
	
	if($("#mode").val()=="modify"){
		for(i=1; i<=3; i++){
			/* check 안 된 경우만 추가한다. */
			if(!document.getElementById("del"+i).checked){
				frmData.append("del", "");
			} else{
				frmData.append("del", $("#del"+i).val());
			}
		}
	}
	
		let file = frmData.get("file1");
		console.log(file.type);	
		console.log(file.size);	
		
	
	
	$.ajax({
		url:url,
		data:frmData,
		dataType:"json",
		processData:false,
		contentType:false,
		enctype:"multipart/form-data",
		timeout:600000,
		type:"POST"
	})
	.done(function (res){
		alert(res.message);
		location.href="<%=request.getContextPath()%>/board/list";
	})
	.fail(function (res, status, error){
		console.log(status);
		console.log(error);
	})  
}
</script>
</html>