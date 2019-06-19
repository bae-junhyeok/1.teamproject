<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/slide.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>

<meta http-equiv="Content-Type" Content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="slide.js">

</script>
<style>
		*{
			
		}
		.clear{
			clear: both;
		}
	</style>
<script>

function Logout(){
    location.href="Logout.jsp";
}
</script>
</head>
<body>


<div id="headerWrap">
	<div id="header">
		<div id="logo">
			<h1><a href="main.jsp">My Hotels</a></h1>
		</div>
		
		<div id="menu">
		<ul>
		<li>
			<%
        if(session.getAttribute("sessionID") != null){ 
    %>		<li><a><%=session.getAttribute("sessionID") %>님 환영합니다</a></li>
    		<li><a href="Logout.jsp" accesskey="3" title="">로그아웃</a><%}else{%>
			<a href="login.jsp" accesskey="3" title="">로그인</a></li><%} %>
			<li class="current_page_item"><a href="main.jsp" accesskey="1" title="">홈페이지</a></li>
			<li><a href="notice.jsp" accesskey="2" title="">고객지원</a></li>
			
			<li><a href="bascket.jsp" accesskey="4" title="">예약현황</a></li>
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
			<td height="65" align="center" valign="middle" bgcolor="#5A4B34"></td>
		</tr>
		<tr>
			<td height="75" align="center"></td>
		</tr>
		<tr>
	
			<td height="600" align="center" valign="middle"><img src="images/map.PNG"></td>
		</tr>
		<tr>
			<td height="50" align="center"></td>
		</tr>
		<tr>
			<td align="center"><img src="images/way.PNG"></td>
		</tr>
		<tr>
			<td height="57" align="center"></td>
		</tr>
		
	</table>
	<footer>
		<p>Copyright © [201833015Bae, 201633011Nam, 201833002Kim]  All rights reserved.</p>
		<p>전화 문의   : 010-1234-5678  /  이메일  : yongInH@naver.com</p>
		<p>입금계좌  : 하나 000-111111-12345　국민 000000-12-345678  /  예금주  : 배남김</p>
	</footer>
</body>
</html>