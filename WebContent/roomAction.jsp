<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="test.dao.RoomDAO"%>
<!-- userdao의 클래스 가져옴 -->

<%@ page import="java.io.PrintWriter"%>
<!-- 자바 클래스 사용 -->

<%
	request.setCharacterEncoding("UTF-8");
%>



<!-- 한명의 회원정보를 담는 user클래스를 자바 빈즈로 사용 / scope:페이지 현재의 페이지에서만 사용-->

<jsp:useBean id="room" class="test.vo.Room" scope="page" />

<jsp:setProperty name="room" property="roomName" />

<jsp:setProperty name="room" property="roomDate" />

<jsp:setProperty name="room" property="roomLong" />

<jsp:setProperty name="room" property="roomCount" />

<jsp:setProperty name="room" property="roomID" />







<!DOCTYPE html>

<html>

<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>jsp 게시판 웹사이트</title>

</head>

<body>

	<%
		if (room.getRoomName() == null || room.getRoomDate() == null || room.getRoomLong() == null

				|| room.getRoomCount() == null) {

			PrintWriter script = response.getWriter();

			script.println("<script>");

			script.println("alert('입력이 안 된 사항이 있습니다.')");

			script.println("history.back()");

			script.println("</script>");

		} else if (session.getAttribute("sessionID") == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");

			script.println("alert('로그인 후 이용하실수 있습니다')");

			script.println("history.back()");

			script.println("</script>");
		} else {

			RoomDAO roomDAO = new RoomDAO(); //인스턴스생성

			int result = roomDAO.insert(room);

			if (result == -1) { // 아이디가 기본키기. 중복되면 오류.

				PrintWriter script = response.getWriter();

				script.println("<script>");

				script.println("alert('오류!')");

				script.println("history.back()");

				script.println("</script>");

			}

			//가입성공

			else {

				PrintWriter script = response.getWriter();

				script.println("<script>");

				script.println("location.href = 'main.jsp'");

				script.println("</script>");

			}

		}
	
		
	%>



</body>

</body>

</html>