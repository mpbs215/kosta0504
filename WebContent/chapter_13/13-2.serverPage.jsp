<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<title>Insert title here</title>

</head>
<body>
		$(param.name)님 반가워요
		메시지 : <%=request.getParameter("message") %>
		현재시간 : <%=new Date().toLocaleString() %>
</body>
</html>