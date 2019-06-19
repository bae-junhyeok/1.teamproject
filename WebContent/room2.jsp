<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Main Page</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/slide.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<style>
		*{
			
		}
		.clear{
			clear: both;
		}
	</style>
<meta http-equiv="Content-Type" Content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="slide.js">

</script>
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
			<h1><a href="main.jsp">Yours Hotel</a></h1>
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
				<li><img src="images/room1.jpg" width="600" height="350px"></li>
				<li><img src="images/room2.jpg" width="600" height="350px"></li>
				<li><img src="images/room3.jpg" width="600" height="350px"></li>
				<li><img src="images/room4.jpg" width="600" height="350px"></li>
			</ul>
		</div>
		<div class="clear"></div>
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		
		<tr>
			<td height="65" align="center" valign="middle" bgcolor="#5A4B34">
				<ul class="sub-menu">
					<li><a href="#guest-room">객실</a></li>
					<li><a href="#use-info">이용 정보</a></li>
				</ul>
			</td>
		</tr>
		</table>
		<div class="main">
		<div class="main-title" id="guest-room">예약 가능한 객실</div>
			<ul>
				<li>
					<img src="images/room2.jpg" width="450" height="300px">
					<div class="info">
					<ul>
						<li><h3>디럭스 (Deluxe)</h3></li>
						<li>객실크기: 11m<sup>2</sup></li>
						<li>침구: 싱글베드 2개</li>
						<li>
						<form action="roomAction.jsp">
						<% 
                     String id = (String) session.getAttribute("sessionID");

                     out.print("<input type='hidden' name='roomID' value='"+id+"'>");
                  %>
						<input type="hidden" name="roomName" value="Swimming room">
						숙박일자<input type="text" name="roomDate" placeholder="입력)oo월oo일" ><br><br>
						숙박기간<input type="text" name="roomLong" placeholder="입력)o박o일" ><br><br>
						숙박인원<input type="text" name="roomCount"placeholder="입력)o명" ><br><br>
						<input type="submit" value="예약">
						
						</form>
						</li>
					</ul>
					</div>
			
		</div>
		<div class="using" id="use-info">
			<div class="header-padding"><h2>이용정보</h2></div>
			<div class="using-info">
					<div class="check-in">
					<details>
					<summary><h3>체크인/체크아웃</h3><br></summary>
						<p>체크인 시작시간: 14:00<br>
						체크아웃 마감시간: 12:00<br><br></p>
						</details>
					</div>
					<div class="traffic-info"><details><summary><h3>교통 안내</h3><br></summary>
						<p>시청에서 무료(free) 셔틀버스 이용(15분간격 운영)<br>
						시청까지 거리: 2Km<br>
						도보로 20분소요<br></p>
						</details>
						
					</div>
					<div class="add-info"><details><summary><h3>추가 정보</h3><br></summary>
						<p>조식 요금(객실 요금에 불포함 시): 7000 KRW<br>
						인터넷/Wi-Fi 사용료(1일): 0 KRW<br></p>
						</details>
						
					</div>
					<div class="normal-info"><details><summary><h3>숙소 일반 정보</h3><br></summary>
						<p>금연 객실/층: YES<br>
						바(Bar)/라운지 수: 2<br>
						총 층수: 2<br>
						레스토랑 수: 3<br>
						총 객실 수 : 20<br>
						객실 전압(V): 220<br>
						숙소 건축 연도: 2007<br>
						최근 리모델링 년도: 2019<br></p>
						</details>
						
					</div>
			</div>
		</div>
	<footer>
		<p>Copyright © [201833015Bae, 201633011Nam, 201833002Kim]  All rights reserved.</p>
		<p>전화 문의   : 010-1234-5678  /  이메일  : yongInH@naver.com</p>
		<p>입금계좌  : 하나 000-111111-12345　국민 000000-12-345678  /  예금주  : 배남김</p>
	</footer>
</body>
</html>