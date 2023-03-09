<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.*" %>
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
		String mode = request.getParameter("mode");
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //서버컴의 아이피?
		String userid = "k";
		String pwd = "1234";

		Class.forName(driver); //드라이브 파일 로딩 
		Connection conn = DriverManager.getConnection(url, userid, pwd); //디비 접속 연결 객체 생성
		String sql = "";
		Statement stmt = conn.createStatement();
		
		sql = "select*from tb_guestbook where seq= "+seq;
		ResultSet rs = stmt.executeQuery(sql);
		String title = "";
		String writer = "";
		String content = "";
		String hit = "";
		String wdate = "";
		
		if(rs.next()){
			title = rs.getString("title");
			writer = rs.getString("writer");
			content = rs.getString("content");
			hit = rs.getString("hit");
			wdate = rs.getString("wdate");
		}
		
		rs.close();
		stmt.close();
		conn.close();
		%>
		
		
		
<form name="myform">
<input type="hidden" name="seq" value="<%=seq%>"> 
<input type="hidden" name="mode" value="<%=mode%>">  <!-- value 지정 오류 -->




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
          <a class="nav-link" href="http://localhost:9000/myhome/guestbook/guestbook_list.jsp">List</a>
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
  <h3>Guestbook Write</h3>
  <p>write anything.</p>
  

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
			    name="title" id="title" value="<%=title %>">
			 </div>
        </td>
      </tr>
      <tr>
        <th>작성자</th>
        <td>
        	 <div class="input-group">
			    <input type="text" class="form-control" placeholder="이름을 입력하세요"
			    name="writer" id="writer" value="<%=writer %>">
			 </div>
        </td>
      </tr>
      <tr>
        <th>내용</th>
        <td>
        	 <div class="input-group">
			    <textarea class="form-control" placeholder="내용 입력하세요"
			    name="contents" id="contents" rows="5"><%=content%></textarea>
			 </div>
        </td>
      </tr>
      
      
    </tbody>
  </table>
 </div>


 <div class="container" style="text-align:right">
	<%if(mode.equals("insert")){ %>
	<button type="button" class="btn btn-primary"
	id="btnSend">등록</button>
 <%}else{%>
 	<button type="button" class="btn btn-primary"
	id="btnModify">수정</button>
 <%} %>
 &nbsp;&nbsp;
 <button type="button" class="btn btn-primary"
	id="btnList">목록</button>
 </div>

  </form>
</body>
<script type="text/javascript">
window.onload =()=>{
	
	//1. 버튼에 대한 참조를 가져온다.
	let btnSend = document.getElementById("btnSend");
	let btnModify = document.getElementById("btnModify");
	let btnDelete = document.getElementById("btnDelete");
	
	//2. 버튼 객체에 이벤트 핸들러를 연결한다.
	<%if(mode.equals("insert")){%>
	btnSend.addEventListener("click", (e)=>{
		e.preventDefault;
		let frm = document.myform;
		frm.action = "guestbook_proc.jsp"; //데이터를 db에 저장
		frm.method="post";
		frm.submit();
	})
	<%}else{%>
	btnModify.addEventListener("click", (e)=>{
		e.preventDefault;
		let frm = document.myform;
		frm.action = "guestbook_proc.jsp"; //데이터를 db에 저장
		frm.method="post";
		frm.submit();
	})
	<%}%>
	btnList.addEventListener("click", (e)=>{
		e.preventDefault;
		let frm = document.myform;
		frm.action = "guestbook_list.jsp"; //데이터를 db에 저장
		frm.method="post";
		frm.submit();
	})
}
</script>
</html>