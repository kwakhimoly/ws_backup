<%@page import="com.kosa.mvc1.index.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<!-- 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> -->
<%-- <%@ include file="/include/navbar.jsp"%> -> 부트 스트랩 버전 차이 때문에 충돌남 --%>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>



<body>

		<%
		List<IndexDto> listI = (List<IndexDto>) request.getAttribute("listImg");
		List<IndexDto> listT = (List<IndexDto>) request.getAttribute("listTxt");
		%>

		<div class="container">
			<h2></h2>
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<%
					for (int i = 0; i < listI.size(); i++) {
					%>
					<li data-target="#myCarousel" data-slide-to="<%=i%>"
						<%if (i == 0) {%> class="active" <%}%>></li>
					<%
					}
					%>
				</ol>


				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<%
					for (int i = 0; i < listI.size(); i++) {
						IndexDto dto = listI.get(i);
						if (i == 0) {
					%>
					<div class="item active">
						<%
						} else {
						%>
						<div class="item">
							<%
							}
							%>
							<a href="<%=request.getContextPath()%>/gallery.do?cmd=view&seq=<%=dto.getSeq()%>">
								<img src="<%=request.getContextPath()%>/upload/gallery/<%=dto.getImage()%>" alt="<%=dto.getSeq()%>" style="width: 100%; height:650px;">
							</a>
						</div>
						<%} %>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>


				<div class="container" style="margin-top: 30px">
					<%
					for (int i = 0; i < listT.size(); i++) {
						IndexDto dto2 = listT.get(i);
						if (i % 3 == 0 || i == listT.size()) {
					%>
					<div class="row">
						<%
						}
						%>
						<div class="col-sm-4">
							<h3><a href="<%=request.getContextPath()%>/guestbook.do?cmd=view&seq=<%=dto2.getSeq()%>"><%=dto2.getTitle()%></a></h3>
							<p><%=dto2.getWriter()%></p>
						</div>
						<%
						if (i % 3 == 2 || i == listT.size() - 1) {
						%>
					</div>
					<%
					}
					}
					%>
				</div>

					
				<div style="text-align: right; margin-top: 30px">
					<button type="button" class="btn" id="btnHome"
						style="background-color: lavender; color: white">Hello,World</button>
				</div>

			</div>
		</div>
</body>
<script type="text/javascript">
$(()=>{
	$("#btnHome").click(()=>{
		location.href="<%=request.getContextPath()%>/gallery.do";
	});
})
</script>
</html>