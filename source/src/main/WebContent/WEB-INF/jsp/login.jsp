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



<h1 class="title1">異物クロニクル</h1>
<h2 class="title2">異物クロニクル</h2>

	<div class="paper">

		<div class="input-box">
			<label class="vertical-label"></label> 
			<input type="text" class="vertical-input" name="loginId" id="loginId" placeholder="ユーザーID">

		</div>

		<div class="input-box">
			<label class="vertical-label"></label> 
			<input type="text" class="vertical-input" name="password" id="password" placeholder="パスワード入力">
		</div>
	</div>

	<div class ="loginButton">
	<input type="image"src="${pageContext.request.contextPath}/css/images/loginbutton.png" name="loginButton" id="loginButton" alt="渡してログイン">
	
</div>

			
<div class ="registerButton">
	<a href="${pageContext.request.contextPath}/RegistServlet">
	<input type="image"src="${pageContext.request.contextPath}/css/images/registration.png" name="registerButton" id="registerButton"alt="新規登録">
	</a>
</div>


</body>
</html>