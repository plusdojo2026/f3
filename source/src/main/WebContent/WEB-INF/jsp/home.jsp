<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<!-- ヘッダー（ここから） -->
	<header>
		<div class="header">
			<a href="login.jsp"><img src="/f3/css/images/home/ログインボタン.png" width="110" height="130" alt=""></a>
			<a href="login.jsp"><img src="/f3/css/images/home/ログアウト.png" width="110" height="130" alt=""></a>
			<a href="login.jsp"><img src="/f3/css/images/home/デべそ.png" width="140" height="120" alt="" class="right"></a>
		</div>
		<h1>異物クロニクル</h1>
		<h2>異物クロニクル</h2>
	</header>
	<!-- ヘッダー（ここまで） -->
	<!-- メイン（ここから） -->
	<main>
	<!-- 画像がくる -->
		<div class="form">
			<form action="processing.jsp" method="post">
				<p>加工画像<br>
				<input type="text" name="relay"></p>
			</form>
		</div>
		<div class="center">
			<a href="post.jsp"><img src="/f3/css/images/home/異物投稿.png" width="105" height="140" alt="" class="post"></a>
			<a href="search.jsp"><img src="/f3/css/images/home/異物探索.png" width="105" height="120" alt="" class="search"></a>
			<a href="setting.jsp"><img src="/f3/css/images/home/ホーム画面コイン.png" width="120" height="160" alt="" class="right"></a>
		</div>
	</main>
	<!-- メイン（ここまで） -->
	<!-- フッター（ここから） -->
	<!-- フッター（ここまで） -->
	<!-- JavaScript（ここから） -->

</body>
</html>