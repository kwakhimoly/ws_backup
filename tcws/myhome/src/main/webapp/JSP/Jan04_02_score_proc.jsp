<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "com.myhome.jan03.servlet.CommonUtil" %>
<!-- < %@page import = "java.util.ArrayList" % > 
	: 자바에서 arraylist 쓸 때 import 한 것처럼 jsp도 해야되는데,
	  jsp는 자동으로 해주지 않기 때문에 따로 작성해야 함.
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>score proc</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");

String username = CommonUtil.nullToVal(request.getParameter("userName"), "");
int nKor = Integer.parseInt(CommonUtil.nullToVal(request.getParameter("kor"), "0"));
int nEng = Integer.parseInt(CommonUtil.nullToVal(request.getParameter("eng"), "0"));
int nMat = Integer.parseInt(CommonUtil.nullToVal(request.getParameter("mat"), "0"));
int nTotal = nKor + nEng + nMat;

double avg = nTotal/3.0;
%>
<!-- 변수의 값을 출력할 경우 jsp에서는 아래처럼 한다. < %=변수 % > -->
<%=username %>의 총점은 <%=nTotal %>이고, 평균은 <%=avg %>입니다.


</body>
</html>