<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05-9. invalidate</title>
</head>
<body>
<%
	session.setAttribute("s_name1", "세션에 저장된 첫번째 값");
	session.setAttribute("s_name2", "세션에 저장된 두번째 값");
	session.setAttribute("s_name3", "세션에 저장된 세번째 값");
	
	out.print("<h3> >> 세션값을 삭제하기 전 << </h3>");
	
	Enumeration names;
	names = session.getAttributeNames();
	while(names.hasMoreElements()) {
		String name = names.nextElement().toString();
		String value = session.getAttribute(name).toString();
		out.println(name + " : " + value + "<br>");
	}

	session.invalidate();
	
	out.print("<hr><h3> >> 세션값 전부 삭제 후 << </h3>");
	if(request.isRequestedSessionIdValid() == true) {
		out.print("세션 아이디 유효");
	} else {
		out.print("세션 아이디 유효 X");
		
	}
%>
</body>
</html>