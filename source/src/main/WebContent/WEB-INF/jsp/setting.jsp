<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>設定</title>
<link rel="stylesheet" href="/WebContent/css/setting.css">
<link rel="stylesheet" href="/WebContent/css/style.css">
</head>
<body>
<!-- どのサーブレットに送るか確認 -->
    <main class="form">
        <form action="SettingServlet" method="post">
		    <input type="text" name="userName" placeholder="ユーザー名"><br>
		    <input type="text" name="mailAddress" placeholder="メールアドレス"><br>
		    <input type="text" name="userId" placeholder="ユーザーID"><br>
		    <input type="password" name="password" placeholder="パスワード"><br>
            <input type="submit" name="submit" value="変更">
            <input type="submit" name="submit" value="退会"><br>
           	<!-- 利用規約と退会ボタンはsubmitではないはず -->  
        </form>
        <form action="SettingServlet" method="post">
           <input type="submit" name="" value="利用規約"> 
        </form>
    </main>
    <!-- ナビゲーション -->
    <label for="naviFlag"><img src="/f3/css/images/prettyAiSitting.png" style="width: 10vw; height: auto; top: 20vh;"></label>
    <input type="checkbox" id="naviFlag" style="display:none">
    <div class="navi-background"></div>
    <div id="naviwin" class="navi">
        <span class="close-button" onclick="document.getElementById('naviFlag').checked = false;">罪</span><br><br><br><br>
        <a href="" style="color: white;">ログイン</a><br><br>
        <a href="" style="color: white;">異物探索</a><br><br>
        <a href="" style="color: white;">通知</a><br><br>
        <a href="" style="color: white;">設定</a><br><br>
        <a href="" style="color: white;">ログアウト</a>
    </div>
</body>
</html>