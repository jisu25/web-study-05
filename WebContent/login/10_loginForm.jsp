<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5-10. loginForm</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath() %>/LoginServlet">
	<label for="userid">아이디 : </label>
	<input type="text" name="id" id="userid"><br>
	
	<label for="userpwd">비밀번호 : </label>
	<input type="text" name="pwd" id="userpwd"><br>
	
	<input type="submit" value="로그인">
</form>
</body>
</html>