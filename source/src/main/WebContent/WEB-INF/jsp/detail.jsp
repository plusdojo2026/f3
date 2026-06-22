<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/detail.css">
<meta charset="UTF-8">
<title>作品詳細</title>
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
				<label for="naviFlag"><img
					src="/f3/css/images/prettyAiSitting.png"
					style="width: 10vw; height: auto; top: 20vh;"></label> <input
					type="checkbox" id="naviFlag" style="display: none">

				<div class="navi-background"></div>

				<div id="naviwin" class="navi">
					<span class="close-button"
						onclick="document.getElementById('naviFlag').checked = false;">×</span>
					<br>
					<br>
					<br>
					<br> <a href="" style="color: white;">ログイン</a><br>
					<br> <a href="" style="color: white;">異物探索</a><br>
					<br> <a href="" style="color: white;">通知</a><br>
					<br> <a href="" style="color: white;">設定</a><br>
					<br> <a href="" style="color: white;">ログアウト</a>
				</div>
			</div>
	</header>
	<!--メイン画面構成 -->
	<div class="main">

		<div class="topArea">
			<!--上段 -->
			<!--スライドショー -->
			<div class="slideshow">
				<input type="text" value="スライドショー">
			</div>

			<!--メイン画面構成 右 -->
			<div class="light">

				<!--上の横並び -->
				<div class="topBox">

					<!--合作者一覧 -->
					<div class="collaborator">
						<input type="text" value="合作者一覧">
					</div>

					<!--既存タグ -->
					<div class="tag">
						<input type="text" value="既存タグ">
					</div>
				</div>

				<!--評価ボタンdiv -->
				<div class="evaluate">

					<!-- いいねボタン-->
					<div class="good">
						<img src="/f3/css/images/detail/goodBack.png" class="bottom">
						<!-- マンホール画像-->
						<button class="goodButoon" onclick="good()">
							<img src="/f3/css/images/detail/good.png" class="good-img">
							<!-- ゆび画像-->
						</button>
						<img src="/f3/css/images/detail/goodMessage.png" class="top">
						<!-- メッセージ画像-->
					</div>
					<!-- きもいいねボタン-->
					<div class="grossgood">
						<img src="/f3/css/images/detail/grossgoodBack.png" class="bottom">
						<!-- テントウムシ画像-->
						<button class="goodButoon" onclick="good()">
							<img src="/f3/css/images/detail/good.png" class="good-img">
							<!-- ゆび画像-->
						</button>
						<img src="/f3/css/images/detail/grossgoodMessage.png" class="top">
						<!-- メッセージ画像-->
					</div>
					<!-- こわいいねボタン-->
					<div class="scarygood">
						<img src="/f3/css/images/detail/scarygoodBack.png" class="bottom">
						<!-- 顔面画像-->
						<button class="goodButoon" onclick="good()">
							<img src="/f3/css/images/detail/good.png" class="good-img">
							<!-- ゆび画像-->
						</button>
						<img src="/f3/css/images/detail/scarygoodMessage .png" class="top">
						<!-- メッセージ画像-->
					</div>
				</div>

				<!--タグエリア -->
				<div class="tagErea">
					<input type="text" value="タグ用テキストボックス">
				</div>
			</div>
		</div>

		<div class="bottomArea">
			<!--キャプション -->
			<div class="caption">
				<input type="text" value="キャプション">
			</div>


		</div>
	</div>
	<!--合作者一覧の下 -->
	<div class="bottomRight">
		<!--作品画像サムネと評価ボタンを横並び -->
		<div class="button">


			<!--送信ボタン -->
			<div class="sendButton">
				<button type="button" class="send">
					<img src="/f3/css/images/detail/send.png" alt="送信">
				</button>
			</div>
		</div>
	</div>

	<div id="pop" class="pop">
		<div class="popBox">
			<p class="title">過去の自分への不信感を再検証</p>
			<p></p>

			<span class="close" onclick="closePop()">卑劣</span>

		</div>

	</div>

	<script>
		'use strict';

		function good() {
			//ランダム整数 乱数
			let random = Math.floor(Math.random() * 7);

			//7の時だけ発動
			if (random == 0) {
				document.getElementById("pop").style.display = "flex";
			}
			//コンソールに表示
			console.log("乱数", random);
		}

		function closePop() {
			document.getElementById("pop").style.display = "none";
		}
	</script>

</body>

</html>
