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
			<a href="/f3/LogoutServlet"><img src="images/ログアウト.png" class="flower" alt="ログアウト"></a>
		</div>
		<div>
			<a href="/f3/CensorshipServlet"><img src="images/adminlogo.png" class="logo" alt="管理者ページ"></a>
		</div>
		<div class="ban">
			<a href="/f3/BanshipServlet"><img src="images/teapott.png" class="ban" alt="通報確認"></a>
		</div>
	</div>
	<!-- ここにc:forEach -->
	<div class="censorlist">
		<img src="images/ログアウト.png" class="img"><!-- ここにc:forEach -->
		<input type="text" name="caption" value="テストです">
		<button type="button" onclick="playAudio()" class="voice">
			<img src="images/再生ボタン.png" class="voice" alt="再生ボタン">
		</button>
		<button type="submit" class="undo" name="undo" value="取り消し">
			<img src="images/取り消し.png" class="cancel" alt="取り消しボタン">
		</button>
		<button type="submit" class="authorize" name="authorize" value="許可">
			<img src="images/許可.png" class="permission" alt="許可ボタン">
		</button>
	</div>
	<div class="censorlist">
		<img src="images/ログアウト.png" class="img"><!-- ここにc:forEach -->
		<input type="text" name="caption" value="テストです">
		<button type="button" onclick="playAudio()" class="voice">
			<img src="images/再生ボタン.png" class="voice" alt="再生ボタン">
		</button>
		<button type="submit" class="undo" name="undo" value="取り消し">
			<img src="images/取り消し.png" class="cancel" alt="取り消しボタン">
		</button>
		<button type="submit" class="authorize" name="authorize" value="許可">
			<img src="images/許可.png" class="permission" alt="許可ボタン">
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