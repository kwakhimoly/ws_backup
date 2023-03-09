<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kosa.myapp3.comment.mine.*"%>
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
<%@ include file="../include/navbar.jsp" %>

<%
	String pg = StringUtil.nullToValue(request.getParameter("pg"), "0");
	String seq = StringUtil.nullToValue(request.getParameter("seq"), "");
	BoardDto dto = (BoardDto)request.getAttribute("dto");
	List<CommentDto> list = (List<CommentDto>)request.getAttribute("commentList");
	for(int i =0; i<list.size(); i++){
		CommentDto a = list.get(i);
		System.out.println(a.getSeq());
		System.out.println(a.getBoard_seq());
	}
%>
	<input type="hidden" id="pg" name="pg" value="<%=pg%>">
	<input type="hidden" id="seq" name="seq" value="<%=seq%>">
	<input type="hidden" id="userid" name="userid" value="user02">
	<input type="hidden" id="board_seq" name="board_seq" value="<%=seq%>">
	<input type="hidden" id="group_id" name="group_id" value="<%=dto.getGroup_id()%>">
	<input type="hidden" id="depth" name="depth" value="<%=dto.getDepth()%>">
	<input type="hidden" id="g_level" name="g_level" value="<%=dto.getG_level()%>">
	
	<!-- view에서 mode가 처음으로 값이 들어가게 됨(그래서 value 안 받아와도 됨. 얘가 첫번째 순서. 여기서 타고타고..) -->
	<input type="hidden" id="mode" name="mode">
	
	
	
	<div class="container mt-3">
	  <h3><%=dto.getTitle() %></h3>
	  <p><%=dto.getContents().split("\n")[0] %></p>
	  <!-- contents의 첫번째 줄만(\n으로 split, split 배열의 0번째(=첫번째 줄)) 가져오기 -->
	  
	
	   <table class="table">
	   	<colgroup>
	   		<col width="8%">
			<col width="*">
			<col width="12%">
			<col width="12%">
			<col width="12%">
			<col width="12%">
			<col width="12%">
			<col width="12%">
	   	</colgroup>
	   	
	    <tbody>
	      <tr>
	        <th>제목</th>
	        <td colspan="9"><%=dto.getTitle() %></td>
	      </tr>
	      <tr>
	        <th>작성자</th>
	        <td><%=dto.getUserid() %></td>
	        <th>작성일</th>
	        <td><%=dto.getRegdate() %></td>
	        <th>수정일</th>
	        <td><%=dto.getModdate() %></td>
	        <th>조회수</th>
	        <td><%=dto.getHit() %></td>
	      </tr>
	      <tr>
	        <th>내용</th>
	        <td colspan="9" style="text-align: center;"><%=dto.getContents().replaceAll("\n", "<br>") %></td>
	      </tr>
	      <tr>
	      	<th>첨부파일1</th>
	      	<td colspan="9">
		      	<%if(dto.getFilename1().contains("jpg")||dto.getFilename1().contains("gif")) {
		      	%>
		      		<a href="<%=request.getContextPath()%>/upload/board/<%=dto.getFilename1()%>">
		      		<img alt="file1" src="<%=request.getContextPath()%>/upload/board/<%=dto.getFilename1()%>" 
		      		width="15%"></a><br>
		      	<%} %>
	      	<a href="<%=request.getContextPath() %>/down?path=board&filename=<%=dto.getFilename1() %>" 
	      	class="btn"><%=dto.getFilename1() %></a></td>
	      </tr>
	      <tr>
	      <th>첨부파일2</th>
	      	<td colspan="9">
		      	<%if(dto.getFilename2().contains("jpg")||dto.getFilename2().contains("gif")) {
		      	%>
		      		<a href="<%=request.getContextPath()%>/upload/board/<%=dto.getFilename2()%>">
		      		<img alt="file2" src="<%=request.getContextPath()%>/upload/board/<%=dto.getFilename2()%>"
		      		 width="15%"></a><br>
		      	<%} %>
	      	<a href="<%=request.getContextPath() %>/down?path=board&filename=<%=dto.getFilename2() %>" 
	      	class="btn"><%=dto.getFilename2() %></a></td>
	      </tr>
	      <tr>
	      <th>첨부파일3</th>
	      	<td colspan="9">
	      		<%if(dto.getFilename3().contains("jpg")||dto.getFilename3().contains("gif")) {
	      		%>
	      			<a href="<%=request.getContextPath()%>/upload/board/<%=dto.getFilename3()%>">
	      			<img alt="file3" src="<%=request.getContextPath()%>/upload/board/<%=dto.getFilename3()%>" 
	      			width="15%"></a><br>
	      		<%} %>
	      	<a href="<%=request.getContextPath() %>/down?path=board&filename=<%=dto.getFilename3() %>" 
	      	class="btn"><%=dto.getFilename3() %></a></td>
	      </tr>
	      <!-- 이미지 url(/upload)로 접근하고 싶으면 servlet-context.xml에 
	      <resources mapping="/upload/**" location="/upload/" /> 추가해서 /upload로도 접근할 수 있도록 지정해줘야 함
	       -->
	    </tbody>
	  </table>
	 </div>
	
	
	 <div class="container" style="text-align:right">
		<button type="button" class="btn" style="background-color: lavender" id="btnReply">답글</button>
		<button type="button" class="btn" style="background-color: lavender" id="btnModify">수정</button>
		<button type="button" class="btn" style="background-color: lavender" id="btnDelete" >삭제</button>
		<button type="button" class="btn" style="background-color: lavender" id="btnList">목록</button>
	 <hr style="color: lavender; border : 0px; border-top: 5px dotted #663399;">
	 </div>
	 <%if(session.getAttribute("user_id")!=null){ %>
<!-- 댓글 -->
	<div class="container mt-3">	
		<!-- 댓글 입력창 -->
	<table class="table">
    	<tbody>
      	<tr>
        	<td style="width:80%">
        		 <div class="input-group">
			   		 <textarea name="content_comment" id="content_comment" class="form-control" rows="4"></textarea>
			 	</div>
       		</td>
       		<td style="width:20%">
        		<button type="button" id="btnComment" class="btn" style="background-color: lavender">작성</button>
        	</td>
  	    </tr>
 		</tbody>
	</table>
		<!-- 댓글 리스트 -->
	 <table class="table" id="commentTable" style="text-align: center;">
	 <colgroup>
	 	<col width="25%">
	 	<col width="50%">
	 	<col width="25%">
	 </colgroup>
	   <tbody>
	  <%-- <%for(int i =0; i<list.size(); i++){ 
	    	CommentDto cDto = list.get(i);
	    %>
	      <tr>
	        <td style="text-align: left;"><%= cDto.getUserid()%></td>
	        <td style="text-align: left;"><%= cDto.getContent_comment()%></td>
	        <td style="text-align: right;"><%= cDto.getRegdate()%></td>
	      </tr>
	     <%} %> --%>
	 	</tbody>
	 </table>		
	</div>
	<%} %>
