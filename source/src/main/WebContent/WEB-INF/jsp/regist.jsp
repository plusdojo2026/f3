<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>異物クロニクル</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/regist.css">
</head>
<body>

<a href="${pageContext.request.contextPath}/HomeServlet" class="title-link">
<h1 class="title1">異物クロニクル</h1>
<h2 class="title2">異物クロニクル</h2>
</a>

<!-- ナビゲーション -->
<label for="naviFlag"><img src="/f3/css/images/prettyAiSitting.png" style="width: 10vw; height: auto; float:right;"></label>

<input type="checkbox" id="naviFlag" style="display:none">

<div class="navi-background"></div>

<div id="naviwin" class="navi">
    <span class="close-button"onclick="document.getElementById('naviFlag').checked = false;">×</span>
    <br><br><br><br>
    <a href="LoginServlet" style="color: white;">ログイン</a><br><br>
    <a href="PostServlet" style="color: white;">異物探索</a><br><br>
    <a href="HomeServlet" style="color: white;">通知</a><br><br>
    <a href="SettingServlet" style="color: white;">設定</a><br><br>
    <a href="LogoutServlet" style="color: white;">ログアウト</a>

</div>

<form id="registForm"
      action="${pageContext.request.contextPath}/RegistServlet"
      method="post">

<div class="newregist">

	<div class="input-area">
	
		<div class="form-row">
		<label>ユーザ名</label>
		<input type="text"name="userName"id="userName"placeholder="ユーザー名">
		</div>
		
		<div class="form-row">
		<label>ユーザーID</label>
		<input type="text"name="userId"id="userId" placeholder="ユーザーID">
		</div>
		
		<div class="form-row">
		<label>パスワード</label>
		<input type="password"name="password"id="password"placeholder="パスワード">
		</div>
		
		<div class="form-row">
		<label>メールアドレス</label>
		<input type="text"name="mailAddress"id="mailAddress" placeholder="メールアドレス">
		</div>

	</div>
	
	</div>
	</form>
	
	
	<div class="loginButton">
				<a href="${pageContext.request.contextPath}/LoginServlet"> 
				<input type="image"src="${pageContext.request.contextPath}/css/images/loginhome.png"name="loginButton" id="loginButton" alt="ログイン画面"></a>
	</div>
	
	<div class="join">
				<input type="image"src="${pageContext.request.contextPath}/css/images/nyukai.png"name="join" id="join" alt="入会">
	</div>
	
	
	<!-- 利用規約 -->
<div id="termsModal" class="modal">

	<div class="modal-content">

		<h2>利用規約</h2>

		<div class="terms-text">

			<p>
			ログインユーザーは以下の規約に同意なければならない。<br><br>

			【第一条】<br>
			ユーザーは、以下の内容を含む画像・動画・テキストその他のコンテンツを投稿してはならない。<br><br>

			・過度に暴力的、性的、または一般に不快と判断されるセンシティブな内容<br>
			・児童ポルノ、リベンジポルノ、またはそれに類する内容<br>
			・法令または公序良俗に反する内容<br>
			・他者の権利を侵害する内容<br><br>

			運営は、上記に該当すると判断した場合、必要に応じてアカウントを停止させることができる。<br><br>

			【第二条】<br>
			・ユーザーが投稿した画像・動画・テキストその他の投稿データに関する著作権は、当該投稿データの作成または加工に関与したすべてのユーザーに共同著作物として帰属するものとする。<br><br>

			・加工に関与していないユーザーは、当該投稿データに対して著作権その他の権利を主張することはできない。<br><br>

			【第三条】<br>
			ユーザーは、投稿データについて、運営に対し以下の範囲での利用を無償・非独占的・全世界的・期限の定めなく許諾する。<br><br>

			・アプリ内での表示、複製、配布<br>
			・他ユーザーによる二次加工の許可<br>
			・広告、宣伝、プロモーションへの利用<br>
			・運営が必要と判断する形式への改変・編集
			</p>

		</div>

		<div class="termsButtonArea">

			<button type="button" id="regist">
				同意して登録
			</button>

			<button type="button" id="cancel">
				キャンセル
			</button>

		</div>

	</div>

</div>
<script>

/* 入会ボタン */
document.getElementById("join")
.addEventListener("click", function(event){

	event.preventDefault(); // 画像ボタンの送信を止める
	
	// 入力欄取得
	const userName = document.getElementById("userName");
	const userId = document.getElementById("userId");
	const password = document.getElementById("password");
	const mailAddress = document.getElementById("mailAddress");

	// エラーフラグ
	let hasError = false;

	// 一旦赤枠を消す
	userName.classList.remove("error");
	userId.classList.remove("error");
	password.classList.remove("error");
	mailAddress.classList.remove("error");

	// ユーザー名
	if(userName.value.trim() === ""){
		userName.classList.add("error");
		hasError = true;
	}

	// ユーザーID
	if(userId.value.trim() === ""){
		userId.classList.add("error");
		hasError = true;
	}

	// パスワード
	if(password.value.trim() === ""){
		password.classList.add("error");
		hasError = true;
	}

	// メールアドレス
	if(mailAddress.value.trim() === ""){
		mailAddress.classList.add("error");
		hasError = true;
	}

	// 未入力があれば終了
	if(hasError){
		alert("項目を入力してください");
		return;
	}
	
	// パスワード8文字チェック
	if(password.value.length < 8){
		alert("パスワードは8文字以上で入力してください");
		password.classList.add("error");
		return;
	}

	document.getElementById("termsModal").style.display = "block";

});

/* 同意して登録 */
document.getElementById("regist")
.addEventListener("click",function(){

	document.getElementById("registForm").submit();

});

/* キャンセル */
document.getElementById("cancel")
.addEventListener("click",function(){

	document.getElementById("termsModal").style.display="none";

	
});

</script>

	<% String errorMsg =(String)request.getAttribute("errorMsg");if(errorMsg != null){%>
		<script>
			alert("<%= errorMsg %>");
		</script>
	<%}%>
</body>
</html>