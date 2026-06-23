<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>異物クロニクル</title>
	
	<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/login.css">
	
</head>
<body>


<!-- タイトル表示 -->
<h1 class="title1">異物クロニクル</h1>
<h2 class="title2">異物クロニクル</h2>

	<!-- ログインフォーム開始 -->
	<form id="form" action="/f3/LoginServlet" method="post">
	<div class="paper">
		<div class="input-box">
			<label class="vertical-label"></label> 
			<input type="text" class="vertical-input" name="loginId" id="loginId" placeholder="ユーザーID">

		</div>

		<div class="input-box">
			<label class="vertical-label"></label> 
			<input type="password" class="vertical-input" name="password" id="password" placeholder="パスワード入力">
		</div>
	</div>
	
	<!-- ログインボタン -->
	<div class ="loginButton">
	<input type="image"src="${pageContext.request.contextPath}/css/images/loginbutton.png" name="loginButton" id="loginButton" alt="渡してログイン">
	</div>
	</form>

	<!-- 新規登録ボタン -->	
	<div class ="registerButton">
	<a href="${pageContext.request.contextPath}/RegistServlet">
	<input type="image"src="${pageContext.request.contextPath}/css/images/registration.png" name="registerButton" id="registerButton"alt="新規登録">
	</a>
	</div>

<script>
        'use strict';

        document.getElementById('form').onsubmit=function(event){ // フォーム送信時に実行
            let loginId= document.getElementById('form').loginId.value;// loginId入力欄の値を取得
            let password= document.getElementById('form').password.value; // password入力欄の値を取得
            let ans = window.confirm('ログインしてよろしいですか？');// 確認ダイアログ表示

            if(loginId===''||password===''){// IDまたはパスワードが空なら
            
            window.confirm('IDとパスワードを入力してください');// メッセージ表示
            event.preventDefault(); // フォーム送信を中止
            
        }
        
    };        
  </script>

<%String errorMsg =(String)request.getAttribute("errorMsg");/*Servletから送られてきたerrorMsgを取得*/
	if(errorMsg != null){
%>

<script>
	alert("<%= errorMsg %>");
	/*JavaのerrorMsgをJavaScriptのalertで表示*/
</script>

<%}%>

</body>
</html>