</form>  
</body>
<script>
$(()=>{

	$("#btnReply").click(()=>{
		$("#mode").val("reply");
		$("#myform").prop("action", "<%=request.getContextPath()%>/board/reply");
		$("#myform").submit();
	});
	$("#btnModify").click(()=>{
		$("#mode").val("modify");
		$("#myform").prop("action", "<%=request.getContextPath()%>/board/modify");
		$("#myform").submit();
	});
	$("#btnList").click(()=>{
		$("#myform").prop("action", "<%=request.getContextPath()%>/board/list");
		$("#myform").submit();
	});
	$("#btnDelete").click(()=>{
//		직렬화
		let param = $("#myform").serialize();
//		직렬화 : multipart 아닐 때
//		FormData : multipart 일 때
//		seq=4&group_id=3 ...
		
		$.ajax({
			url: "<%=request.getContextPath()%>/board/board_delete",
			data: param,
			dataType: "JSON"
		})
		.done((res)=>{
			if(res.result=="success"){
				alert(res.message);
				location.href="<%=request.getContextPath()%>/board/list";
			} else{
				alert("실패했습니다.");
			}
		})
		.fail((res, status, error)=>{
			console.log(status);
			console.log(error);
		});
	});
	
	$("#btnComment").click(()=>{
		
		let param = $("#myform").serialize(); 
		console.log(param);
		
		//자바 스크립트를 라이브러리화한게 JQuery
		//Serialize()는 자바스크립트가 아니고 Jquery가 만들었음.
		//board_seq=12&content_comment=문장&userid=test : 직렬화가 해줌
		//=> 근데 이렇게 해서 주려면 userid hidden 태그도 만들어야 함.
		
		
		$.ajax({
			url:"<%=request.getContextPath()%>/comment/write",
//			data:{board_seq:$("#board_seq").val(), content_comment:$("#content_comment").val(), userid:"test01"}, 
			data:param,
			dataType:"JSON"
		})
		.done((res)=>{
			alert(res.message);
			<%-- location.href="<%=request.getContextPath()%>/board/view?seq=<%=seq%>"; --%>
			/* commentList만 다시 불러 오기 */
			loadData();
			
		})
		.fail((res,status,error)=>{
			console.log(status);
			console.log(error);
		});
	})
	
			loadData();
})
//	comment를 읽어와서 table에 추가하기
	function loadData(){
	let board_seq = $("#board_seq").val();
	
	$.ajax({
		url:"<%=request.getContextPath()%>/comment/list",
		data:{board_seq:board_seq},
		dataType:"JSON"
	})
	.done((res)=>{
		console.log(res);
		data = res.data;
		console.log( data );
		
		//기존에 있던 내용은 삭제 
		for(i=$("#commentTable > tbody > tr").length; i>-1; i--)
		{
			$("#commentTable > tbody > tr:last").remove(); //맨 마지막 요소부터 삭제한다 
			//append가 tr로 시작해서 tr로 끝나야 적용이 되는 듯?
		}
		
		data.forEach((item)=>{
			$("#commentTable > tbody ").append("<tr><td>"+ item.userid + "</td><td>"+ item.content_comment + "</td><td>"+ item.regdate + "</td></tr>");
		});
			
	})
	.fail((res,status,error)=>{
		console.log(status);
		console.log(error);
	});
}
</script>
</html>