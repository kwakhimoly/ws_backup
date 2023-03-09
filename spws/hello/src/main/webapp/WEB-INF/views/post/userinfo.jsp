<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user info</title>
</head>
<body>
<h1>${dto.getUser_id() }</h1>
<h1>${dto.getUser_name() }</h1>
<h1>${dto.getPhone() }</h1>
<h1>${dto.getEmail() }</h1>
<h1>${dto.getAddress() }</h1>
</body>
</html>