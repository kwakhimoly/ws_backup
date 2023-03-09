<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  
</head>
<body>

<%
		String seq = request.getParameter("seq"); //seq 파라미터 값 받아서 조회수 증가하고 데이터 가져오기
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //서버컴의 아이피?
		String userid = "k";
		String pwd = "1234";

		Class.forName(driver); //드라이브 파일 로딩 
		Connection conn = DriverManager.getConnection(url, userid, pwd); //디비 접속 연결 객체 생성
		String sql = "update tb_guestbook set hit = hit+1 "
					+ "where seq= " + seq;
		Statement stmt = conn.createStatement();
		stmt.execute(sql); //insert, update, delete 할 때
		
		sql = "select*from tb_guestbook where seq= "+seq;
		ResultSet rs = stmt.executeQuery(sql);
		String title = "";
		String writer = "";
		String contents = "";
		String hit = "";
		String wdate = "";
		
		if(rs.next()){
			title = rs.getString("title");
			writer = rs.getString("writer");
			contents = rs.getString("content");
			hit = rs.getString("hit");
			wdate = rs.getString("wdate");
		}
		
		rs.close();
		stmt.close();
		conn.close();
		%>
		
		<form name="myform">
<input type="hidden" name="mode" value="modify">
<input type="hidden" name="seq" value="<%=seq %>">

<!-- 메뉴 -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="/myhome2/images/img_avatar1.png" alt="Avatar Logo" 
         style="width:40px;" class="rounded-pill"> 
    </a>
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>  
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Dropdown</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Link</a></li>
            <li><a class="dropdown-item" href="#">Another link</a></li>
            <li><a class="dropdown-item" href="#">A third link</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>




<div class="container mt-3">
  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu in the navbar.</p>
  

   <table class="table">
   	<colgroup>
   		<col width="20%">
   		<col width="30%">
   		<col width="20%">
   		<col width="30%">
   	</colgroup>
    <tbody>
      <tr>
        <th>제목</th>
        <td colspan="3">
        	<%=title %> 
        </td>
      </tr>
      <tr>
        <th>작성자</th>
        <td colspan="3">
        	<%=writer %>
        </td>
      <tr>
        <th>작성일</th>
        <td colspan="3">
        	<%=wdate %>(<%=hit%>) 
        </td>
      </tr>
      <tr>
        <th>내용</th>
        <!-- break-all: area를 벗어나는 text를 화면에 맞춰줌 -->
        
        <td colspan="3" style="word-break: break-all">
        <!-- textarea 태그에서는 엔터키를 \r\n 으로 인식한다. 상세화면에서 보기할 때는 \r\n을 br 태그로 바꿔야 한다. -->
        	 <%=contents.replaceAll("\r\n", "<br>") %>
        </td>
      </tr>
      
      
    </tbody>
  </table>
 </div>


 <div class="container" style="text-align:right">
	<button type="button" id="btnModify" class="btn btn-primary">수정</button> &nbsp; &nbsp;
	<button type="button" id="btnDelete" class="btn btn-primary">삭제</button> &nbsp; &nbsp;
	<button type="button" id="btnList" class="btn btn-primary">목록</button>
 </div>

  </form>
</body>

<script>
window.onload=()=>{
	document.getElementById("btnModify").addEventListener("click", goModify);
	document.getElementById("btnDelete").addEventListener("click", goDelete);
	document.getElementById("btnList").addEventListener("click", goList);
}
function goModify() {
	let frm = document.myform;
	frm.action = "/myhome/guestbook/guestbook_write.jsp";
	frm.submit();
	//수정으로 보낼 때 seq 값 보내줘야 수정이 가능
}
function goDelete() {
	if(confirm("삭제하시겠습니까?")){
		let frm = document.myform;
		frm.mode.value = "delete";
		frm.action = "guestbook_proc.jsp";
		frm.submit();
	}
}
function goList() {
	location.href = "/myhome/guestbook/guestbook_list.jsp";
}
</script>

</html>