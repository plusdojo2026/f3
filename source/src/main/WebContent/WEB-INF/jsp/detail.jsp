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
		
		
		// ランダムメッセージを格納する配列
	    let b = ['別にええよ、変えんでも。はあ～……おもんな。', 'あんなぁ、そんなんやと立派な嘘つきになれへんで。', '君が明日パンケーキとなりシロップをかけられ臭い口にむさぼられるとして君は果して前と同じにこれに「いいね」を押せるだろうか。',
	    	'間違いを犯すのは人間の特権よ。でも、あなたはいつまで人間でいられるかしら。', 'ガタンゴトンガタンゴトン「えっと……今何か言ったか？」', '次のニュースです。たった今群馬県の高速道路で「いいね輸送車」が襲撃されました。',
	    	'俺に「いいね」は効かんぞっ！','お前も「きもいいね」を押すのか？　凡人め。','うん……わかった、あなたの気持ち。じゃあ、ダンゴムシさんだったら……どう思うかな？',
	    	'ああ～そういう感じ（笑）','知ってるか？　「いいね」って食べられるんだぜ。','すうぅぅぅぅっはあぁぁぁぁっすうぅぅぅぅっはあぁぁぁぁっ。　ああ……新鮮な畏怖の香り！','「ラッコ」「小顔」「小野妹子」何黙ってるの。あなたの番よ。','「いいね」「きもいいね」「こわいいね」この中に一つ偽物がある。',
	    	'逸るな若者よ。よく見極めるのじゃ。','あちゃ～、それ選んじゃいますかあ……。','ぼくね、おおきくなったらね、せかいじゅうのおにいちゃんたちからい～っぱい「こわいいね」をもらえるひとになるんだぁ！','本で読んだことがある。昔だれからも「いいね」をもらえなくて地下鉄にゴマをばらまいた人がいたんだとか。',
	    	'「いいね」の語源は知っているね？　日本人の生命線たる稲の収穫を祝う掛け声「いねぇぇぇっ！」から来るこの言葉はいつしかネット上に繁殖しこの星を覆った。しかし君、人は三日寝なくても案外正気を保てるものだね。','「いいね党」は公約を守らねぇ。そこさえ目を瞑ればましな投票先でさあ。','神は「きもいいねあれ」と言われた。すると、きもいいねがあった。',
	    	'隠し味を選びなさい。','今あなたの選択で世界が滅びたわ。次は間違えないで。','「いいね」は「きもいいね」に強く、「きもいいね」は「こわいいね」に強く、「こわいいね」は「いいね」に強い。そして、俺は誰より弱い。',
	    	'愚者は好きだ。チャンスをやってもどうせ同じ失敗をする。','砂に書いた「いいね」は波にさらわれる。覚えておきなさい。','ハァハァ……どんな拷問をやろうが……無駄だぜ……ハァハァ……「こわいいね」を……飲まされねぇかぎり……俺はぜってえ吐かねぇ。',
	    	'欺瞞の匂いがするわ。','予言してあげる。「きもいいね」を押した人は必ず死ぬわ。','今のトレンドは「きもいいね」なの。','Repeat after me. Kimo I Ine!','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',];

	    // いいねが押された時の処理
	    document.getElementById('b').onclick = function() {
	    // 0~9までの整数のどれか
	    let reconsider = Math.floor(Math.random() * 10);

	    // 10分の1の確率でランダムメッセージが書かれたポップアップウインドウを表示する。if文の比較対象が1である必要はない
	    if(reconsider === 1) {
	                // ランダムメッセージを格納する配列の要素数から一つの整数を選ぶ
	                let bRan = Math.floor(Math.random() * b.length);
	                document.getElementById('b2').textContent = b[bRan];
	            } else {
	                // ユーザーの選択がそのまま送信される処理
	            }
	        }
		
	</script>

</body>

</html>
