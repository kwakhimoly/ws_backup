<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kosa.mvc1.guestbook.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- cmd: 해야할 일, seq: db에서 갖고올 데이터 지정 
			guestbook.do?cmd=view&seq=1
				GuestbookDao - getView(String seq);
				select*from tb_guestbook where seq=1;
				
			getView => 서블릿 수정하고 => jsp 이동
	-->

<%
GuestbookDto dto = (GuestbookDto)request.getAttribute("dto");
%>

<ul>
	<li><%=dto.getTitle() %></li>
	<li><%=dto.getWriter() %></li>
	<li><%=dto.getContent() %></li>
	<li><%=dto.getWdate() %></li>
	<li><%=dto.getHit() %></li>
</ul>


</body>
</html>