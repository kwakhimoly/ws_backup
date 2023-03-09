<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String xVal = request.getParameter("x");

int x = Integer.parseInt(xVal);
for (int i = 1; i <= 9; i++) {
%>
<%=String.format("%d * %d = %d", x, i, x * i)%><br>
<%-- <%out.println(String.format("%d x %d = %d", x, i, x*i)); %><br> --%>
<%
}
%>
