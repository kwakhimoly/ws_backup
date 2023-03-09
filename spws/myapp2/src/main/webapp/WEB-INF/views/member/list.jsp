<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import ="com.kwak.mycompany.common.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

  
</head>
<body>
<%
String pg = request.getParameter("pg");
if(pg==null||pg.equals("")){
	pg="0";
}
%>
<form id="myform" name="myform">
<input type="hidden" name="pg" id="pg" value="<%=pg%>">
<%
int totalCnt = (Integer)request.getAttribute("totalCnt"); //페이징용
%>
<!-- 메뉴 -->
<%@ include file="../include/navbar.jsp"%>





<div class="container mt-3">
  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu in the navbar.</p>
  
   <div class="input-group mt-3 mb-3">
	  <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
	    Dropdown button
	  </button>
	  <ul class="dropdown-menu">
	    <li><a class="dropdown-item" href="#">Link 1</a></li>
	    <li><a class="dropdown-item" href="#">Link 2</a></li>
	    <li><a class="dropdown-item" href="#">Link 3</a></li>
	  </ul>
	  <input type="text" class="form-control" placeholder="Username">
	  <div class="input-group-append">
	  	<button class="btn btn-primary" type="button" >GO</button>
	  </div>
	</div>

   <table class="table" id="mytable">
    <colgroup>
		<col width="10%">
		<col width="18%">
		<col width="18%">
		<col width="*">
		<col width="18%">
	</colgroup>
    <thead class="table" style="background-color: aliceblue">
      <tr>
        <th>번호</th>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>휴대폰 번호</th>
      </tr>
    </thead>
    <tbody>
     

    </tbody>
  </table>
 </div>
 <div class="container" style="text-align:right">
 <%=Pager.makeTag(request, totalCnt, 5) %>
</div>

 <div class="container" style="text-align:right">
	<button type="button" class="btn btn-primary">글쓰기</button>
 </div>

</form>  
</body>
<script>
	$(()=>{
		load_data(); //데이터를 ajax를 이용해 불러와서 jsp에 추가한다.
	})
	
	function load_data(){
		let pg = $("#pg").val(); //바뀐 페이지 값 읽어와서
		$.ajax({
			url:"<%=request.getContextPath()%>/member/list_data",
			data:{pg:pg}, //페이지값 전달하기
			dataType:"JSON",
			method:"POST"
		})
		.done((res)=>{
//			console.log(res);
			res.data.forEach((item)=>{
				tr="<tr><td>"+item.num+"</td>";
				tr+="<td>"+item.user_id+"</td>";
				tr+="<td>"+item.user_name+"</td>";
				tr+="<td>"+item.email+"</td>";
				tr+="<td>"+item.phone+"</td></tr>";
//				console.log(tr);
				$("#mytable > tbody:last").append(tr);
				// > : css에서 접근할 때 소속 부여 (mytable의 tbody의 last줄에)
			})
		})
		.fail((res, status, error)=>{
			console.log(status);
			console.log(error);
		})
	}
	
	function goPage(pg){
		$("#pg").val(pg);
		$("#myform").prop("action", "<%=request.getContextPath()%>/member/list");
		$("#myform").submit();
	}
</script>
</html>