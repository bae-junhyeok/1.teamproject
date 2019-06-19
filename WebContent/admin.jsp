<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="test.vo.Room"%>
<%@ page import="test.dao.RoomDAO"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.PrintWriter"%>	
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Main Page</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/slide.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/list.css" rel="stylesheet" type="text/css">
<style>
* {
	
}

.clear {
	clear: both;
}

div.info {
	width: 300px;
}

div.info ul {
	float: left;
}

div.main li {
	background-color: #e7f7fe;
}
</style>
<meta http-equiv="Content-Type" Content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="slide.js">
	
</script>

<script>
	function Logout() {
		location.href = "Logout.jsp";
	}
</script>


</head>
<body>


	<div id="headerWrap">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="admin.jsp">My Hotels</a>
				</h1>
			</div>

			<div id="menu">
				<ul>
					<li>
						<%
							if (session.getAttribute("sessionID") != null) {
						%>
					
					<li><a>관리자님 환영합니다</a></li>
					<li><a href="Logout.jsp" accesskey="3" title="">로그아웃</a>
						<%
							} else {
						%> <a href="login.jsp" accesskey="3" title="">로그인</a></li>
					<%
						}
					%>
					<li class="current_page_item"><a href="admin.jsp"
						accesskey="1" title="">홈페이지</a></li>
				</ul>
			</div>
		</div>

		<div class="clear"></div>
		<div class="banner">
			<ul>
				<li><img src="images/hotel1.jpg" width="600" height="350px"></li>
				<li><img src="images/hotel2.jpg" width="600" height="350px"></li>
				<li><img src="images/hotel3.jpg" width="600" height="350px"></li>
				<li><img src="images/hotel4.jpg" width="600" height="350px"></li>
				<li><img src="images/hotel5.jpg" width="600" height="350px"></li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">

		<tr>
			<td height="65" align="center" valign="middle" bgcolor="#5A4B34">
				<ul class="sub-menu">
					<li><a href="#guest-room">회원정보</a></li>
					<li><a href="#use-info">회원 예약 현황</a></li>
				</ul>
			</td>
		</tr>
	</table>
	<div class="list">
		<table class="listTable" border="1">
		<thead class="t1">
			<tr>
				<th>회원 아이디</th>
				<th>회원 이름</th>
				<th>회원 성별</th>
				<th>회원 이메일</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
			<%
				if (session.getAttribute("sessionID") != null) {
					Class.forName("com.mysql.jdbc.Driver");

					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;
					String id = (String) session.getAttribute("sessionID");
					try {
						String jdbcDriver = "jdbc:mysql://localhost:3306/bbs?serverTimezone=UTC";
						String dbUser = "root"; //데이터 베이스 계정 
						String dbPass = "cs1234"; //password

						String query = "select * from user";

						conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); //Connection 생성
						stmt = conn.createStatement(); //Statement 생성 
						rs = stmt.executeQuery(query); //쿼리 실행

						while (rs.next()) //쿼리 실행 결과 얻어오기
						{	
							String userID = rs.getString("userID");
							String userName = rs.getString("userName");
							String userGender = rs.getString("userGender");
							String userEmail = rs.getString("userEmail");
							
			%>
			<tbody>
			<tr>
			<form action="memberDelete.do" method="get">
			<%
				out.print("<input type='hidden' name='userID' value='"+userID+"'>");
				out.print("<input type='hidden' name='userName' value='"+userName+"'>");
				out.print("<input type='hidden' name='userGender' value='"+userGender+"'>");
				out.print("<input type='hidden' name='userEmail' value='"+userEmail+"'>");
			%>
				<td><%=userID%></td>
				<td><%=userName%></td>
				<td><%=userGender%></td>
				<td><%=userEmail%></td>
				<td><input type="submit" value="삭제"></td>
				</form>
			</tr>
			</tbody>
			<%
				}
					} catch (SQLException e) {

					}
					rs.close();
					stmt.close();
					conn.close();
				} else {
			%>
			<%
				PrintWriter script = response.getWriter();
					script.println("<script>");

					script.println("alert('로그인 후 이용하실수 있습니다')");

					script.println("history.back()");

					script.println("</script>");
				}
			%>
		</table>
	</div>
	
	
	
	<div class="list">
		<table class="listTable" border="1">
		<thead class="t2">
			<tr>
				<th>회원 아이디</th>
				<th>회원 이름</th>
				<th>회원 성별</th>
				<th>회원 이메일</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
			<%
				if (session.getAttribute("sessionID") != null) {
					Class.forName("com.mysql.jdbc.Driver");

					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;
					//String id = (String) session.getAttribute("sessionID");
					try {
						String jdbcDriver = "jdbc:mysql://localhost:3306/bbs?serverTimezone=UTC";
						String dbUser = "root"; //데이터 베이스 계정 
						String dbPass = "cs1234"; //password

						String query = "select * from user";

						conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); //Connection 생성
						stmt = conn.createStatement(); //Statement 생성 
						rs = stmt.executeQuery(query); //쿼리 실행

						while (rs.next()) //쿼리 실행 결과 얻어오기
						{	
							String userID = rs.getString("userID");
							String userName = rs.getString("userName");
							String userGender = rs.getString("userGender");
							String userEmail = rs.getString("userEmail");
							
							
							
			%>
			<tbody>
			<tr>
			<form action="memberUpdate.jsp" method="get">
			<%
				out.print("<input type='hidden' name='userID' value='"+userID+"'>");
				out.print("<input type='hidden' name='userName' value='"+userName+"'>");
				out.print("<input type='hidden' name='userGender' value='"+userGender+"'>");
				out.print("<input type='hidden' name='userEmail' value='"+userEmail+"'>");
			%>
				<td><%=userID%></td>
				<td><%=userName%></td>
				<td><%=userGender%></td>
				<td><%=userEmail%></td>
				<%
				request.setAttribute(userID,"userID");
				%>
				<td><input type="submit" value="수정"></td>
				</form>
			</tr>
			</tbody>
			<%
				}
					} catch (SQLException e) {

					}
					rs.close();
					stmt.close();
					conn.close();
				} else {
			%>
			<%
				PrintWriter script = response.getWriter();
					script.println("<script>");

					script.println("alert('로그인 후 이용하실수 있습니다')");

					script.println("history.back()");

					script.println("</script>");
				}
			%>
		</table>
	</div>
	
	
	
	
	<div class="list">
		<table class="listTable" border="1">
		<thead class="t3">
			<tr>
				<th>회원 아이디</th>
				<th>객실 이름</th>
				<th>숙박 일자</th>
				<th>숙박 일수</th>
				<th>숙박 인원</th>
				<th>삭제</th>
				
			</tr>
		</thead>
			<%
				if (session.getAttribute("sessionID") != null) {
					Class.forName("com.mysql.jdbc.Driver");

					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;
					String id = (String) session.getAttribute("sessionID");
					try {
						String jdbcDriver = "jdbc:mysql://localhost:3306/bbs?serverTimezone=UTC";
						String dbUser = "root"; //데이터 베이스 계정 
						String dbPass = "cs1234"; //password

						String query = "select * from room";

						conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); //Connection 생성
						stmt = conn.createStatement(); //Statement 생성 
						rs = stmt.executeQuery(query); //쿼리 실행

						while (rs.next()) //쿼리 실행 결과 얻어오기
						{
							String userID = rs.getString("userID");
							String RoomName = rs.getString("RoomName");
							String RoomDate = rs.getString("RoomDate");
							String RoomLong = rs.getString("RoomLong");
							String roomCount = rs.getString("roomCount");
			%>
			<tbody>
			<tr>
			<form action="roomDelete.do" method="get">
			<%
				out.print("<input type='hidden' name='userID' value='"+userID+"'>");
				out.print("<input type='hidden' name='userName' value='"+RoomName+"'>");
				out.print("<input type='hidden' name='userGender' value='"+RoomDate+"'>");
				out.print("<input type='hidden' name='userEmail' value='"+RoomLong+"'>");
				out.print("<input type='hidden' name='userEmail' value='"+roomCount+"'>");
			%>
				<td><%=rs.getString("userID")%></td>
				<td><%=rs.getString("RoomName")%></td>
				<td><%=rs.getString("RoomDate")%></td>
				<td><%=rs.getString("RoomLong")%></td>
				<td><%=rs.getString("roomCount")%></td>
				<td><input type="submit" value="삭제"></td>
				</form>
			</tr>
			</tbody>
			<%
				}
					} catch (SQLException e) {

					}
					rs.close();
					stmt.close();
					conn.close();
				} else {
			%>
			<%
				PrintWriter script = response.getWriter();
					script.println("<script>");

					script.println("alert('로그인 후 이용하실수 있습니다')");

					script.println("history.back()");

					script.println("</script>");
				}
			%>
		</table>
		</div>
	<footer>
		<p>Copyright © [201833015Bae, 201633011Nam, 201833002Kim] All
			rights reserved.</p>
		<p>전화 문의 : 010-1234-5678 / 이메일 : yongInH@naver.com</p>
		<p>입금계좌 : 하나 000-111111-12345 국민 000000-12-345678 / 예금주 : 배남김</p>
	</footer>
</body>
</html>