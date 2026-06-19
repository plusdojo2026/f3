<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="WebContent/css/search.css">
	<meta charset="UTF-8">
	<title>作品検索</title>
</head>

<body>
	<!--ロゴ -->
	<header>
		<div class="logo">
			<h1>異物クロニクル</h1>
		</div>
		<!--プリティ愛 ナビゲーション-->
		<div class="area">
		<div class="prettyAi">
			<label for="naviFlag"><img src="/f3/css/images/prettyAiSitting.png"
					style="width: 10vw; height: auto; top: 20vh;"></label>

			<input type="checkbox" id="naviFlag" style="display:none">

			<div class="navi-background"></div>

			<div id="naviwin" class="navi">
				<span class="close-button" onclick="document.getElementById('naviFlag').checked = false;">×</span>
				<br><br><br><br>
				<a href="" style="color: white;">ログイン</a><br><br>
				<a href="" style="color: white;">異物探索</a><br><br>
				<a href="" style="color: white;">通知</a><br><br>
				<a href="" style="color: white;">設定</a><br><br>
				<a href="" style="color: white;">ログアウト</a>

			</div>
		</div>

		<!--検索バー -->
		<div class="search">

			<form method="GET" action="/f3/SearchServlet">
				<input type="search" name="search" value="">
			</form>

			<!--表示順セレクト -->
			<select class="display">
				<option>表示順</option>
				<option>新着順</option>
				<option>評価順</option>
			</select>
		</div>
</div>
	</header>

	<!--作品画像サムネと評価ボタンを横並び -->
	<div class="content">
		<!--作品画像サムネ -->
		<div class="thumbnail">
			<img src="images/" class="thumbnail-img">
			<input type="search" name="search" value="サムネイルだよーん">
		</div>
		<div class="evaluate">
			<!-- いいねボタン-->
			<div class="good">
				<img src="/f3/css/images/prettyAiSitting.png" class="bottom"><!-- マンホール画像-->
				<img src="/f3/css/images/prettyAiSitting.png" class="good-img"><!-- ゆび画像-->
				<img src="/f3/css/images/prettyAiSitting.png" class="top"><!-- メッセージ画像-->
			</div>
			<!-- きもいいねボタン-->
			<div class="grossgood">
				<img src="images/grossgoodBack.png" class="bottom"><!-- テントウムシ画像-->
				<img src="images/good.png" class="good-img"><!-- ゆび画像-->
				<img src="images/grossgoodMessage.png" class="top"><!-- メッセージ画像-->
			</div>
			<!-- こわいいねボタン-->
			<div class="scarygood">
				<img src="images/scarygoodBack.png" class="bottom"><!-- 顔面画像-->
				<img src="images/good.png" class="good-img"><!-- ゆび画像-->
				<img src="images/scarygoodMessage .png" class="top"><!-- メッセージ画像-->
			</div>
		</div>
	</div>
	<!--常識を破壊するボタン 再読み込み-->
	<div class="fetch-zoon">
	<button type="button" class="fetch" onclick="window.location.reload(true);">

		<img src="images/load.png"  alt="作品をさらに表示する">
	</button>
</div>


</body>

</html>