<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者検閲</title>
<link rel="stylesheet" type="text/css" href="css/censorship.css">
</head>
<body>
	<div class="top">
		<div class="logout">
			<a href="/f3/LogoutServlet"><img src="images/teaflower.png"  alt="ログアウト"></a>
			<span class="logoutcap">ログアウト</span>
		</div>
		<div>
			<a href="/f3/CensorshipServlet"><img src="images/adminlogo.png" class="logo" alt="管理者ページ"></a>
		</div>
		<div class="ban">
			<a href="/f3/BanshipServlet"><img src="images/teapott.png" alt="通報確認"></a>
			<span class="bancap">通報確認</span>
		</div>
	</div>
	<!-- ここにc:forEach -->
	<div class="censorlist">
		<img src="images/teaflower.png"><!-- ここにc:forEach -->
		<input type="text" name="caption" value="テストです">
		<button type="button" onclick="playAudio()">音声</button>
		<button type="submit" class="undo" name="undo" value="取り消し">
			<img src="images/teabag.png" alt="取り消しボタン">
		</button>
		<input type="submit" class="login" name="login" value="ログイン">
	</div>
	
<script>
const audio = new Audio("${voice_url}");

function playAudio() {
    audio.currentTime = 0; 
    audio.play();
}
</script>
</body>
</html>