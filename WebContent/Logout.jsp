<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<html>
<head>
    <title> 로그아웃 처리 </title>
</head>
<body>
    <%
        session.invalidate(); // 세션정보 삭제
        response.sendRedirect("main.jsp");
    %>
</body>
</html>
