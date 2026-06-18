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


</body>
</html>