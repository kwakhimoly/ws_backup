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
	String searchKey = request.getParameter("searchKey");
	String searchKeyword = request.getParameter("searchKeyword");

	if(pg==null||pg.equals("")){
		pg="0";
	}
	
	if(searchKey==null||searchKey.equals("")){
		searchKey="";
	}
	if(searchKeyword==null||searchKeyword.equals("")){
		searchKeyword="";
	}
	int totalCnt = (Integer)request.getAttribute("totalCnt");
%>
<form id="myform" name="myform">
<input id="pg" name="pg" type="hidden" value="<%=pg%>">
<!-- 메뉴 -->
	<%@ include file="../include/navbar.jsp"%>



<div class="container mt-3">

  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu in the navbar.</p>
  
   <div class="input-group mt-3 mb-3">
	  <button type="button" id="select" class="btn dropdown-toggle" style="background-color: aliceblue" data-bs-toggle="dropdown">
	    선택하세요
	  </button>
	  <ul class="dropdown-menu">
	    <li><a class="dropdown-item" href="#none" onclick="goSearchKey('0')">선택</a></li>
	    <li><a class="dropdown-item" href="#none" onclick="goSearchKey('1')">제목</a></li>
	    <li><a class="dropdown-item" href="#none" onclick="goSearchKey('2')">내용</a></li>
	    <li><a class="dropdown-item" href="#none" onclick="goSearchKey('3')">제목+내용</a></li>
	  </ul>
	  <!-- ul 태그는 값을 저장하지 못함. 서버에 보내려면 input 태그에 담아서 보내야 함. -->
	  <input type="hidden" name="searchKey" id="searchKey" value="<%=searchKey%>">
	  <input type="text" class="form-control" name="searchKeyword" id="searchKeyword" value="<%=searchKeyword %>" placeholder="검색어를 입력하세요">
	  <div class="input-group-append">
	  	<button class="btn" style="background-color: aliceblue" type="button" onclick="goSearch()" >GO</button>
	  </div>
	</div>
<div id="contents">
<div>
</div>

</div>
</div>

 <div class="container" style="text-align:right">
  <%=Pager.makeTag(request, totalCnt, 12) %>
</div>

 <div class="container" style="text-align:right">
	<a href="<%=request.getContextPath() %>/gallery/write"><button type="button" class="btn" style="background-color: aliceblue">글쓰기</button></a>
 </div>

  </form>
</body>
<script>
let temp="";
//검색 조건 선택하면 텍스트 바뀌게 하는 거 -> id 부여 후 .html
var select = ["선택하세요", "제목", "내용", "제목+내용"];

$(()=>{
	if($("#searchKey").val()==1){
		$("#select").html(select[1]);
	} else if($("#searchKey").val()==2){
		$("#select").html(select[2]);
	} else if($("#searchKey").val()==3){		
		$("#select").html(select[3]);
	} else{
		$("#select").html(select[0]);
	}
	
		load_data(); //데이터를 ajax를 이용해 불러와서 jsp에 추가한다.
	})
	
function load_data(){
 	let pg = $("#pg").val();
	
	$.ajax({
		url:"<%=request.getContextPath()%>/gallery/galleryList_data",
		data:{pg:pg, searchKey:$("#searchKey").val(), searchKeyword:$("#searchKeyword").val()},
		dataType:"JSON",
		method:"POST"
	})
	.done(function (res){
		
// 		console.log(res);

<%--	member_list랑 똑같은 방법(but 코드가 복잡)
		let i =0;
 		res.data.forEach((item)=>{
			if(i%4==0){
				temp+='<div class="row">';	
			}
			
			temp += '<div class="col-sm-3">';		
			temp += '<div class="thumbnail">';
			temp +=	'<a href="<%=request.getContextPath()%>/upload/'+item.image1+'">';
			temp += '<img src="<%=request.getContextPath()%>/upload/'+item.image1+'" alt="'+item.image1+'" style="width:100%">';
			temp += '<div class="caption">';
			temp += '<p>'+item.title+'</p>';
			temp += '</div>';
			temp += '</a>';
			temp += '</div>';
			temp += '</div>';
			
			if(i%4==3){
				temp += '</div>';	
			}
			i++;
		});
		
	if(!i<12){
		temp += '</div>';	
	}
	
	$("#contents > div:last").append(temp); --%>
	let data = res.data;
	for(i = 0; i<data.length; i++){
		if(i%4==0){
			temp+='<div class="row">';	
		}
		
		temp += '<div class="col-sm-3">';		
		temp += '<div class="thumbnail">';
		temp +=	'<a href="<%=request.getContextPath()%>/upload/'+data[i].image1+'">';
		temp += '<img src="<%=request.getContextPath()%>/upload/'+data[i].image1+'" alt="'+data[i].image1+'" style="width:100%">';
		temp += '<div class="caption">';
		temp += '<p>'+data[i].title+'</p>';
		temp += '</div>';
		temp += '</a>';
		temp += '</div>';
		temp += '</div>';
		
		if(i%4==3||i==data.length-1){
			temp += '</div>';	
		}
		$("#contents").html(temp);
	}
	})
	.fail(function (res, status, error){
		console.log(status);
		console.log(error);
	})
}

function goSearchKey(key){

	$("#select").html(select[key]);
//	searchKey에 value 부여	
	$("#searchKey").val(key);
}

function goSearch(){
	$("#myform").prop("action", "<%=request.getContextPath()%>/gallery/list");
	$("#myform").submit();
}

function goPage(pg){
	$("#pg").val(pg);
	$("#myform").prop("action", "<%=request.getContextPath() %>/gallery/list");
	$("#myform").submit();
}
</script>
</html>