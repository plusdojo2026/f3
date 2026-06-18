<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>ホーム</title>
<link rel="stylesheet" href="/WebContent/css/style.css">
<link rel="stylesheet" href="/WebContent/css/home.css">
</head>
<body>
	<!-- ヘッダー（ここから） -->
	<header>
		<div class="header">
			<a href="login.jsp"><img src="/WebContent/images/home/ログインボタン.png" width="110" height="130" alt=""></a>
			<a href="login.jsp"><img src="/WebContent/images/home/ログアウト.png" width="110" height="130" alt=""></a>
			<a href="login.jsp"><img src="/WebContent/images/home/でべそ.png" width="140" height="120" alt=""></a>
		</div>
		<h1>異物クロニクル</h1>
	</header>
	<!-- ヘッダー（ここまで） -->
	<!-- メイン（ここから） -->
	<main>
	<!-- 画像がくる -->
		<div class="center">
			<a href="post.jsp"><img src="/WebContent/images/home/異物投稿.png" width="105" height="140" alt="" class="post"></a>
			<a href="search.jsp"><img src="/WebContent/images/home/異物探索.png" width="105" height="120" alt="" class="search"></a>
		</div>
		<a href="setting.jsp"><img src="/WebContent/images/home/ホーム画面コイン.png" width="120" height="160" alt="" class="right" id="coin"></a>
	</main>
	<!-- メイン（ここまで） -->
	<!-- フッター（ここから） -->
	<!-- フッター（ここまで） -->
	<!-- JavaScript（ここから） -->

</body>
</html>