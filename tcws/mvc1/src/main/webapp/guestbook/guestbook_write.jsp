<%@page import="com.kosa.mvc1.guestbook.GuestbookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook Write</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  
</head>
<body>
<%
String seq = request.getParameter("seq");
%>
<form name="myform" method="post">
<input type="hidden" name="cmd">
<input type="hidden" name="seq" value="<%=seq%>">
<%@include file="/include/navbar.jsp" %>



<div class="container mt-3">
  <h3>방명록 쓰기</h3>
  <p>This example adds a dropdown menu in the navbar.</p>
  
   <table class="table">
   	<colgroup>
   		<col width="30%">
   		<col width="*">
   	</colgroup>
   	
   	<%
   	//forward로 페이지 이동이 되면 이전 페이지에서 받았던 파라미터도 가져온다
   	String cmd = request.getParameter("cmd");
   	seq = request.getParameter("seq");
   	GuestbookDto dto = (GuestbookDto)request.getAttribute("dto");
   	if(dto==null){ //cd=list -> cmd=write로 온 경우에는 dto가 없다.
   		dto=new GuestbookDto(); //비어있는 객체를 하나 만든다.
   	}
   	%>
    <tbody>
      <tr>
        <th>제목</th>
        <td>
        	 <div class="input-group">
        	 <%System.out.println(dto.getTitle());  %>
			    <input type="text" class="form-control" placeholder="제목을 입력하세요"
			    name="title" id="title" value="<%=dto.getTitle()%>">
			  
			 </div>
        </td>
      </tr>
      <tr>
        <th>작성자</th>
        <td>
        	 <div class="input-group">
        	 <input type="hidden" name="writer" id="writer" value="<%=session.getAttribute("user_id")%>">
			    <input type="text" class="form-control" placeholder="이름을 입력하세요"
			    name="user_name" id="user_name" readonly value="<%=session.getAttribute("user_name")%>">
			 </div>
        </td>
      </tr>
      <tr>
        <th>내용</th>
        <td>
        	 <div class="input-group">
			    <textarea class="form-control" placeholder="내용 입력하세요"
			    name="content" id="content" rows="5"><%=dto.getContent() %></textarea>
			 </div>
        </td>
      </tr>
      
      
    </tbody>
  </table>
 </div>


 <div class="container" style="text-align:right">
	<button type="button" class="btn btn-primary" id="btnSave" value="등록">저장</button>
 </div>

	
  
</form>
</body>
<script type="text/javascript">
let btnSave = document.getElementById("btnSave");

btnSave.addEventListener("click",()=>{
	let frm = document.myform;
	frm.action = "<%=CONTEXT%>/guestbook.do";
	<%if(cmd.equals("write")){%>
	frm.cmd.value="save";
	<%}else if(cmd.equals("modify")){%>
	frm.cmd.value="update";
	<%}%>
	frm.submit();
})
</script>
</html>