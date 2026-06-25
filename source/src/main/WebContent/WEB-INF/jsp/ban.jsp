<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者BAN</title>
<link rel="stylesheet" type="text/css" href="css/ban.css">
</head>
<body>
	<div class="top">
		<div class="logout">
			<a href="/f3/LogoutServlet"><img src="images/ログアウト.png" class="flower" alt="ログアウト"></a>
		</div>
		<div>
			<a href="/f3/BanServlet"><img src="images/adminlogo.png" class="logo" alt="管理者ページ"></a>
		</div>
		<div class="ban">
			<a href="/f3/CensorshipServlet"><img src="images/lid.png" class="censorship" alt="検閲確認"></a>
		</div>
	</div>
	<!-- ここにc:forEach -->
	<c:forEach var="e" items="${ReportList}">
		<div class="reportlist">
			<img src="{e.imageUrl}" class="img">
			<input type="text" name="caption" value="${e.caption}">
			<button type="button" onclick="playAudio('${e.voiceUrl}')" class="voice">
				<img src="images/再生ボタン.png" class="voice" alt="再生ボタン">
			</button>
			<input type="text" name="report" value="${e.reason}">
			<form action="/f3/BanServlet" method="post">
			<input type="hidden" name="userId" value="${e.userId}">
			<button type="submit" name="ban" class="banbuttun" value="BAN">
				<img src="images/BAN.png" class="ban" alt="BANボタン">
			</button>
			</form>
		</div>
	</c:forEach>
	
	
<script>
function playAudio(url) {
	const audio = new Audio(url);
    audio.currentTime = 0; 
    audio.play();
}
</script>
</body>
</html>