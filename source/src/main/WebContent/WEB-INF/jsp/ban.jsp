<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="reportlist">
		<img src="images/ログアウト.png" class="img"><!-- ここにc:forEach -->
		<input type="text" name="caption" value="テストです">
		<button type="button" onclick="playAudio()" class="voice">
			<img src="images/再生ボタン.png" class="voice" alt="再生ボタン">
		</button>
		<input type="text" name="report" value="通報理由">
		<button type="submit" name="ban" class="banbuttun" value="BAN">
			<img src="images/BAN.png" class="ban" alt="BANボタン">
		</button>
	</div>
	<div class="reportlist">
		<img src="images/ログアウト.png" class="img"><!-- ここにc:forEach -->
		<input type="text" name="caption" value="テストです">
		<button type="button" onclick="playAudio()" class="voice">
			<img src="images/再生ボタン.png" class="voice" alt="再生ボタン">
		</button>
		<input type="text" name="report" value="通報理由">
		<button type="submit" name="ban" class="banbuttun" value="BAN">
			<img src="images/BAN.png" class="ban" alt="BANボタン">
		</button>
	</div>
	
<script>
const audio = new Audio("voices/jingle_22.mp3");

function playAudio() {
    audio.currentTime = 0; 
    audio.play();
}
</script>
</body>
</html>