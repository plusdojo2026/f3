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

<h1 class="title1">異物クロニクル</h1>
<h2 class="title2">異物クロニクル</h2>

<div class="input-box">
	<label class="vertical-label">ユーザー名</label>
	<input type="text" name="userName" id="userName" placeholder="ユーザー名">
</div>

<div class="input-box">
	<label class="vertical-label">ユーザーID</label>
	<input type="text" name="userId" id="userId" placeholder="ユーザーId">
</div>

<div class="input-box">
	<label class="vertical-label">パスワード</label>
	<input type="text" name="password" id="password" placeholder="パスワード">
</div>

<div class="input-box">
	<label class="vertical-label">メールアドレス</label>
	<input type="text" name="mailAddress" id="mailAddress" placeholder="メールアドレス">
</div>

<div class="newregist">
	<input type="image"name="newregist"id="newregist" alt="新規登録">
</div>


</body>
</html>