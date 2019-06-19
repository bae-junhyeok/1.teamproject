<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="test.vo.Room"%>
<%@ page import="test.vo.User"%>
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
					<a href="main.jsp">My Hotels</a>
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
	<%
		String beforeID = request.getParameter("userID");
	%>
	
	<div class="list">
	<table class="listTable" border="1">
		<thead>
			<tr>
				<th>회원 아이디</th>
				<th>회원 이름</th>
				<th>회원 성별</th>
				<th>회원 이메일</th>
			</tr>
		</thead>
			
			<%
				if (session.getAttribute("sessionID") != null) {
					Class.forName("com.mysql.jdbc.Driver");

					Connection conn = null;
					Statement stmt = null;

					
					try
					{
					User user = new User();
					PreparedStatement pstmt = conn.prepareStatement("update user set userID =?,userName=?,userGender=?,userEmail=? where userID ='" + beforeID + "';");
					%>
					<tbody>
					<tr>
						<td><input type="text" value="<%=pstmt.setString(1, user.getUserID()) %>" name="userID"></td>
						<td><input type="text" value="<%=pstmt.setString(2, user.getUserName())%>" name="userName"></td>
						<td><input type="text" value="<%=pstmt.setString(3, user.getUserGender()) %>" name="userGender"></td>
						<td><input type="text" value="<%=pstmt.setString(4, user.getUserEmail()) %>" name="userEmail"></td>
					</tr>
					</tbody>
					
					<%
					
					pstmt.executeUpdate();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}%>
			
			
			
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











