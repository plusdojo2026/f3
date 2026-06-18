<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/f3/css/post.css">
<meta charset="UTF-8">
<title>異物投稿</title>

</head>
<body>
<!-- タイトルロゴ。画像をもらって挿入せよ -->
<a href="Home.Servlet"><img src="" alt="タイトルロゴ"></a>

<!-- ナビゲーション -->
	<div class="logo">LOGO</div>
	<input type="checkbox" id="menu-toggle" class="menu-toggle">
	<label for="menu-toggle" class="menu-icon">
	<span></span>
	<span></span>
	<span></span>
	</label>
	<nav class="menu">
		<ul>
		<li><a class="naviLetter" href="">ログイン</li>
		<li><a class="naviLetter" href="">異物探索</li>
		<li><a class="naviLetter" href="">通知</li>
		<li><a class="naviLetter" href="">設定</li>
		<li><a class="naviLetter" href="">ログアウト</li>
		</ul>
		</nav>
	
<!-- actionのurlを変更せよ -->
	<form action="/f3/PostServlet" method="post">
		<input type="file" id="image" name="image">
		<input type="text" id="theme" name="theme" placeholder="テーマ（１０文字まで）">
		<input type="range" id="number" name="number">
		<input type="submit" value="投稿">
	</form>

</body>
</html>