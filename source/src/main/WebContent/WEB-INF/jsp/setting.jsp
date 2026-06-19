<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>設定</title>
<link rel="stylesheet" type="text/css" href="css/setting.css">

</head>
<body>
<h1 class="title1">異物クロニクル</h1>
<h2 class="title2">異物クロニクル</h2>
<!-- どのサーブレットに送るか確認 -->
    <main class="form">
        <form action="SettingServlet" method="post">
		    <input type="text" name="userName" placeholder="ユーザー名" class="username"><br>
		    <input type="text" name="mailAddress" placeholder="メールアドレス" class="mailaddress"><br>
		    <input type="text" name="userId" placeholder="ユーザーID" class="userid"><br>
		    <input type="password" name="password" placeholder="パスワード" class="password"><br>
		    <div class="submit">
            <input type="submit" name="submit" value="変更">
            <input type="submit" name="submit" value="退会"><br>
            </div> 
        </form>
       
        <!-- ポップアップ利用規約 -->
        <label for="popupFlag" class="terms">利用規約</label>
        <input type="checkbox" id="popupFlag" style="display:none">
        <div class="popup-background"></div>

        <div id="popwin" class="popup">
            <span class="close-button" onclick="document.getElementById('popupFlag').checked = false;">罰</span>
        	<h3 style="color: white">利用規約</h3>
        	<p style="color: white">
                        ログインユーザーは以下の規約に同意なければならない。 

            第一条
            ・ユーザーは、以下の内容を含む画像・動画・テキストその他のコンテンツを投稿、してはならない。 
            ・過度に暴力的、性的、または一般に不快と判断されるセンシティブな内容 
            ・児童ポルノ、リベンジポルノ、またはそれに類する内容 
            ・法令または公序良俗に反する内容 
            ・他者の権利を侵害する内容 
            ・運営は、上記に該当すると判断した場合、必要に応じてアカウントを停止させることができる。 
            
            第二条 
            ・ユーザーが投稿した画像・動画・テキストその他の投稿データに関する著作権は、当該投稿データの作成または加工に関与したすべてのユーザーに共同著作物として帰属するものとする。 
            ・加工に関与していないユーザーは、当該投稿データに対して著作権その他の権利を主張することはできない。 

            第三条 
            ・ユーザーは、投稿データについて、運営に対し以下の範囲での利用を無償・非独占的・全世界的・期限の定めなく許諾する。 
            ・アプリ内での表示、複製、配布 
            ・他ユーザーによる二次加工の許可 
            ・広告、宣伝、プロモーションへの利用 
            ・運営が必要と判断する形式への改変・編集 
        	</p>
        	<button id="button1">激しく同意</button>
		</div>
    </main>
    
    <!-- ナビゲーション -->
    <label for="naviFlag" class="prettyAi"><img src="/f3/css/images/prettyAiSitting.png" style="width: 10vw; height: auto; top: 20vh;"></label>
    <input type="checkbox" id="naviFlag" style="display:none">
    <div class="navi-background"></div>
    <div id="naviwin" class="navi">
        <span class="close-button" onclick="document.getElementById('naviFlag').checked = false;">➡➡➡　罰</span><br><br><br><br>
        <a href="WebContent/login.jsp" style="color: white;">ログイン</a><br><br>
        <a href="WebContent/search.jsp" style="color: white;">異物探索</a><br><br>
        <a href="WebContent/.jsp" style="color: white;">通知</a><br><br>
        <a href="WebContent/setting.jsp" style="color: white;">設定</a><br><br>
        <a href="WebContent/login.jsp" style="color: white;">ログアウト</a>
    </div>
    
    <!-- JavaScript -->
    <script>
    document.getElementById('button1').onclick = function() {
        window.alert('同意したね。');
    }
    </script>
</body>
</html>