<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int x = Integer.parseInt(request.getParameter("xValue"));
	int y = Integer.parseInt(request.getParameter("yValue"));

	String oper = request.getParameter("operator");
	String result = "";
	if (oper.equals("1")) {
		result = String.format("%d + %d = %d\t", x, y, x + y);
	} else if (oper.equals("2")) {
		result = String.format("%d - %d = %d\t", x, y, x - y);
	} else if (oper.equals("3")) {
		result = String.format("%d * %d = %d\t", x, y, x * y);
	} else {
		result = String.format("%d / %d = %.2f\r\n", x, y, (double)x / y);
	}
	%>
	<h1><%=result%></h1>
</body>
</html>